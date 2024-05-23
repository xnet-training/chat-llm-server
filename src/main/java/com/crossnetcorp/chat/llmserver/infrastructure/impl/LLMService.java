package com.crossnetcorp.chat.llmserver.infrastructure;

public interface LLMService {
    public String answer(String role, String context, String question);
    public String asyncAnswer(String role, String context, String question, Function<String> callback);
}
