package guru.qa.grpc.rococo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: rococo-userdata.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RococoUserdataServiceGrpc {

  private RococoUserdataServiceGrpc() {}

  public static final String SERVICE_NAME = "guru.qa.grpc.rococo.RococoUserdataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UserRequest,
      guru.qa.grpc.rococo.grpc.UserResponse> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = guru.qa.grpc.rococo.grpc.UserRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UserRequest,
      guru.qa.grpc.rococo.grpc.UserResponse> getGetUserMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UserRequest, guru.qa.grpc.rococo.grpc.UserResponse> getGetUserMethod;
    if ((getGetUserMethod = RococoUserdataServiceGrpc.getGetUserMethod) == null) {
      synchronized (RococoUserdataServiceGrpc.class) {
        if ((getGetUserMethod = RococoUserdataServiceGrpc.getGetUserMethod) == null) {
          RococoUserdataServiceGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.UserRequest, guru.qa.grpc.rococo.grpc.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoUserdataServiceMethodDescriptorSupplier("GetUser"))
              .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateUserRequest,
      guru.qa.grpc.rococo.grpc.UserResponse> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = guru.qa.grpc.rococo.grpc.UpdateUserRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateUserRequest,
      guru.qa.grpc.rococo.grpc.UserResponse> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateUserRequest, guru.qa.grpc.rococo.grpc.UserResponse> getUpdateUserMethod;
    if ((getUpdateUserMethod = RococoUserdataServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (RococoUserdataServiceGrpc.class) {
        if ((getUpdateUserMethod = RococoUserdataServiceGrpc.getUpdateUserMethod) == null) {
          RococoUserdataServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.UpdateUserRequest, guru.qa.grpc.rococo.grpc.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.UpdateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoUserdataServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RococoUserdataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoUserdataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoUserdataServiceStub>() {
        @java.lang.Override
        public RococoUserdataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoUserdataServiceStub(channel, callOptions);
        }
      };
    return RococoUserdataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RococoUserdataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoUserdataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoUserdataServiceBlockingStub>() {
        @java.lang.Override
        public RococoUserdataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoUserdataServiceBlockingStub(channel, callOptions);
        }
      };
    return RococoUserdataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RococoUserdataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoUserdataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoUserdataServiceFutureStub>() {
        @java.lang.Override
        public RococoUserdataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoUserdataServiceFutureStub(channel, callOptions);
        }
      };
    return RococoUserdataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RococoUserdataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUser(guru.qa.grpc.rococo.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.UserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     */
    public void updateUser(guru.qa.grpc.rococo.grpc.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.UserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.UserRequest,
                guru.qa.grpc.rococo.grpc.UserResponse>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.UpdateUserRequest,
                guru.qa.grpc.rococo.grpc.UserResponse>(
                  this, METHODID_UPDATE_USER)))
          .build();
    }
  }

  /**
   */
  public static final class RococoUserdataServiceStub extends io.grpc.stub.AbstractAsyncStub<RococoUserdataServiceStub> {
    private RococoUserdataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoUserdataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoUserdataServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUser(guru.qa.grpc.rococo.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.UserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(guru.qa.grpc.rococo.grpc.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.UserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RococoUserdataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RococoUserdataServiceBlockingStub> {
    private RococoUserdataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoUserdataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoUserdataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.UserResponse getUser(guru.qa.grpc.rococo.grpc.UserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.UserResponse updateUser(guru.qa.grpc.rococo.grpc.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RococoUserdataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RococoUserdataServiceFutureStub> {
    private RococoUserdataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoUserdataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoUserdataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.UserResponse> getUser(
        guru.qa.grpc.rococo.grpc.UserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.UserResponse> updateUser(
        guru.qa.grpc.rococo.grpc.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;
  private static final int METHODID_UPDATE_USER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RococoUserdataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RococoUserdataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser((guru.qa.grpc.rococo.grpc.UserRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.UserResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((guru.qa.grpc.rococo.grpc.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.UserResponse>) responseObserver);
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

  private static abstract class RococoUserdataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RococoUserdataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return guru.qa.grpc.rococo.grpc.RococoUserdataProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RococoUserdataService");
    }
  }

  private static final class RococoUserdataServiceFileDescriptorSupplier
      extends RococoUserdataServiceBaseDescriptorSupplier {
    RococoUserdataServiceFileDescriptorSupplier() {}
  }

  private static final class RococoUserdataServiceMethodDescriptorSupplier
      extends RococoUserdataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RococoUserdataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RococoUserdataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RococoUserdataServiceFileDescriptorSupplier())
              .addMethod(getGetUserMethod())
              .addMethod(getUpdateUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
