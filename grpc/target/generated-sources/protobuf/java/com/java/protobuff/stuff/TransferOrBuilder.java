// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bank.proto

package com.java.protobuff.stuff;

public interface TransferOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.java.protobuff.stuff.Transfer)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>int32 account_from = 2;</code>
   */
  int getAccountFrom();

  /**
   * <code>int32 account_to = 3;</code>
   */
  int getAccountTo();

  /**
   * <code>double amount = 4;</code>
   */
  double getAmount();

  /**
   * <code>string message = 5;</code>
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 5;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}