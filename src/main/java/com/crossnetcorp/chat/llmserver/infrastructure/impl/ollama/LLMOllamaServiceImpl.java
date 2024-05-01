package com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama;

import com.crossnetcorp.chat.llmserver.infrastructure.LLMService;
import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;

import com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama.model.*;

import java.io.IOException;

import static dev.langchain4j.data.message.UserMessage.userMessage;

public class LLMOllamaServiceImpl implements LLMService {
    private final OllamaClient client;
    private static String OLLAMA_URL = "http://localhost:11434";

    private String modelName;
    public LLMOllamaServiceImpl(String apiKey) {
	this.client = OllamaClient.builder().baseUrl(OLLAMA_URL).build();
	this.modelName = "gemma:2b";
    }

    static String PROMPT_TEMPLATE_ENGLISH = "As %s i need you to answer the following question to the best of your ability:\n"
            + "\n" + "Question:\n" + "%s\n" + "\n" + "Base your answer on the following information:\n" + "%s";

    @Override
    public String answer(String role, String context, String question) {
        String prompt = String.format(PROMPT_TEMPLATE_ENGLISH, role, question, context);
        System.out.println(prompt);
        //this.chatMemory.add(userMessage(prompt));
        //AiMessage answer = this.model.generate(chatMemory.messages()).content();
        //this.chatMemory.add(answer);
        //String response = answer.text();
	Options options = Options.builder()
		.temperature(0.7)
		.build();

	CompletionRequest request = CompletionRequest.builder()
                .model(modelName)
                //.messages(toOllamaMessages(messages))
                .prompt(prompt)
		.options(options)
                //.format(format)
                .stream(false)
                .build();

	// ChatResponse response = withRetry(() -> 
	CompletionResponse response = client.completion(request);
	// , maxRetries);
	
	//String responseText = response.getResponse();
    	//String model;
    	//String createdAt;
    	//String response;
    	//Boolean done;
    	//Integer promptEvalCount;
    	//Integer evalCount;


        System.out.println(response.getResponse());
        return response.getResponse();
    }

}
