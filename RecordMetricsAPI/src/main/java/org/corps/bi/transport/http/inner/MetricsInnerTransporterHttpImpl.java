package org.corps.bi.transport.http.inner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import org.corps.bi.dao.rocksdb.MetricRocksdbColumnFamilys;
import org.corps.bi.recording.clients.rollfile.RollFileClient.SystemThreadFactory;
import org.corps.bi.recording.exception.TrackingException;
import org.corps.bi.transport.MetricsInnerTransporter;
import org.corps.bi.transport.MetricsTransporterConfig;
import org.corps.bi.transport.http.inner.fetchdata.AbstractFetchDataThread;
import org.corps.bi.transport.http.inner.fetchdata.FetchDataThreadV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetricsInnerTransporterHttpImpl implements MetricsInnerTransporter {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MetricsInnerTransporterHttpImpl.class);
	
	private AtomicBoolean isTransporting=new AtomicBoolean(false);
	
	private  MetricsTransporterConfig transporterConfig;
	
	private  ScheduledExecutorService transporterIntervalService;
	
	private  TriggerThread triggerThread;
	
	public MetricsInnerTransporterHttpImpl() {
		super();
		this.transporterConfig=MetricsTransporterConfig.getInstance();
	}
	
	private synchronized boolean start() {
		if(!this.isTransporting.compareAndSet(false, true)) {
			LOGGER.warn("is transporting now!");
			return false;
		}
		int rollInterval = this.transporterConfig.getTransportInterval();
		if (rollInterval <= 0) {
			throw new TrackingException("RollInterval is error !");
		}
		transporterIntervalService = Executors.newScheduledThreadPool(1,new SystemThreadFactory("metric-inner-transporter-scheduled"));
		
		this.triggerThread=new TriggerThread(this.transporterConfig);
		
		this.transporterIntervalService.scheduleAtFixedRate(triggerThread,rollInterval, rollInterval, TimeUnit.MILLISECONDS);
		
		return true;
	}
	
	private class TriggerThread implements Runnable{
		
		private final ThreadPoolExecutor threadPoolExecutor;
		
		private final MetricsTransporterConfig transporterConfig;
		
		private final Map<String,AtomicLong> metricProcessedRecordNumMap=new ConcurrentHashMap<String, AtomicLong>();
		
		public TriggerThread(MetricsTransporterConfig transporterConfig) {
			super();
			this.transporterConfig=transporterConfig;
			this.threadPoolExecutor = new ThreadPoolExecutor(
					this.transporterConfig.getThreadCoreSize()>1?(this.transporterConfig.getThreadCoreSize()-1):1,		//指的是保留的线程池大小
					this.transporterConfig.getMaxThreadSize(), 	//最大线程池， 指的是线程池的最大大小
					100, 	//指的是空闲线程结束的超时时间
					TimeUnit.SECONDS, 	//表示 keepAliveTime 的单位
					new LinkedBlockingQueue<Runnable>(100000),
					new SystemThreadFactory("metric-inner-transporter-executor"),
					new ThreadPoolExecutor.DiscardPolicy() //直接放弃当前任务
			);
		}

		@Override
		public void run() {
			try {
				
				if(!this.transporterConfig.isTransportOn()) {
					LOGGER.warn("the config properties is_tranpsort_on was updated by hand through the controller or other.");
					return ;
				}
				
				for (MetricRocksdbColumnFamilys metricRocksdbColumnFamily : MetricRocksdbColumnFamilys.values()) {
					this.processMetric(metricRocksdbColumnFamily);
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
		
		private void processMetric(MetricRocksdbColumnFamilys metricRocksdbColumnFamily) {
			
			String metric=metricRocksdbColumnFamily.getMetric();
			
			AtomicLong processedRecordNum=this.getMetricProcessedRecordNum(metric);
			
			AbstractFetchDataThread fetchDataThread=new FetchDataThreadV2(metricRocksdbColumnFamily,this.transporterConfig,processedRecordNum);
			
			this.threadPoolExecutor.submit(fetchDataThread);
		}
		
		private AtomicLong getMetricProcessedRecordNum(String metric) {
			if(!this.metricProcessedRecordNumMap.containsKey(metric)) {
				AtomicLong tmp=new AtomicLong(0);
				this.metricProcessedRecordNumMap.put(metric, tmp);
			}
			
			return this.metricProcessedRecordNumMap.get(metric);
		}
		
		public boolean shutdown() {
			try {
				this.threadPoolExecutor.shutdown();
				return true;
			} catch (Exception e) {
				LOGGER.error(e.getMessage(),e);
				return false;
			}
			
		}
		
	}

	@Override
	public boolean transport() {
		if(!this.transporterConfig.isTransportOn()) {
			LOGGER.info("transport the trigger of tracking on is off.please config the transprot.on to true");
			return false;
		}
		return this.start();
	}

	@Override
	public boolean shutdown() {
		try {
			if(!this.isTransporting.compareAndSet(true, false)) {
				this.isTransporting.set(false);
				LOGGER.warn("there is the other thread set transporting to true.");
				return false;
			}
			this.transporterIntervalService.shutdown();
			this.triggerThread.shutdown();
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			return false;
		}
	}

}
