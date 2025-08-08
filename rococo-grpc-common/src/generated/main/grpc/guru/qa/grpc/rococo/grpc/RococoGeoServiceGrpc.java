package guru.qa.grpc.rococo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: rococo-geo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RococoGeoServiceGrpc {

  private RococoGeoServiceGrpc() {}

  public static final String SERVICE_NAME = "guru.qa.grpc.rococo.RococoGeoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryId,
      guru.qa.grpc.rococo.grpc.CountryResponse> getGetCountryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCountry",
      requestType = guru.qa.grpc.rococo.grpc.CountryId.class,
      responseType = guru.qa.grpc.rococo.grpc.CountryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryId,
      guru.qa.grpc.rococo.grpc.CountryResponse> getGetCountryMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryId, guru.qa.grpc.rococo.grpc.CountryResponse> getGetCountryMethod;
    if ((getGetCountryMethod = RococoGeoServiceGrpc.getGetCountryMethod) == null) {
      synchronized (RococoGeoServiceGrpc.class) {
        if ((getGetCountryMethod = RococoGeoServiceGrpc.getGetCountryMethod) == null) {
          RococoGeoServiceGrpc.getGetCountryMethod = getGetCountryMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.CountryId, guru.qa.grpc.rococo.grpc.CountryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCountry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.CountryId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.CountryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoGeoServiceMethodDescriptorSupplier("GetCountry"))
              .build();
        }
      }
    }
    return getGetCountryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryName,
      guru.qa.grpc.rococo.grpc.CountryResponse> getGetCountryByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCountryByName",
      requestType = guru.qa.grpc.rococo.grpc.CountryName.class,
      responseType = guru.qa.grpc.rococo.grpc.CountryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryName,
      guru.qa.grpc.rococo.grpc.CountryResponse> getGetCountryByNameMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryName, guru.qa.grpc.rococo.grpc.CountryResponse> getGetCountryByNameMethod;
    if ((getGetCountryByNameMethod = RococoGeoServiceGrpc.getGetCountryByNameMethod) == null) {
      synchronized (RococoGeoServiceGrpc.class) {
        if ((getGetCountryByNameMethod = RococoGeoServiceGrpc.getGetCountryByNameMethod) == null) {
          RococoGeoServiceGrpc.getGetCountryByNameMethod = getGetCountryByNameMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.CountryName, guru.qa.grpc.rococo.grpc.CountryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCountryByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.CountryName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.CountryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoGeoServiceMethodDescriptorSupplier("GetCountryByName"))
              .build();
        }
      }
    }
    return getGetCountryByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllCountryRequest,
      guru.qa.grpc.rococo.grpc.AllCountryResponse> getGetAllCountryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCountry",
      requestType = guru.qa.grpc.rococo.grpc.AllCountryRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllCountryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllCountryRequest,
      guru.qa.grpc.rococo.grpc.AllCountryResponse> getGetAllCountryMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.AllCountryRequest, guru.qa.grpc.rococo.grpc.AllCountryResponse> getGetAllCountryMethod;
    if ((getGetAllCountryMethod = RococoGeoServiceGrpc.getGetAllCountryMethod) == null) {
      synchronized (RococoGeoServiceGrpc.class) {
        if ((getGetAllCountryMethod = RococoGeoServiceGrpc.getGetAllCountryMethod) == null) {
          RococoGeoServiceGrpc.getGetAllCountryMethod = getGetAllCountryMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.AllCountryRequest, guru.qa.grpc.rococo.grpc.AllCountryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllCountry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllCountryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllCountryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoGeoServiceMethodDescriptorSupplier("GetAllCountry"))
              .build();
        }
      }
    }
    return getGetAllCountryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryIdsRequest,
      guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse> getGetCountriesByIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCountriesByIds",
      requestType = guru.qa.grpc.rococo.grpc.CountryIdsRequest.class,
      responseType = guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryIdsRequest,
      guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse> getGetCountriesByIdsMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rococo.grpc.CountryIdsRequest, guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse> getGetCountriesByIdsMethod;
    if ((getGetCountriesByIdsMethod = RococoGeoServiceGrpc.getGetCountriesByIdsMethod) == null) {
      synchronized (RococoGeoServiceGrpc.class) {
        if ((getGetCountriesByIdsMethod = RococoGeoServiceGrpc.getGetCountriesByIdsMethod) == null) {
          RococoGeoServiceGrpc.getGetCountriesByIdsMethod = getGetCountriesByIdsMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rococo.grpc.CountryIdsRequest, guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCountriesByIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.CountryIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RococoGeoServiceMethodDescriptorSupplier("GetCountriesByIds"))
              .build();
        }
      }
    }
    return getGetCountriesByIdsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RococoGeoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoGeoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoGeoServiceStub>() {
        @java.lang.Override
        public RococoGeoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoGeoServiceStub(channel, callOptions);
        }
      };
    return RococoGeoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RococoGeoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoGeoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoGeoServiceBlockingStub>() {
        @java.lang.Override
        public RococoGeoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoGeoServiceBlockingStub(channel, callOptions);
        }
      };
    return RococoGeoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RococoGeoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RococoGeoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RococoGeoServiceFutureStub>() {
        @java.lang.Override
        public RococoGeoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RococoGeoServiceFutureStub(channel, callOptions);
        }
      };
    return RococoGeoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RococoGeoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCountry(guru.qa.grpc.rococo.grpc.CountryId request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.CountryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCountryMethod(), responseObserver);
    }

    /**
     */
    public void getCountryByName(guru.qa.grpc.rococo.grpc.CountryName request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.CountryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCountryByNameMethod(), responseObserver);
    }

    /**
     */
    public void getAllCountry(guru.qa.grpc.rococo.grpc.AllCountryRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllCountryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCountryMethod(), responseObserver);
    }

    /**
     */
    public void getCountriesByIds(guru.qa.grpc.rococo.grpc.CountryIdsRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCountriesByIdsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCountryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.CountryId,
                guru.qa.grpc.rococo.grpc.CountryResponse>(
                  this, METHODID_GET_COUNTRY)))
          .addMethod(
            getGetCountryByNameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.CountryName,
                guru.qa.grpc.rococo.grpc.CountryResponse>(
                  this, METHODID_GET_COUNTRY_BY_NAME)))
          .addMethod(
            getGetAllCountryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.AllCountryRequest,
                guru.qa.grpc.rococo.grpc.AllCountryResponse>(
                  this, METHODID_GET_ALL_COUNTRY)))
          .addMethod(
            getGetCountriesByIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rococo.grpc.CountryIdsRequest,
                guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse>(
                  this, METHODID_GET_COUNTRIES_BY_IDS)))
          .build();
    }
  }

  /**
   */
  public static final class RococoGeoServiceStub extends io.grpc.stub.AbstractAsyncStub<RococoGeoServiceStub> {
    private RococoGeoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoGeoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoGeoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCountry(guru.qa.grpc.rococo.grpc.CountryId request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.CountryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCountryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCountryByName(guru.qa.grpc.rococo.grpc.CountryName request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.CountryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCountryByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCountry(guru.qa.grpc.rococo.grpc.AllCountryRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllCountryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCountryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCountriesByIds(guru.qa.grpc.rococo.grpc.CountryIdsRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCountriesByIdsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RococoGeoServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RococoGeoServiceBlockingStub> {
    private RococoGeoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoGeoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoGeoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.CountryResponse getCountry(guru.qa.grpc.rococo.grpc.CountryId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCountryMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.CountryResponse getCountryByName(guru.qa.grpc.rococo.grpc.CountryName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCountryByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllCountryResponse getAllCountry(guru.qa.grpc.rococo.grpc.AllCountryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCountryMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse getCountriesByIds(guru.qa.grpc.rococo.grpc.CountryIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCountriesByIdsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RococoGeoServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RococoGeoServiceFutureStub> {
    private RococoGeoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RococoGeoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RococoGeoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.CountryResponse> getCountry(
        guru.qa.grpc.rococo.grpc.CountryId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCountryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.CountryResponse> getCountryByName(
        guru.qa.grpc.rococo.grpc.CountryName request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCountryByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllCountryResponse> getAllCountry(
        guru.qa.grpc.rococo.grpc.AllCountryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCountryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse> getCountriesByIds(
        guru.qa.grpc.rococo.grpc.CountryIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCountriesByIdsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COUNTRY = 0;
  private static final int METHODID_GET_COUNTRY_BY_NAME = 1;
  private static final int METHODID_GET_ALL_COUNTRY = 2;
  private static final int METHODID_GET_COUNTRIES_BY_IDS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RococoGeoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RococoGeoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COUNTRY:
          serviceImpl.getCountry((guru.qa.grpc.rococo.grpc.CountryId) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.CountryResponse>) responseObserver);
          break;
        case METHODID_GET_COUNTRY_BY_NAME:
          serviceImpl.getCountryByName((guru.qa.grpc.rococo.grpc.CountryName) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.CountryResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COUNTRY:
          serviceImpl.getAllCountry((guru.qa.grpc.rococo.grpc.AllCountryRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllCountryResponse>) responseObserver);
          break;
        case METHODID_GET_COUNTRIES_BY_IDS:
          serviceImpl.getCountriesByIds((guru.qa.grpc.rococo.grpc.CountryIdsRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rococo.grpc.AllCountryByIdsResponse>) responseObserver);
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

  private static abstract class RococoGeoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RococoGeoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return guru.qa.grpc.rococo.grpc.RococoGeoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RococoGeoService");
    }
  }

  private static final class RococoGeoServiceFileDescriptorSupplier
      extends RococoGeoServiceBaseDescriptorSupplier {
    RococoGeoServiceFileDescriptorSupplier() {}
  }

  private static final class RococoGeoServiceMethodDescriptorSupplier
      extends RococoGeoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RococoGeoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RococoGeoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RococoGeoServiceFileDescriptorSupplier())
              .addMethod(getGetCountryMethod())
              .addMethod(getGetCountryByNameMethod())
              .addMethod(getGetAllCountryMethod())
              .addMethod(getGetCountriesByIdsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
