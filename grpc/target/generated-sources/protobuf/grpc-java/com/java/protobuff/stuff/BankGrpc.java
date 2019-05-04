package com.java.protobuff.stuff;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: bank.proto")
public final class BankGrpc {

  private BankGrpc() {}

  public static final String SERVICE_NAME = "com.java.protobuff.stuff.Bank";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.java.protobuff.stuff.Transfer,
      com.java.protobuff.stuff.TransferResponse> getTransferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transfer",
      requestType = com.java.protobuff.stuff.Transfer.class,
      responseType = com.java.protobuff.stuff.TransferResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.java.protobuff.stuff.Transfer,
      com.java.protobuff.stuff.TransferResponse> getTransferMethod() {
    io.grpc.MethodDescriptor<com.java.protobuff.stuff.Transfer, com.java.protobuff.stuff.TransferResponse> getTransferMethod;
    if ((getTransferMethod = BankGrpc.getTransferMethod) == null) {
      synchronized (BankGrpc.class) {
        if ((getTransferMethod = BankGrpc.getTransferMethod) == null) {
          BankGrpc.getTransferMethod = getTransferMethod = 
              io.grpc.MethodDescriptor.<com.java.protobuff.stuff.Transfer, com.java.protobuff.stuff.TransferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.java.protobuff.stuff.Bank", "transfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.java.protobuff.stuff.Transfer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.java.protobuff.stuff.TransferResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BankMethodDescriptorSupplier("transfer"))
                  .build();
          }
        }
     }
     return getTransferMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankStub newStub(io.grpc.Channel channel) {
    return new BankStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BankBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BankFutureStub(channel);
  }

  /**
   */
  public static abstract class BankImplBase implements io.grpc.BindableService {

    /**
     */
    public void transfer(com.java.protobuff.stuff.Transfer request,
        io.grpc.stub.StreamObserver<com.java.protobuff.stuff.TransferResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTransferMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.java.protobuff.stuff.Transfer,
                com.java.protobuff.stuff.TransferResponse>(
                  this, METHODID_TRANSFER)))
          .build();
    }
  }

  /**
   */
  public static final class BankStub extends io.grpc.stub.AbstractStub<BankStub> {
    private BankStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankStub(channel, callOptions);
    }

    /**
     */
    public void transfer(com.java.protobuff.stuff.Transfer request,
        io.grpc.stub.StreamObserver<com.java.protobuff.stuff.TransferResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BankBlockingStub extends io.grpc.stub.AbstractStub<BankBlockingStub> {
    private BankBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.java.protobuff.stuff.TransferResponse transfer(com.java.protobuff.stuff.Transfer request) {
      return blockingUnaryCall(
          getChannel(), getTransferMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BankFutureStub extends io.grpc.stub.AbstractStub<BankFutureStub> {
    private BankFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.java.protobuff.stuff.TransferResponse> transfer(
        com.java.protobuff.stuff.Transfer request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSFER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSFER:
          serviceImpl.transfer((com.java.protobuff.stuff.Transfer) request,
              (io.grpc.stub.StreamObserver<com.java.protobuff.stuff.TransferResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BankBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.java.protobuff.stuff.BankOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bank");
    }
  }

  private static final class BankFileDescriptorSupplier
      extends BankBaseDescriptorSupplier {
    BankFileDescriptorSupplier() {}
  }

  private static final class BankMethodDescriptorSupplier
      extends BankBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BankGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankFileDescriptorSupplier())
              .addMethod(getTransferMethod())
              .build();
        }
      }
    }
    return result;
  }
}
