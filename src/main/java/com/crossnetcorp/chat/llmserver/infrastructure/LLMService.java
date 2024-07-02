package com.crossnetcorp.chat.llmserver.infrastructure;

public interface LLMService {
    /**
     * Consulta sincrona contra base de conocimientos.
     *
     * @param role
     * @param context
     * @param question
     *
     * @return
     */
    public String answer(String role, String context, String question);

    /**
     * Consulta asíncrona contra la base de conocimientos.
     */
    // public String asyncAnswer(String role, String context, String question, Function<String> callback);
}
