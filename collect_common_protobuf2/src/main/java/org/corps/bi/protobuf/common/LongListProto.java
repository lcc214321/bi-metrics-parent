// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tools.proto

package org.corps.bi.protobuf.common;

/**
 * Protobuf type {@code common.LongListProto}
 */
public  final class LongListProto extends
    com.google.protobuf.GeneratedMessage
    implements LongListProtoOrBuilder {
  // Use LongListProto.newBuilder() to construct.
  private LongListProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private LongListProto(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final LongListProto defaultInstance;
  public static LongListProto getDefaultInstance() {
    return defaultInstance;
  }

  public LongListProto getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private LongListProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              elements_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            elements_.add(input.readInt64());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              elements_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              elements_.add(input.readInt64());
            }
            input.popLimit(limit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        elements_ = java.util.Collections.unmodifiableList(elements_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.corps.bi.protobuf.common.ToolsProto.internal_static_common_LongListProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.corps.bi.protobuf.common.ToolsProto.internal_static_common_LongListProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.corps.bi.protobuf.common.LongListProto.class, org.corps.bi.protobuf.common.LongListProto.Builder.class);
  }

  public static com.google.protobuf.Parser<LongListProto> PARSER =
      new com.google.protobuf.AbstractParser<LongListProto>() {
    public LongListProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LongListProto(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<LongListProto> getParserForType() {
    return PARSER;
  }

  // repeated int64 elements = 1;
  public static final int ELEMENTS_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Long> elements_;
  /**
   * <code>repeated int64 elements = 1;</code>
   */
  public java.util.List<java.lang.Long>
      getElementsList() {
    return elements_;
  }
  /**
   * <code>repeated int64 elements = 1;</code>
   */
  public int getElementsCount() {
    return elements_.size();
  }
  /**
   * <code>repeated int64 elements = 1;</code>
   */
  public long getElements(int index) {
    return elements_.get(index);
  }

  private void initFields() {
    elements_ = java.util.Collections.emptyList();
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) return isInitialized == 1;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    for (int i = 0; i < elements_.size(); i++) {
      output.writeInt64(1, elements_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < elements_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(elements_.get(i));
      }
      size += dataSize;
      size += 1 * getElementsList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static org.corps.bi.protobuf.common.LongListProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static org.corps.bi.protobuf.common.LongListProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(org.corps.bi.protobuf.common.LongListProto prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code common.LongListProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements org.corps.bi.protobuf.common.LongListProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.corps.bi.protobuf.common.ToolsProto.internal_static_common_LongListProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.corps.bi.protobuf.common.ToolsProto.internal_static_common_LongListProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.corps.bi.protobuf.common.LongListProto.class, org.corps.bi.protobuf.common.LongListProto.Builder.class);
    }

    // Construct using org.corps.bi.protobuf.common.LongListProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      elements_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.corps.bi.protobuf.common.ToolsProto.internal_static_common_LongListProto_descriptor;
    }

    public org.corps.bi.protobuf.common.LongListProto getDefaultInstanceForType() {
      return org.corps.bi.protobuf.common.LongListProto.getDefaultInstance();
    }

    public org.corps.bi.protobuf.common.LongListProto build() {
      org.corps.bi.protobuf.common.LongListProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.corps.bi.protobuf.common.LongListProto buildPartial() {
      org.corps.bi.protobuf.common.LongListProto result = new org.corps.bi.protobuf.common.LongListProto(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        elements_ = java.util.Collections.unmodifiableList(elements_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.elements_ = elements_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.corps.bi.protobuf.common.LongListProto) {
        return mergeFrom((org.corps.bi.protobuf.common.LongListProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.corps.bi.protobuf.common.LongListProto other) {
      if (other == org.corps.bi.protobuf.common.LongListProto.getDefaultInstance()) return this;
      if (!other.elements_.isEmpty()) {
        if (elements_.isEmpty()) {
          elements_ = other.elements_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureElementsIsMutable();
          elements_.addAll(other.elements_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.corps.bi.protobuf.common.LongListProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.corps.bi.protobuf.common.LongListProto) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // repeated int64 elements = 1;
    private java.util.List<java.lang.Long> elements_ = java.util.Collections.emptyList();
    private void ensureElementsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        elements_ = new java.util.ArrayList<java.lang.Long>(elements_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int64 elements = 1;</code>
     */
    public java.util.List<java.lang.Long>
        getElementsList() {
      return java.util.Collections.unmodifiableList(elements_);
    }
    /**
     * <code>repeated int64 elements = 1;</code>
     */
    public int getElementsCount() {
      return elements_.size();
    }
    /**
     * <code>repeated int64 elements = 1;</code>
     */
    public long getElements(int index) {
      return elements_.get(index);
    }
    /**
     * <code>repeated int64 elements = 1;</code>
     */
    public Builder setElements(
        int index, long value) {
      ensureElementsIsMutable();
      elements_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 elements = 1;</code>
     */
    public Builder addElements(long value) {
      ensureElementsIsMutable();
      elements_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 elements = 1;</code>
     */
    public Builder addAllElements(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureElementsIsMutable();
      super.addAll(values, elements_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 elements = 1;</code>
     */
    public Builder clearElements() {
      elements_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:common.LongListProto)
  }

  static {
    defaultInstance = new LongListProto(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:common.LongListProto)
}

