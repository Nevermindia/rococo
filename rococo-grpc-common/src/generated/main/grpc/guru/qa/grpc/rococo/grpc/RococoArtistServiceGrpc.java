package guru.qa.grpc.rococo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: rococo-artist.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RococoArtistServiceGrpc {

  private RococoArtistServiceGrpc() {}

  public static final String SERVICE_NAME = "guru.qa.grpc.rococo.RococoArtistService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.ArtistRequest,
      guru.qa.grpc.rococo.grpc.ArtistResponse> getGetArtistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetArtist",
      requestType = guru.qa.grpc.rococo.grpc.ArtistRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.ArtistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.ArtistRequest,
      guru.qa.grpc.rococo.grpc.ArtistResponse> getGetArtistMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.ArtistRequest, guru.qa.grpc.rococo.grpc.ArtistResponse> getGetArtistMethod;
    if ((getGetArtistMethod = RococoArtistServiceGrpc.getGetArtistMethod) == null) {
      synchronized (RococoArtistServiceGrpc.class) {
        if ((getGetArtistMethod = RococoArtistServiceGrpc.getGetArtistMethod) == null) {
          RococoArtistServiceGrpc.getGetArtistMethod = getGetArtistMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.ArtistRequest, guru.qa.grpc.rococo.grpc.ArtistResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetArtist"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.ArtistRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.ArtistResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoArtistServiceMethodDescriptorSupplier("GetArtist"))
              .build();
        }
      }
    }
    return getGetArtistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllArtistRequest,
      guru.qa.grpc.rococo.grpc.AllArtistResponse> getGetAllArtistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllArtist",
      requestType = guru.qa.grpc.rococo.grpc.AllArtistRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllArtistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllArtistRequest,
      guru.qa.grpc.rococo.grpc.AllArtistResponse> getGetAllArtistMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllArtistRequest, guru.qa.grpc.rococo.grpc.AllArtistResponse> getGetAllArtistMethod;
    if ((getGetAllArtistMethod = RococoArtistServiceGrpc.getGetAllArtistMethod) == null) {
      synchronized (RococoArtistServiceGrpc.class) {
        if ((getGetAllArtistMethod = RococoArtistServiceGrpc.getGetAllArtistMethod) == null) {
          RococoArtistServiceGrpc.getGetAllArtistMethod = getGetAllArtistMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AllArtistRequest, guru.qa.grpc.rococo.grpc.AllArtistResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllArtist"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllArtistRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllArtistResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoArtistServiceMethodDescriptorSupplier("GetAllArtist"))
              .build();
        }
      }
    }
    return getGetAllArtistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddArtistRequest,
      guru.qa.grpc.rococo.grpc.ArtistResponse> getAddArtistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddArtist",
      requestType = guru.qa.grpc.rococo.grpc.AddArtistRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.ArtistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddArtistRequest,
      guru.qa.grpc.rococo.grpc.ArtistResponse> getAddArtistMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddArtistRequest, guru.qa.grpc.rococo.grpc.ArtistResponse> getAddArtistMethod;
    if ((getAddArtistMethod = RococoArtistServiceGrpc.getAddArtistMethod) == null) {
      synchronized (RococoArtistServiceGrpc.class) {
        if ((getAddArtistMethod = RococoArtistServiceGrpc.getAddArtistMethod) == null) {
          RococoArtistServiceGrpc.getAddArtistMethod = getAddArtistMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AddArtistRequest, guru.qa.grpc.rococo.grpc.ArtistResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddArtist"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AddArtistRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.ArtistResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoArtistServiceMethodDescriptorSupplier("AddArtist"))
              .build();
        }
      }
    }
    return getAddArtistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateArtistRequest,
      guru.qa.grpc.rococo.grpc.ArtistResponse> getUpdateArtistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateArtist",
      requestType = guru.qa.grpc.rococo.grpc.UpdateArtistRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.ArtistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateArtistRequest,
      guru.qa.grpc.rococo.grpc.ArtistResponse> getUpdateArtistMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdateArtistRequest, guru.qa.grpc.rococo.grpc.ArtistResponse> getUpdateArtistMethod;
    if ((getUpdateArtistMethod = RococoArtistServiceGrpc.getUpdateArtistMethod) == null) {
      synchronized (RococoArtistServiceGrpc.class) {
        if ((getUpdateArtistMethod = RococoArtistServiceGrpc.getUpdateArtistMethod) == null) {
          RococoArtistServiceGrpc.getUpdateArtistMethod = getUpdateArtistMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.UpdateArtistRequest, guru.qa.grpc.rococo.grpc.ArtistResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateArtist"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.UpdateArtistRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.ArtistResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoArtistServiceMethodDescriptorSupplier("UpdateArtist"))
              .build();
        }
      }
    }
    return getUpdateArtistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.ArtistIdsRequest,
      guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse> getGetArtistByIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetArtistByIds",
      requestType = guru.qa.grpc.rococo.grpc.ArtistIdsRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.ArtistIdsRequest,
      guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse> getGetArtistByIdsMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.ArtistIdsRequest, guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse> getGetArtistByIdsMethod;
    if ((getGetArtistByIdsMethod = RococoArtistServiceGrpc.getGetArtistByIdsMethod) == null) {
      synchronized (RococoArtistServiceGrpc.class) {
        if ((getGetArtistByIdsMethod = RococoArtistServiceGrpc.getGetArtistByIdsMethod) == null) {
          RococoArtistServiceGrpc.getGetArtistByIdsMethod = getGetArtistByIdsMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.ArtistIdsRequest, guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetArtistByIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.ArtistIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoArtistServiceMethodDescriptorSupplier("GetArtistByIds"))
              .build();
        }
      }
    }
    return getGetArtistByIdsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RococoArtistServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoArtistServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoArtistServiceStub>() {
        @java.lang.Override
        public RococoArtistServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoArtistServiceStub(channel, callOptions);
        }
      };
    return RococoArtistServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RococoArtistServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoArtistServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoArtistServiceBlockingStub>() {
        @java.lang.Override
        public RococoArtistServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoArtistServiceBlockingStub(channel, callOptions);
        }
      };
    return RococoArtistServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RococoArtistServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoArtistServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoArtistServiceFutureStub>() {
        @java.lang.Override
        public RococoArtistServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoArtistServiceFutureStub(channel, callOptions);
        }
      };
    return RococoArtistServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RococoArtistServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getArtist(guru.qa.grpc.rococo.grpc.ArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetArtistMethod(), responseObserver);
    }

    /**
     */
    public void getAllArtist(guru.qa.grpc.rococo.grpc.AllArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllArtistResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllArtistMethod(), responseObserver);
    }

    /**
     */
    public void addArtist(guru.qa.grpc.rococo.grpc.AddArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddArtistMethod(), responseObserver);
    }

    /**
     */
    public void updateArtist(guru.qa.grpc.rococo.grpc.UpdateArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateArtistMethod(), responseObserver);
    }

    /**
     */
    public void getArtistByIds(guru.qa.grpc.rococo.grpc.ArtistIdsRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetArtistByIdsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetArtistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.ArtistRequest,
                guru.qa.grpc.rococo.grpc.ArtistResponse>(
                  this, METHODID_GET_ARTIST)))
          .addMethod(
            getGetAllArtistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AllArtistRequest,
                guru.qa.grpc.rococo.grpc.AllArtistResponse>(
                  this, METHODID_GET_ALL_ARTIST)))
          .addMethod(
            getAddArtistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AddArtistRequest,
                guru.qa.grpc.rococo.grpc.ArtistResponse>(
                  this, METHODID_ADD_ARTIST)))
          .addMethod(
            getUpdateArtistMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.UpdateArtistRequest,
                guru.qa.grpc.rococo.grpc.ArtistResponse>(
                  this, METHODID_UPDATE_ARTIST)))
          .addMethod(
            getGetArtistByIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.ArtistIdsRequest,
                guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse>(
                  this, METHODID_GET_ARTIST_BY_IDS)))
          .build();
    }
  }

  /**
   */
  public static final class RococoArtistServiceStub extends io.grpc.stub.AbstractAsyncStub<RococoArtistServiceStub> {
    private RococoArtistServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoArtistServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoArtistServiceStub(channel, callOptions);
    }

    /**
     */
    public void getArtist(guru.qa.grpc.rococo.grpc.ArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetArtistMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllArtist(guru.qa.grpc.rococo.grpc.AllArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllArtistResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllArtistMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addArtist(guru.qa.grpc.rococo.grpc.AddArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddArtistMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateArtist(guru.qa.grpc.rococo.grpc.UpdateArtistRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateArtistMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getArtistByIds(guru.qa.grpc.rococo.grpc.ArtistIdsRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetArtistByIdsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RococoArtistServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RococoArtistServiceBlockingStub> {
    private RococoArtistServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoArtistServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoArtistServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.ArtistResponse getArtist(guru.qa.grpc.rococo.grpc.ArtistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetArtistMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllArtistResponse getAllArtist(guru.qa.grpc.rococo.grpc.AllArtistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllArtistMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.ArtistResponse addArtist(guru.qa.grpc.rococo.grpc.AddArtistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddArtistMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.ArtistResponse updateArtist(guru.qa.grpc.rococo.grpc.UpdateArtistRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateArtistMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse getArtistByIds(guru.qa.grpc.rococo.grpc.ArtistIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetArtistByIdsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RococoArtistServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RococoArtistServiceFutureStub> {
    private RococoArtistServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoArtistServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoArtistServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.ArtistResponse> getArtist(
        guru.qa.grpc.rococo.grpc.ArtistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetArtistMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllArtistResponse> getAllArtist(
        guru.qa.grpc.rococo.grpc.AllArtistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllArtistMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.ArtistResponse> addArtist(
        guru.qa.grpc.rococo.grpc.AddArtistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddArtistMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.ArtistResponse> updateArtist(
        guru.qa.grpc.rococo.grpc.UpdateArtistRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateArtistMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse> getArtistByIds(
        guru.qa.grpc.rococo.grpc.ArtistIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetArtistByIdsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ARTIST = 0;
  private static final int METHODID_GET_ALL_ARTIST = 1;
  private static final int METHODID_ADD_ARTIST = 2;
  private static final int METHODID_UPDATE_ARTIST = 3;
  private static final int METHODID_GET_ARTIST_BY_IDS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RococoArtistServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RococoArtistServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ARTIST:
          serviceImpl.getArtist((guru.qa.grpc.rococo.grpc.ArtistRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_ARTIST:
          serviceImpl.getAllArtist((guru.qa.grpc.rococo.grpc.AllArtistRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllArtistResponse>) responseObserver);
          break;
        case METHODID_ADD_ARTIST:
          serviceImpl.addArtist((guru.qa.grpc.rococo.grpc.AddArtistRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ARTIST:
          serviceImpl.updateArtist((guru.qa.grpc.rococo.grpc.UpdateArtistRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.ArtistResponse>) responseObserver);
          break;
        case METHODID_GET_ARTIST_BY_IDS:
          serviceImpl.getArtistByIds((guru.qa.grpc.rococo.grpc.ArtistIdsRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllArtistByIdsResponse>) responseObserver);
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

  private static abstract class RococoArtistServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RococoArtistServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return guru.qa.grpc.rococo.grpc.RococoArtistProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RococoArtistService");
    }
  }

  private static final class RococoArtistServiceFileDescriptorSupplier
      extends RococoArtistServiceBaseDescriptorSupplier {
    RococoArtistServiceFileDescriptorSupplier() {}
  }

  private static final class RococoArtistServiceMethodDescriptorSupplier
      extends RococoArtistServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RococoArtistServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RococoArtistServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RococoArtistServiceFileDescriptorSupplier())
              .addMethod(getGetArtistMethod())
              .addMethod(getGetAllArtistMethod())
              .addMethod(getAddArtistMethod())
              .addMethod(getUpdateArtistMethod())
              .addMethod(getGetArtistByIdsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
