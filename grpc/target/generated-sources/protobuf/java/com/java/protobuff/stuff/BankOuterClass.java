// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bank.proto

package com.java.protobuff.stuff;

public final class BankOuterClass {
  private BankOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_java_protobuff_stuff_Transfer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_java_protobuff_stuff_Transfer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_java_protobuff_stuff_TransferResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_java_protobuff_stuff_TransferResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nbank.proto\022\030com.java.protobuff.stuff\"a" +
      "\n\010Transfer\022\n\n\002id\030\001 \001(\005\022\024\n\014account_from\030\002" +
      " \001(\005\022\022\n\naccount_to\030\003 \001(\005\022\016\n\006amount\030\004 \001(\001" +
      "\022\017\n\007message\030\005 \001(\t\"/\n\020TransferResponse\022\n\n" +
      "\002id\030\001 \001(\005\022\017\n\007message\030\002 \001(\t2b\n\004Bank\022Z\n\010tr" +
      "ansfer\022\".com.java.protobuff.stuff.Transf" +
      "er\032*.com.java.protobuff.stuff.TransferRe" +
      "sponseB\002P\001b\006proto3"
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
    internal_static_com_java_protobuff_stuff_Transfer_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_java_protobuff_stuff_Transfer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_java_protobuff_stuff_Transfer_descriptor,
        new java.lang.String[] { "Id", "AccountFrom", "AccountTo", "Amount", "Message", });
    internal_static_com_java_protobuff_stuff_TransferResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_java_protobuff_stuff_TransferResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_java_protobuff_stuff_TransferResponse_descriptor,
        new java.lang.String[] { "Id", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
