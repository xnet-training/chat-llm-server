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

    @Override
    public String answer(String role, String context, String question) {
        this.chatMemory
                .add(userMessage(String.format("Hi, as a %s using %s please answer %s", role, context, question)));
        AiMessage answer = this.model.generate(chatMemory.messages()).content();
        this.chatMemory.add(answer);
        return answer.text();
    }
}
