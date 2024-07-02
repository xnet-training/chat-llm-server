package com.crossnetcorp.chat.llmserver;

import com.crossnetcorp.chat.llmserver.LlmServer.PingResponse;
import com.crossnetcorp.chat.llmserver.LlmServer.PingRequest;
import com.crossnetcorp.chat.llmserver.LlmServer.QuestionRequest;
import com.crossnetcorp.chat.llmserver.LlmServer.QuestionResponse;

import com.crossnetcorp.chat.llmserver.infrastructure.LLMService;
import com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama.LLMOllamaServiceImpl;

public class LlmServerImpl extends LLMChatServiceGrpc.LLMChatServiceImplBase {
    private LLMService llmService = null;
    private String apiKey;
    private String model;
    private String url;

    public LlmServerImpl(String model, String url, String apiKey) {
        this.apiKey = apiKey;
        this.model = model;
        this.url = url;
        this.llmService = new LLMOllamaServiceImpl(model, url, apiKey); // LLMOllamaServiceImpl.OLLAMA_URL, null );
                                                                        // //new LLMServiceImpl(apiKey);
    }

    @Override
    public void ping(PingRequest request, io.grpc.stub.StreamObserver<PingResponse> responseObserver) {
        PingResponse response = PingResponse.newBuilder().setResponse(request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void answer(QuestionRequest request, io.grpc.stub.StreamObserver<QuestionResponse> responseObserver) {
        // System.out.println(String.format("As %s a need %s using %s", request.getRole(), request.getQuestion(),
        // request.getContext()));
        System.out.println("Role: " + request.getRole());
        System.out.println("Contexto: " + request.getContext());
        System.out.println("Pregunta: " + request.getQuestion());

        String replay = this.llmService.answer(request.getRole(), request.getContext(), request.getQuestion());
        QuestionResponse response = QuestionResponse.newBuilder().setResponse(replay)
                // .setResponse("Desconozco sobre el tema consultado. No estoy entrenado para responder su pregunta")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /*
     * @Override public void asyncAnswer(QuestionRequest request, io.grpc.stub.StreamObserver<AsyncQuestionResponse>
     * responseObserver) {
     *
     * this.llmService.asyncAnswer(request.getRole(), request.getContext(), request.getQuestion(), (answer) -> {
     * QuestionResponse response = QuestionResponse.newBuilder().setResponse(answer); responseObserver.onNext(response);
     * }); responseObserver.onCompleted(); }
     */
}
