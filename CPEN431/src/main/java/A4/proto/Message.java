package A4.proto;
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

public final class Message {
  private Message() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Msg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes messageID = 1;</code>
     */
    boolean hasMessageID();
    /**
     * <code>required bytes messageID = 1;</code>
     */
    com.google.protobuf.ByteString getMessageID();

    /**
     * <code>required bytes payload = 2;</code>
     */
    boolean hasPayload();
    /**
     * <code>required bytes payload = 2;</code>
     */
    com.google.protobuf.ByteString getPayload();

    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    boolean hasCheckSum();
    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    long getCheckSum();

    /**
     * <code>optional bytes fwdAddress = 4;</code>
     */
    boolean hasFwdAddress();
    /**
     * <code>optional bytes fwdAddress = 4;</code>
     */
    com.google.protobuf.ByteString getFwdAddress();

    /**
     * <code>optional int32 fwdPort = 5;</code>
     */
    boolean hasFwdPort();
    /**
     * <code>optional int32 fwdPort = 5;</code>
     */
    int getFwdPort();
  }
  /**
   * Protobuf type {@code Msg}
   */
  public  static final class Msg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Msg)
      MsgOrBuilder {
    // Use Msg.newBuilder() to construct.
    private Msg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Msg() {
      messageID_ = com.google.protobuf.ByteString.EMPTY;
      payload_ = com.google.protobuf.ByteString.EMPTY;
      checkSum_ = 0L;
      fwdAddress_ = com.google.protobuf.ByteString.EMPTY;
      fwdPort_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Msg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
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
            case 10: {
              bitField0_ |= 0x00000001;
              messageID_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              payload_ = input.readBytes();
              break;
            }
            case 25: {
              bitField0_ |= 0x00000004;
              checkSum_ = input.readFixed64();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              fwdAddress_ = input.readBytes();
              break;
            }
            case 40: {
              bitField0_ |= 0x00000010;
              fwdPort_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Message.internal_static_Msg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Message.internal_static_Msg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Message.Msg.class, Message.Msg.Builder.class);
    }

    private int bitField0_;
    public static final int MESSAGEID_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString messageID_;
    /**
     * <code>required bytes messageID = 1;</code>
     */
    public boolean hasMessageID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes messageID = 1;</code>
     */
    public com.google.protobuf.ByteString getMessageID() {
      return messageID_;
    }

    public static final int PAYLOAD_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString payload_;
    /**
     * <code>required bytes payload = 2;</code>
     */
    public boolean hasPayload() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes payload = 2;</code>
     */
    public com.google.protobuf.ByteString getPayload() {
      return payload_;
    }

    public static final int CHECKSUM_FIELD_NUMBER = 3;
    private long checkSum_;
    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    public boolean hasCheckSum() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    public long getCheckSum() {
      return checkSum_;
    }

    public static final int FWDADDRESS_FIELD_NUMBER = 4;
    private com.google.protobuf.ByteString fwdAddress_;
    /**
     * <code>optional bytes fwdAddress = 4;</code>
     */
    public boolean hasFwdAddress() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional bytes fwdAddress = 4;</code>
     */
    public com.google.protobuf.ByteString getFwdAddress() {
      return fwdAddress_;
    }

    public static final int FWDPORT_FIELD_NUMBER = 5;
    private int fwdPort_;
    /**
     * <code>optional int32 fwdPort = 5;</code>
     */
    public boolean hasFwdPort() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional int32 fwdPort = 5;</code>
     */
    public int getFwdPort() {
      return fwdPort_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasMessageID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasPayload()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCheckSum()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, messageID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, payload_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeFixed64(3, checkSum_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, fwdAddress_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeInt32(5, fwdPort_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, messageID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, payload_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFixed64Size(3, checkSum_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, fwdAddress_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, fwdPort_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Message.Msg)) {
        return super.equals(obj);
      }
      Message.Msg other = (Message.Msg) obj;

      boolean result = true;
      result = result && (hasMessageID() == other.hasMessageID());
      if (hasMessageID()) {
        result = result && getMessageID()
            .equals(other.getMessageID());
      }
      result = result && (hasPayload() == other.hasPayload());
      if (hasPayload()) {
        result = result && getPayload()
            .equals(other.getPayload());
      }
      result = result && (hasCheckSum() == other.hasCheckSum());
      if (hasCheckSum()) {
        result = result && (getCheckSum()
            == other.getCheckSum());
      }
      result = result && (hasFwdAddress() == other.hasFwdAddress());
      if (hasFwdAddress()) {
        result = result && getFwdAddress()
            .equals(other.getFwdAddress());
      }
      result = result && (hasFwdPort() == other.hasFwdPort());
      if (hasFwdPort()) {
        result = result && (getFwdPort()
            == other.getFwdPort());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasMessageID()) {
        hash = (37 * hash) + MESSAGEID_FIELD_NUMBER;
        hash = (53 * hash) + getMessageID().hashCode();
      }
      if (hasPayload()) {
        hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
        hash = (53 * hash) + getPayload().hashCode();
      }
      if (hasCheckSum()) {
        hash = (37 * hash) + CHECKSUM_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getCheckSum());
      }
      if (hasFwdAddress()) {
        hash = (37 * hash) + FWDADDRESS_FIELD_NUMBER;
        hash = (53 * hash) + getFwdAddress().hashCode();
      }
      if (hasFwdPort()) {
        hash = (37 * hash) + FWDPORT_FIELD_NUMBER;
        hash = (53 * hash) + getFwdPort();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Message.Msg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message.Msg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message.Msg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message.Msg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message.Msg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Message.Msg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Message.Msg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Message.Msg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Message.Msg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Message.Msg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Message.Msg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Msg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Msg)
        Message.MsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Message.internal_static_Msg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Message.internal_static_Msg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Message.Msg.class, Message.Msg.Builder.class);
      }

      // Construct using Message.Msg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        messageID_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        payload_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        checkSum_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        fwdAddress_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000008);
        fwdPort_ = 0;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Message.internal_static_Msg_descriptor;
      }

      public Message.Msg getDefaultInstanceForType() {
        return Message.Msg.getDefaultInstance();
      }

      public Message.Msg build() {
        Message.Msg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Message.Msg buildPartial() {
        Message.Msg result = new Message.Msg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.messageID_ = messageID_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.payload_ = payload_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.checkSum_ = checkSum_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.fwdAddress_ = fwdAddress_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.fwdPort_ = fwdPort_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Message.Msg) {
          return mergeFrom((Message.Msg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Message.Msg other) {
        if (other == Message.Msg.getDefaultInstance()) return this;
        if (other.hasMessageID()) {
          setMessageID(other.getMessageID());
        }
        if (other.hasPayload()) {
          setPayload(other.getPayload());
        }
        if (other.hasCheckSum()) {
          setCheckSum(other.getCheckSum());
        }
        if (other.hasFwdAddress()) {
          setFwdAddress(other.getFwdAddress());
        }
        if (other.hasFwdPort()) {
          setFwdPort(other.getFwdPort());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasMessageID()) {
          return false;
        }
        if (!hasPayload()) {
          return false;
        }
        if (!hasCheckSum()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Message.Msg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Message.Msg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString messageID_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public boolean hasMessageID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public com.google.protobuf.ByteString getMessageID() {
        return messageID_;
      }
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public Builder setMessageID(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        messageID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public Builder clearMessageID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        messageID_ = getDefaultInstance().getMessageID();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes payload = 2;</code>
       */
      public boolean hasPayload() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes payload = 2;</code>
       */
      public com.google.protobuf.ByteString getPayload() {
        return payload_;
      }
      /**
       * <code>required bytes payload = 2;</code>
       */
      public Builder setPayload(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        payload_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes payload = 2;</code>
       */
      public Builder clearPayload() {
        bitField0_ = (bitField0_ & ~0x00000002);
        payload_ = getDefaultInstance().getPayload();
        onChanged();
        return this;
      }

      private long checkSum_ ;
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public boolean hasCheckSum() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public long getCheckSum() {
        return checkSum_;
      }
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public Builder setCheckSum(long value) {
        bitField0_ |= 0x00000004;
        checkSum_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public Builder clearCheckSum() {
        bitField0_ = (bitField0_ & ~0x00000004);
        checkSum_ = 0L;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString fwdAddress_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes fwdAddress = 4;</code>
       */
      public boolean hasFwdAddress() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional bytes fwdAddress = 4;</code>
       */
      public com.google.protobuf.ByteString getFwdAddress() {
        return fwdAddress_;
      }
      /**
       * <code>optional bytes fwdAddress = 4;</code>
       */
      public Builder setFwdAddress(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        fwdAddress_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes fwdAddress = 4;</code>
       */
      public Builder clearFwdAddress() {
        bitField0_ = (bitField0_ & ~0x00000008);
        fwdAddress_ = getDefaultInstance().getFwdAddress();
        onChanged();
        return this;
      }

      private int fwdPort_ ;
      /**
       * <code>optional int32 fwdPort = 5;</code>
       */
      public boolean hasFwdPort() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional int32 fwdPort = 5;</code>
       */
      public int getFwdPort() {
        return fwdPort_;
      }
      /**
       * <code>optional int32 fwdPort = 5;</code>
       */
      public Builder setFwdPort(int value) {
        bitField0_ |= 0x00000010;
        fwdPort_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 fwdPort = 5;</code>
       */
      public Builder clearFwdPort() {
        bitField0_ = (bitField0_ & ~0x00000010);
        fwdPort_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Msg)
    }

    // @@protoc_insertion_point(class_scope:Msg)
    private static final Message.Msg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Message.Msg();
    }

    public static Message.Msg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Msg>
        PARSER = new com.google.protobuf.AbstractParser<Msg>() {
      public Msg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Msg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Msg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Msg> getParserForType() {
      return PARSER;
    }

    public Message.Msg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Msg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Msg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rMessage.proto\"`\n\003Msg\022\021\n\tmessageID\030\001 \002(" +
      "\014\022\017\n\007payload\030\002 \002(\014\022\020\n\010checkSum\030\003 \002(\006\022\022\n\n" +
      "fwdAddress\030\004 \001(\014\022\017\n\007fwdPort\030\005 \001(\005B\tB\007Mes" +
      "sage"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Msg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Msg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Msg_descriptor,
        new java.lang.String[] { "MessageID", "Payload", "CheckSum", "FwdAddress", "FwdPort", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
