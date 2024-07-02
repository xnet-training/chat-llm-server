package com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama;

import com.crossnetcorp.chat.llmserver.infrastructure.LLMService;
import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;

import com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama.model.*;

import java.time.Duration;
import java.io.IOException;

import static dev.langchain4j.data.message.UserMessage.userMessage;

public class LLMOllamaServiceImpl implements LLMService {
    private final OllamaClient client;
    public static String OLLAMA_URL = "http://localhost:11434";
    private String modelName;

    public LLMOllamaServiceImpl(String model, String url, String apiKey) {
        this.client = OllamaClient.builder().baseUrl(url).timeout(Duration.ofSeconds(600)).build();
        this.modelName = model; // "gemma:2b";
    }

    static String PROMPT_TEMPLATE_ENGLISH = "As %s i need you to answer the following question to the best of your ability. If not enough information answer you does not know. Be very specific in your answer:\n"
            + "Question:\n" + "%s\n" + "Base your answer on the following information:\n" + "%s";

    static String PROMPT_TEMPLATE_SPANISH_0 = "Como %s necesito respuesta a la siguiente pregunta, sin ser creativo y respondiendo de forma concisa y precisa solo usando la informacion de contexto provista. Si no conocer la respuesta simplemente responder ´Lo siento, información no disponible'\n"
            + "Pregunta: %s\n" + "Utilizar la siguient informacion contextual: \n %s";

    static String PROMPT_TEMPLATE_SPANISH = "Eres un asistente %1$s eficiente que debe dar una respuesta clara y precisa "
            + "a la siguiente pregunta solo utilizando la información del contexto.\n" + "Pregunta: %2s \n"
            + "Contexto: %3s\n\n"
            + "Solo utilizar la información de contexto provista. Si no conoces la respuesta responder 'No tengo información suficiente en el contexto'";

    @Override
    public String answer(String role, String context, String question) {
        String prompt = "Eres un asistente " + role + " eficiente que debe dar una respuesta clara y precisa "
                + "a la siguiente pregunta solo utilizando la información del contexto." + "\nPregunta: " + question
                + "\nContexto: " + context
                + "\n\nSolo utilizar la información de contexto provista. Si no conoces la respuesta responder 'No tengo información suficiente en el contexto'";

        // String.format(PROMPT_TEMPLATE_SPANISH, role, question, context);
        System.out.println(String.format("Usando modelo: %s", this.modelName));
        System.out.println(prompt);
        // this.chatMemory.add(userMessage(prompt));
        // AiMessage answer = this.model.generate(chatMemory.messages()).content();
        // this.chatMemory.add(answer);
        // String response = answer.text();
        Options options = Options.builder().temperature(0.7).build();

        CompletionRequest request = CompletionRequest.builder().model(modelName)
                // .messages(toOllamaMessages(messages))
                .prompt(prompt).options(options)
                // .format(format)
                .stream(false).build();

        // ChatResponse response = withRetry(() ->
        CompletionResponse response = client.completion(request);
        // , maxRetries);

        // String responseText = response.getResponse();
        // String model;
        // String createdAt;
        // String response;
        // Boolean done;
        // Integer promptEvalCount;
        // Integer evalCount;

        System.out.println(response.getResponse());
        return response.getResponse();
    }

}
