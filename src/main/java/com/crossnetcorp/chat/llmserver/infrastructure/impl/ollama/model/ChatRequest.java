package com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRequest {

    private String model;
    private List<Message> messages;
    private Options options;
    private String format;
    private Boolean stream;
}
