package com.crossnetcorp.chat.llmserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.crossnetcorp.chat.llmserver.LlmServer.PingResponse;
import com.crossnetcorp.chat.llmserver.LlmServer.PingRequest;
import com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest;
import com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse;

public class LlmServerImpl extends LLMChatServiceGrpc.LLMChatServiceImplBase {
    @Override
    public void ping(PingRequest request, io.grpc.stub.StreamObserver<PingResponse> responseObserver) {
        PingResponse response = PingResponse.newBuilder().setResponse(request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void answer(QuestionRequest request, io.grpc.stub.StreamObserver<QuestionResponse> responseObserver) {
        QuestionResponse response = QuestionResponse.newBuilder()
                .setResponse("Desconozco sobre el tema consultado. No estoy entrenado para responder su pregunta")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
