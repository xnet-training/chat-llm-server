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
public class Message {

    private Role role;
    private String content;
    private List<String> images;
}
