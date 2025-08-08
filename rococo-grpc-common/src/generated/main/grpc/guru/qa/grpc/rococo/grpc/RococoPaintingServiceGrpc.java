package guru.qa.grpc.rococo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: rococo-painting.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RococoPaintingServiceGrpc {

  private RococoPaintingServiceGrpc() {}

  public static final String SERVICE_NAME = "guru.qa.grpc.rococo.RococoPaintingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.PaintingRequest,
      guru.qa.grpc.rococo.grpc.PaintingResponse> getGetPaintingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPainting",
      requestType = guru.qa.grpc.rococo.grpc.PaintingRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.PaintingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.PaintingRequest,
      guru.qa.grpc.rococo.grpc.PaintingResponse> getGetPaintingMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.PaintingRequest, guru.qa.grpc.rococo.grpc.PaintingResponse> getGetPaintingMethod;
    if ((getGetPaintingMethod = RococoPaintingServiceGrpc.getGetPaintingMethod) == null) {
      synchronized (RococoPaintingServiceGrpc.class) {
        if ((getGetPaintingMethod = RococoPaintingServiceGrpc.getGetPaintingMethod) == null) {
          RococoPaintingServiceGrpc.getGetPaintingMethod = getGetPaintingMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.PaintingRequest, guru.qa.grpc.rococo.grpc.PaintingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPainting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.PaintingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.PaintingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoPaintingServiceMethodDescriptorSupplier("GetPainting"))
              .build();
        }
      }
    }
    return getGetPaintingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllPaintingRequest,
      guru.qa.grpc.rococo.grpc.AllPaintingResponse> getGetAllPaintingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllPainting",
      requestType = guru.qa.grpc.rococo.grpc.AllPaintingRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllPaintingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllPaintingRequest,
      guru.qa.grpc.rococo.grpc.AllPaintingResponse> getGetAllPaintingMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllPaintingRequest, guru.qa.grpc.rococo.grpc.AllPaintingResponse> getGetAllPaintingMethod;
    if ((getGetAllPaintingMethod = RococoPaintingServiceGrpc.getGetAllPaintingMethod) == null) {
      synchronized (RococoPaintingServiceGrpc.class) {
        if ((getGetAllPaintingMethod = RococoPaintingServiceGrpc.getGetAllPaintingMethod) == null) {
          RococoPaintingServiceGrpc.getGetAllPaintingMethod = getGetAllPaintingMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AllPaintingRequest, guru.qa.grpc.rococo.grpc.AllPaintingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllPainting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllPaintingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllPaintingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoPaintingServiceMethodDescriptorSupplier("GetAllPainting"))
              .build();
        }
      }
    }
    return getGetAllPaintingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddPaintingRequest,
      guru.qa.grpc.rococo.grpc.PaintingResponse> getAddPaintingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPainting",
      requestType = guru.qa.grpc.rococo.grpc.AddPaintingRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.PaintingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddPaintingRequest,
      guru.qa.grpc.rococo.grpc.PaintingResponse> getAddPaintingMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AddPaintingRequest, guru.qa.grpc.rococo.grpc.PaintingResponse> getAddPaintingMethod;
    if ((getAddPaintingMethod = RococoPaintingServiceGrpc.getAddPaintingMethod) == null) {
      synchronized (RococoPaintingServiceGrpc.class) {
        if ((getAddPaintingMethod = RococoPaintingServiceGrpc.getAddPaintingMethod) == null) {
          RococoPaintingServiceGrpc.getAddPaintingMethod = getAddPaintingMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AddPaintingRequest, guru.qa.grpc.rococo.grpc.PaintingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddPainting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AddPaintingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.PaintingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoPaintingServiceMethodDescriptorSupplier("AddPainting"))
              .build();
        }
      }
    }
    return getAddPaintingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdatePaintingRequest,
      guru.qa.grpc.rococo.grpc.PaintingResponse> getUpdatePaintingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePainting",
      requestType = guru.qa.grpc.rococo.grpc.UpdatePaintingRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.PaintingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdatePaintingRequest,
      guru.qa.grpc.rococo.grpc.PaintingResponse> getUpdatePaintingMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.UpdatePaintingRequest, guru.qa.grpc.rococo.grpc.PaintingResponse> getUpdatePaintingMethod;
    if ((getUpdatePaintingMethod = RococoPaintingServiceGrpc.getUpdatePaintingMethod) == null) {
      synchronized (RococoPaintingServiceGrpc.class) {
        if ((getUpdatePaintingMethod = RococoPaintingServiceGrpc.getUpdatePaintingMethod) == null) {
          RococoPaintingServiceGrpc.getUpdatePaintingMethod = getUpdatePaintingMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.UpdatePaintingRequest, guru.qa.grpc.rococo.grpc.PaintingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePainting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.UpdatePaintingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.PaintingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoPaintingServiceMethodDescriptorSupplier("UpdatePainting"))
              .build();
        }
      }
    }
    return getUpdatePaintingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest,
      guru.qa.grpc.rococo.grpc.AllPaintingResponse> getGetAllPaintingByArtistIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllPaintingByArtistId",
      requestType = guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllPaintingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest,
      guru.qa.grpc.rococo.grpc.AllPaintingResponse> getGetAllPaintingByArtistIdMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest, guru.qa.grpc.rococo.grpc.AllPaintingResponse> getGetAllPaintingByArtistIdMethod;
    if ((getGetAllPaintingByArtistIdMethod = RococoPaintingServiceGrpc.getGetAllPaintingByArtistIdMethod) == null) {
      synchronized (RococoPaintingServiceGrpc.class) {
        if ((getGetAllPaintingByArtistIdMethod = RococoPaintingServiceGrpc.getGetAllPaintingByArtistIdMethod) == null) {
          RococoPaintingServiceGrpc.getGetAllPaintingByArtistIdMethod = getGetAllPaintingByArtistIdMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest, guru.qa.grpc.rococo.grpc.AllPaintingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllPaintingByArtistId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllPaintingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoPaintingServiceMethodDescriptorSupplier("GetAllPaintingByArtistId"))
              .build();
        }
      }
    }
    return getGetAllPaintingByArtistIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RococoPaintingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoPaintingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoPaintingServiceStub>() {
        @java.lang.Override
        public RococoPaintingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoPaintingServiceStub(channel, callOptions);
        }
      };
    return RococoPaintingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RococoPaintingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoPaintingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoPaintingServiceBlockingStub>() {
        @java.lang.Override
        public RococoPaintingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoPaintingServiceBlockingStub(channel, callOptions);
        }
      };
    return RococoPaintingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RococoPaintingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoPaintingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoPaintingServiceFutureStub>() {
        @java.lang.Override
        public RococoPaintingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoPaintingServiceFutureStub(channel, callOptions);
        }
      };
    return RococoPaintingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RococoPaintingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPainting(guru.qa.grpc.rococo.grpc.PaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPaintingMethod(), responseObserver);
    }

    /**
     */
    public void getAllPainting(guru.qa.grpc.rococo.grpc.AllPaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllPaintingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllPaintingMethod(), responseObserver);
    }

    /**
     */
    public void addPainting(guru.qa.grpc.rococo.grpc.AddPaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddPaintingMethod(), responseObserver);
    }

    /**
     */
    public void updatePainting(guru.qa.grpc.rococo.grpc.UpdatePaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePaintingMethod(), responseObserver);
    }

    /**
     */
    public void getAllPaintingByArtistId(guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllPaintingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllPaintingByArtistIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPaintingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.PaintingRequest,
                guru.qa.grpc.rococo.grpc.PaintingResponse>(
                  this, METHODID_GET_PAINTING)))
          .addMethod(
            getGetAllPaintingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AllPaintingRequest,
                guru.qa.grpc.rococo.grpc.AllPaintingResponse>(
                  this, METHODID_GET_ALL_PAINTING)))
          .addMethod(
            getAddPaintingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AddPaintingRequest,
                guru.qa.grpc.rococo.grpc.PaintingResponse>(
                  this, METHODID_ADD_PAINTING)))
          .addMethod(
            getUpdatePaintingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.UpdatePaintingRequest,
                guru.qa.grpc.rococo.grpc.PaintingResponse>(
                  this, METHODID_UPDATE_PAINTING)))
          .addMethod(
            getGetAllPaintingByArtistIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest,
                guru.qa.grpc.rococo.grpc.AllPaintingResponse>(
                  this, METHODID_GET_ALL_PAINTING_BY_ARTIST_ID)))
          .build();
    }
  }

  /**
   */
  public static final class RococoPaintingServiceStub extends io.grpc.stub.AbstractAsyncStub<RococoPaintingServiceStub> {
    private RococoPaintingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoPaintingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoPaintingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPainting(guru.qa.grpc.rococo.grpc.PaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPaintingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPainting(guru.qa.grpc.rococo.grpc.AllPaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllPaintingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllPaintingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addPainting(guru.qa.grpc.rococo.grpc.AddPaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddPaintingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePainting(guru.qa.grpc.rococo.grpc.UpdatePaintingRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePaintingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPaintingByArtistId(guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllPaintingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllPaintingByArtistIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RococoPaintingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RococoPaintingServiceBlockingStub> {
    private RococoPaintingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoPaintingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoPaintingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.PaintingResponse getPainting(guru.qa.grpc.rococo.grpc.PaintingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPaintingMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllPaintingResponse getAllPainting(guru.qa.grpc.rococo.grpc.AllPaintingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllPaintingMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.PaintingResponse addPainting(guru.qa.grpc.rococo.grpc.AddPaintingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddPaintingMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.PaintingResponse updatePainting(guru.qa.grpc.rococo.grpc.UpdatePaintingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePaintingMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllPaintingResponse getAllPaintingByArtistId(guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllPaintingByArtistIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RococoPaintingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RococoPaintingServiceFutureStub> {
    private RococoPaintingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoPaintingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoPaintingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.PaintingResponse> getPainting(
        guru.qa.grpc.rococo.grpc.PaintingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPaintingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllPaintingResponse> getAllPainting(
        guru.qa.grpc.rococo.grpc.AllPaintingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllPaintingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.PaintingResponse> addPainting(
        guru.qa.grpc.rococo.grpc.AddPaintingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddPaintingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.PaintingResponse> updatePainting(
        guru.qa.grpc.rococo.grpc.UpdatePaintingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePaintingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllPaintingResponse> getAllPaintingByArtistId(
        guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllPaintingByArtistIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PAINTING = 0;
  private static final int METHODID_GET_ALL_PAINTING = 1;
  private static final int METHODID_ADD_PAINTING = 2;
  private static final int METHODID_UPDATE_PAINTING = 3;
  private static final int METHODID_GET_ALL_PAINTING_BY_ARTIST_ID = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RococoPaintingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RococoPaintingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PAINTING:
          serviceImpl.getPainting((guru.qa.grpc.rococo.grpc.PaintingRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_PAINTING:
          serviceImpl.getAllPainting((guru.qa.grpc.rococo.grpc.AllPaintingRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllPaintingResponse>) responseObserver);
          break;
        case METHODID_ADD_PAINTING:
          serviceImpl.addPainting((guru.qa.grpc.rococo.grpc.AddPaintingRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PAINTING:
          serviceImpl.updatePainting((guru.qa.grpc.rococo.grpc.UpdatePaintingRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.PaintingResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_PAINTING_BY_ARTIST_ID:
          serviceImpl.getAllPaintingByArtistId((guru.qa.grpc.rococo.grpc.AllPaintingByArtistIdRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllPaintingResponse>) responseObserver);
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

  private static abstract class RococoPaintingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RococoPaintingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return guru.qa.grpc.rococo.grpc.RococoPaintingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RococoPaintingService");
    }
  }

  private static final class RococoPaintingServiceFileDescriptorSupplier
      extends RococoPaintingServiceBaseDescriptorSupplier {
    RococoPaintingServiceFileDescriptorSupplier() {}
  }

  private static final class RococoPaintingServiceMethodDescriptorSupplier
      extends RococoPaintingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RococoPaintingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RococoPaintingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RococoPaintingServiceFileDescriptorSupplier())
              .addMethod(getGetPaintingMethod())
              .addMethod(getGetAllPaintingMethod())
              .addMethod(getAddPaintingMethod())
              .addMethod(getUpdatePaintingMethod())
              .addMethod(getGetAllPaintingByArtistIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
