package com.crossnetcorp.chat.llmserver.infrastructure.impl;

import com.crossnetcorp.chat.llmserver.infrastructure.LLMService;
import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenizer;

import java.io.IOException;

import static dev.langchain4j.data.message.UserMessage.userMessage;

public class LLMServiceImpl implements LLMService {
    private ChatLanguageModel model;
    private ChatMemory chatMemory;

    public LLMServiceImpl(String apiKey) {
        this.model = OpenAiChatModel.withApiKey(apiKey);// ApiKeys.OPENAI_API_KEY);
        this.chatMemory = TokenWindowChatMemory.withMaxTokens(300, new OpenAiTokenizer("gpt-3.5-turbo"));
    }

    static String PROMPT_TEMPLATE_ENGLISH = "As %s i need you to answer the following question to the best of your ability:\n"
            + "\n" + "Question:\n" + "%s\n" + "\n" + "Base your answer on the following information:\n" + "%s";

    @Override
    public String answer(String role, String context, String question) {
        String prompt = String.format(PROMPT_TEMPLATE_ENGLISH, role, question, context);
        System.out.println(prompt);
        this.chatMemory.add(userMessage(prompt));
        AiMessage answer = this.model.generate(chatMemory.messages()).content();
        this.chatMemory.add(answer);
        String response = answer.text();
        System.out.println(response);
        return response;
    }
}
