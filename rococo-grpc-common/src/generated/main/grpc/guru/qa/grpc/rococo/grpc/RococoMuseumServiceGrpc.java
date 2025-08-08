package guru.qa.grpc.rococo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: rococo-museum.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RococoMuseumServiceGrpc {

  private RococoMuseumServiceGrpc() {}

  public static final String SERVICE_NAME = "guru.qa.grpc.rococo.RococoMuseumService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.MuseumRequest,
      guru.qa.grpc.rococo.grpc.MuseumResponse> getGetMuseumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMuseum",
      requestType = guru.qa.grpc.rococo.grpc.MuseumRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.MuseumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.MuseumRequest,
      guru.qa.grpc.rococo.grpc.MuseumResponse> getGetMuseumMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.MuseumRequest, guru.qa.grpc.rococo.grpc.MuseumResponse> getGetMuseumMethod;
    if ((getGetMuseumMethod = RococoMuseumServiceGrpc.getGetMuseumMethod) == null) {
      synchronized (RococoMuseumServiceGrpc.class) {
        if ((getGetMuseumMethod = RococoMuseumServiceGrpc.getGetMuseumMethod) == null) {
          RococoMuseumServiceGrpc.getGetMuseumMethod = getGetMuseumMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.MuseumRequest, guru.qa.grpc.rococo.grpc.MuseumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMuseum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.MuseumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.MuseumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoMuseumServiceMethodDescriptorSupplier("GetMuseum"))
              .build();
        }
      }
    }
    return getGetMuseumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllMuseumRequest,
      guru.qa.grpc.rococo.grpc.AllMuseumResponse> getGetAllMuseumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllMuseum",
      requestType = guru.qa.grpc.rococo.grpc.AllMuseumRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllMuseumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllMuseumRequest,
      guru.qa.grpc.rococo.grpc.AllMuseumResponse> getGetAllMuseumMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllMuseumRequest, guru.qa.grpc.rococo.grpc.AllMuseumResponse> getGetAllMuseumMethod;
    if ((getGetAllMuseumMethod = RococoMuseumServiceGrpc.getGetAllMuseumMethod) == null) {
      synchronized (RococoMuseumServiceGrpc.class) {
        if ((getGetAllMuseumMethod = RococoMuseumServiceGrpc.getGetAllMuseumMethod) == null) {
          RococoMuseumServiceGrpc.getGetAllMuseumMethod = getGetAllMuseumMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AllMuseumRequest, guru.qa.grpc.rococo.grpc.AllMuseumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllMuseum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllMuseumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllMuseumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoMuseumServiceMethodDescriptorSupplier("GetAllMuseum"))
              .build();
        }
      }
    }
    return getGetAllMuseumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddMuseumRequest,
      guru.qa.grpc.rococo.grpc.MuseumResponse> getAddMuseumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddMuseum",
      requestType = guru.qa.grpc.rococo.grpc.AddMuseumRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.MuseumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddMuseumRequest,
      guru.qa.grpc.rococo.grpc.MuseumResponse> getAddMuseumMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddMuseumRequest, guru.qa.grpc.rococo.grpc.MuseumResponse> getAddMuseumMethod;
    if ((getAddMuseumMethod = RococoMuseumServiceGrpc.getAddMuseumMethod) == null) {
      synchronized (RococoMuseumServiceGrpc.class) {
        if ((getAddMuseumMethod = RococoMuseumServiceGrpc.getAddMuseumMethod) == null) {
          RococoMuseumServiceGrpc.getAddMuseumMethod = getAddMuseumMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AddMuseumRequest, guru.qa.grpc.rococo.grpc.MuseumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddMuseum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AddMuseumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.MuseumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoMuseumServiceMethodDescriptorSupplier("AddMuseum"))
              .build();
        }
      }
    }
    return getAddMuseumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateMuseumRequest,
      guru.qa.grpc.rococo.grpc.MuseumResponse> getUpdateMuseumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMuseum",
      requestType = guru.qa.grpc.rococo.grpc.UpdateMuseumRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.MuseumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateMuseumRequest,
      guru.qa.grpc.rococo.grpc.MuseumResponse> getUpdateMuseumMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateMuseumRequest, guru.qa.grpc.rococo.grpc.MuseumResponse> getUpdateMuseumMethod;
    if ((getUpdateMuseumMethod = RococoMuseumServiceGrpc.getUpdateMuseumMethod) == null) {
      synchronized (RococoMuseumServiceGrpc.class) {
        if ((getUpdateMuseumMethod = RococoMuseumServiceGrpc.getUpdateMuseumMethod) == null) {
          RococoMuseumServiceGrpc.getUpdateMuseumMethod = getUpdateMuseumMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.UpdateMuseumRequest, guru.qa.grpc.rococo.grpc.MuseumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMuseum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.UpdateMuseumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.MuseumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoMuseumServiceMethodDescriptorSupplier("UpdateMuseum"))
              .build();
        }
      }
    }
    return getUpdateMuseumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.MuseumIdsRequest,
      guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse> getGetMuseumByIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMuseumByIds",
      requestType = guru.qa.grpc.rococo.grpc.MuseumIdsRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.MuseumIdsRequest,
      guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse> getGetMuseumByIdsMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.MuseumIdsRequest, guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse> getGetMuseumByIdsMethod;
    if ((getGetMuseumByIdsMethod = RococoMuseumServiceGrpc.getGetMuseumByIdsMethod) == null) {
      synchronized (RococoMuseumServiceGrpc.class) {
        if ((getGetMuseumByIdsMethod = RococoMuseumServiceGrpc.getGetMuseumByIdsMethod) == null) {
          RococoMuseumServiceGrpc.getGetMuseumByIdsMethod = getGetMuseumByIdsMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.MuseumIdsRequest, guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMuseumByIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.MuseumIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoMuseumServiceMethodDescriptorSupplier("GetMuseumByIds"))
              .build();
        }
      }
    }
    return getGetMuseumByIdsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RococoMuseumServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoMuseumServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoMuseumServiceStub>() {
        @java.lang.Override
        public RococoMuseumServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoMuseumServiceStub(channel, callOptions);
        }
      };
    return RococoMuseumServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RococoMuseumServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoMuseumServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoMuseumServiceBlockingStub>() {
        @java.lang.Override
        public RococoMuseumServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoMuseumServiceBlockingStub(channel, callOptions);
        }
      };
    return RococoMuseumServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RococoMuseumServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoMuseumServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoMuseumServiceFutureStub>() {
        @java.lang.Override
        public RococoMuseumServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoMuseumServiceFutureStub(channel, callOptions);
        }
      };
    return RococoMuseumServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RococoMuseumServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMuseum(guru.qa.grpc.rococo.grpc.MuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMuseumMethod(), responseObserver);
    }

    /**
     */
    public void getAllMuseum(guru.qa.grpc.rococo.grpc.AllMuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllMuseumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllMuseumMethod(), responseObserver);
    }

    /**
     */
    public void addMuseum(guru.qa.grpc.rococo.grpc.AddMuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMuseumMethod(), responseObserver);
    }

    /**
     */
    public void updateMuseum(guru.qa.grpc.rococo.grpc.UpdateMuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMuseumMethod(), responseObserver);
    }

    /**
     */
    public void getMuseumByIds(guru.qa.grpc.rococo.grpc.MuseumIdsRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMuseumByIdsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMuseumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.MuseumRequest,
                guru.qa.grpc.rococo.grpc.MuseumResponse>(
                  this, METHODID_GET_MUSEUM)))
          .addMethod(
            getGetAllMuseumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AllMuseumRequest,
                guru.qa.grpc.rococo.grpc.AllMuseumResponse>(
                  this, METHODID_GET_ALL_MUSEUM)))
          .addMethod(
            getAddMuseumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AddMuseumRequest,
                guru.qa.grpc.rococo.grpc.MuseumResponse>(
                  this, METHODID_ADD_MUSEUM)))
          .addMethod(
            getUpdateMuseumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.UpdateMuseumRequest,
                guru.qa.grpc.rococo.grpc.MuseumResponse>(
                  this, METHODID_UPDATE_MUSEUM)))
          .addMethod(
            getGetMuseumByIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.MuseumIdsRequest,
                guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse>(
                  this, METHODID_GET_MUSEUM_BY_IDS)))
          .build();
    }
  }

  /**
   */
  public static final class RococoMuseumServiceStub extends io.grpc.stub.AbstractAsyncStub<RococoMuseumServiceStub> {
    private RococoMuseumServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoMuseumServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoMuseumServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMuseum(guru.qa.grpc.rococo.grpc.MuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMuseumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllMuseum(guru.qa.grpc.rococo.grpc.AllMuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllMuseumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllMuseumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addMuseum(guru.qa.grpc.rococo.grpc.AddMuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMuseumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateMuseum(guru.qa.grpc.rococo.grpc.UpdateMuseumRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMuseumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMuseumByIds(guru.qa.grpc.rococo.grpc.MuseumIdsRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMuseumByIdsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RococoMuseumServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RococoMuseumServiceBlockingStub> {
    private RococoMuseumServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoMuseumServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoMuseumServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.MuseumResponse getMuseum(guru.qa.grpc.rococo.grpc.MuseumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMuseumMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllMuseumResponse getAllMuseum(guru.qa.grpc.rococo.grpc.AllMuseumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllMuseumMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.MuseumResponse addMuseum(guru.qa.grpc.rococo.grpc.AddMuseumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMuseumMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.MuseumResponse updateMuseum(guru.qa.grpc.rococo.grpc.UpdateMuseumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMuseumMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse getMuseumByIds(guru.qa.grpc.rococo.grpc.MuseumIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMuseumByIdsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RococoMuseumServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RococoMuseumServiceFutureStub> {
    private RococoMuseumServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoMuseumServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoMuseumServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.MuseumResponse> getMuseum(
        guru.qa.grpc.rococo.grpc.MuseumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMuseumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllMuseumResponse> getAllMuseum(
        guru.qa.grpc.rococo.grpc.AllMuseumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllMuseumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.MuseumResponse> addMuseum(
        guru.qa.grpc.rococo.grpc.AddMuseumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMuseumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.MuseumResponse> updateMuseum(
        guru.qa.grpc.rococo.grpc.UpdateMuseumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMuseumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse> getMuseumByIds(
        guru.qa.grpc.rococo.grpc.MuseumIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMuseumByIdsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MUSEUM = 0;
  private static final int METHODID_GET_ALL_MUSEUM = 1;
  private static final int METHODID_ADD_MUSEUM = 2;
  private static final int METHODID_UPDATE_MUSEUM = 3;
  private static final int METHODID_GET_MUSEUM_BY_IDS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RococoMuseumServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RococoMuseumServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MUSEUM:
          serviceImpl.getMuseum((guru.qa.grpc.rococo.grpc.MuseumRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_MUSEUM:
          serviceImpl.getAllMuseum((guru.qa.grpc.rococo.grpc.AllMuseumRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllMuseumResponse>) responseObserver);
          break;
        case METHODID_ADD_MUSEUM:
          serviceImpl.addMuseum((guru.qa.grpc.rococo.grpc.AddMuseumRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse>) responseObserver);
          break;
        case METHODID_UPDATE_MUSEUM:
          serviceImpl.updateMuseum((guru.qa.grpc.rococo.grpc.UpdateMuseumRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.MuseumResponse>) responseObserver);
          break;
        case METHODID_GET_MUSEUM_BY_IDS:
          serviceImpl.getMuseumByIds((guru.qa.grpc.rococo.grpc.MuseumIdsRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllMuseumByIdsResponse>) responseObserver);
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

  private static abstract class RococoMuseumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RococoMuseumServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return guru.qa.grpc.rococo.grpc.RococoMuseumProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RococoMuseumService");
    }
  }

  private static final class RococoMuseumServiceFileDescriptorSupplier
      extends RococoMuseumServiceBaseDescriptorSupplier {
    RococoMuseumServiceFileDescriptorSupplier() {}
  }

  private static final class RococoMuseumServiceMethodDescriptorSupplier
      extends RococoMuseumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RococoMuseumServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RococoMuseumServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RococoMuseumServiceFileDescriptorSupplier())
              .addMethod(getGetMuseumMethod())
              .addMethod(getGetAllMuseumMethod())
              .addMethod(getAddMuseumMethod())
              .addMethod(getUpdateMuseumMethod())
              .addMethod(getGetMuseumByIdsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
