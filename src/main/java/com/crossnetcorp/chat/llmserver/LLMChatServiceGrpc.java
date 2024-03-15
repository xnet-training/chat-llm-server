package com.crossnetcorp.chat.llmserver;

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
@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.15.0)", comments = "Source: llm-server.proto")
public final class LLMChatServiceGrpc {

    private LLMChatServiceGrpc() {
    }

    public static final String SERVICE_NAME = "LLMChatService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.crossnetcorp.chat.llmserver.LlmServer.PingRequest, com.crossnetcorp.chat.llmserver.LlmServer.PingResponse> getPingMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "ping", requestType = com.crossnetcorp.chat.llmserver.LlmServer.PingRequest.class, responseType = com.crossnetcorp.chat.llmserver.LlmServer.PingResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.crossnetcorp.chat.llmserver.LlmServer.PingRequest, com.crossnetcorp.chat.llmserver.LlmServer.PingResponse> getPingMethod() {
        io.grpc.MethodDescriptor<com.crossnetcorp.chat.llmserver.LlmServer.PingRequest, com.crossnetcorp.chat.llmserver.LlmServer.PingResponse> getPingMethod;
        if ((getPingMethod = LLMChatServiceGrpc.getPingMethod) == null) {
            synchronized (LLMChatServiceGrpc.class) {
                if ((getPingMethod = LLMChatServiceGrpc.getPingMethod) == null) {
                    LLMChatServiceGrpc.getPingMethod = getPingMethod = io.grpc.MethodDescriptor.<com.crossnetcorp.chat.llmserver.LlmServer.PingRequest, com.crossnetcorp.chat.llmserver.LlmServer.PingResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName("LLMChatService", "ping"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                    com.crossnetcorp.chat.llmserver.LlmServer.PingRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                    com.crossnetcorp.chat.llmserver.LlmServer.PingResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new LLMChatServiceMethodDescriptorSupplier("ping")).build();
                }
            }
        }
        return getPingMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest, com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse> getAnswerMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "answer", requestType = com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest.class, responseType = com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest, com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse> getAnswerMethod() {
        io.grpc.MethodDescriptor<com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest, com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse> getAnswerMethod;
        if ((getAnswerMethod = LLMChatServiceGrpc.getAnswerMethod) == null) {
            synchronized (LLMChatServiceGrpc.class) {
                if ((getAnswerMethod = LLMChatServiceGrpc.getAnswerMethod) == null) {
                    LLMChatServiceGrpc.getAnswerMethod = getAnswerMethod = io.grpc.MethodDescriptor.<com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest, com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName("LLMChatService", "answer"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                    com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                    com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new LLMChatServiceMethodDescriptorSupplier("answer")).build();
                }
            }
        }
        return getAnswerMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static LLMChatServiceStub newStub(io.grpc.Channel channel) {
        return new LLMChatServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static LLMChatServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
        return new LLMChatServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static LLMChatServiceFutureStub newFutureStub(io.grpc.Channel channel) {
        return new LLMChatServiceFutureStub(channel);
    }

    /**
     */
    public static abstract class LLMChatServiceImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * Consultar por la disponibilidad del servicio
         * </pre>
         */
        public void ping(com.crossnetcorp.chat.llmserver.LlmServer.PingRequest request,
                io.grpc.stub.StreamObserver<com.crossnetcorp.chat.llmserver.LlmServer.PingResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
        }

        /**
         * <pre>
         * Responder a pregunta usando LLM
         * </pre>
         */
        public void answer(com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest request,
                io.grpc.stub.StreamObserver<com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getAnswerMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(getPingMethod(), asyncUnaryCall(
                            new MethodHandlers<com.crossnetcorp.chat.llmserver.LlmServer.PingRequest, com.crossnetcorp.chat.llmserver.LlmServer.PingResponse>(
                                    this, METHODID_PING)))
                    .addMethod(getAnswerMethod(), asyncUnaryCall(
                            new MethodHandlers<com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest, com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse>(
                                    this, METHODID_ANSWER)))
                    .build();
        }
    }

    /**
     */
    public static final class LLMChatServiceStub extends io.grpc.stub.AbstractStub<LLMChatServiceStub> {
        private LLMChatServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private LLMChatServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected LLMChatServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LLMChatServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * Consultar por la disponibilidad del servicio
         * </pre>
         */
        public void ping(com.crossnetcorp.chat.llmserver.LlmServer.PingRequest request,
                io.grpc.stub.StreamObserver<com.crossnetcorp.chat.llmserver.LlmServer.PingResponse> responseObserver) {
            asyncUnaryCall(getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         * Responder a pregunta usando LLM
         * </pre>
         */
        public void answer(com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest request,
                io.grpc.stub.StreamObserver<com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse> responseObserver) {
            asyncUnaryCall(getChannel().newCall(getAnswerMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class LLMChatServiceBlockingStub extends io.grpc.stub.AbstractStub<LLMChatServiceBlockingStub> {
        private LLMChatServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private LLMChatServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected LLMChatServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LLMChatServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * Consultar por la disponibilidad del servicio
         * </pre>
         */
        public com.crossnetcorp.chat.llmserver.LlmServer.PingResponse ping(
                com.crossnetcorp.chat.llmserver.LlmServer.PingRequest request) {
            return blockingUnaryCall(getChannel(), getPingMethod(), getCallOptions(), request);
        }

        /**
         * <pre>
         * Responder a pregunta usando LLM
         * </pre>
         */
        public com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse answer(
                com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest request) {
            return blockingUnaryCall(getChannel(), getAnswerMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class LLMChatServiceFutureStub extends io.grpc.stub.AbstractStub<LLMChatServiceFutureStub> {
        private LLMChatServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private LLMChatServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected LLMChatServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LLMChatServiceFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         * Consultar por la disponibilidad del servicio
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.crossnetcorp.chat.llmserver.LlmServer.PingResponse> ping(
                com.crossnetcorp.chat.llmserver.LlmServer.PingRequest request) {
            return futureUnaryCall(getChannel().newCall(getPingMethod(), getCallOptions()), request);
        }

        /**
         * <pre>
         * Responder a pregunta usando LLM
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse> answer(
                com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest request) {
            return futureUnaryCall(getChannel().newCall(getAnswerMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_PING = 0;
    private static final int METHODID_ANSWER = 1;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final LLMChatServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(LLMChatServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
            case METHODID_PING:
                serviceImpl.ping((com.crossnetcorp.chat.llmserver.LlmServer.PingRequest) request,
                        (io.grpc.stub.StreamObserver<com.crossnetcorp.chat.llmserver.LlmServer.PingResponse>) responseObserver);
                break;
            case METHODID_ANSWER:
                serviceImpl.answer((com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest) request,
                        (io.grpc.stub.StreamObserver<com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse>) responseObserver);
                break;
            default:
                throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
            default:
                throw new AssertionError();
            }
        }
    }

    private static abstract class LLMChatServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        LLMChatServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.crossnetcorp.chat.llmserver.LlmServer.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("LLMChatService");
        }
    }

    private static final class LLMChatServiceFileDescriptorSupplier extends LLMChatServiceBaseDescriptorSupplier {
        LLMChatServiceFileDescriptorSupplier() {
        }
    }

    private static final class LLMChatServiceMethodDescriptorSupplier extends LLMChatServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        LLMChatServiceMethodDescriptorSupplier(String methodName) {
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
            synchronized (LLMChatServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new LLMChatServiceFileDescriptorSupplier()).addMethod(getPingMethod())
                            .addMethod(getAnswerMethod()).build();
                }
            }
        }
        return result;
    }
}
