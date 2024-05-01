package com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.output.TokenUsage;
import lombok.Builder;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static java.lang.Boolean.TRUE;

import com.crossnetcorp.chat.llmserver.infrastructure.impl.ollama.model.*;

public class OllamaClient {
    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
            .create();

    private final OllamaApi ollamaApi;

    @Builder
    public OllamaClient(String baseUrl, Duration timeout) {
	OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .callTimeout(timeout)
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .writeTimeout(timeout)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .build();

        ollamaApi = retrofit.create(OllamaApi.class);
    }

    public CompletionResponse completion(CompletionRequest request) {
        try {
            retrofit2.Response<CompletionResponse> retrofitResponse
                    = ollamaApi.completion(request).execute();

            if (retrofitResponse.isSuccessful()) {
                return retrofitResponse.body();
            } else {
                throw toException(retrofitResponse);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ChatResponse chat(ChatRequest request) {
        try {
            retrofit2.Response<ChatResponse> retrofitResponse
                    = ollamaApi.chat(request).execute();

            if (retrofitResponse.isSuccessful()) {
                return retrofitResponse.body();
            } else {
                throw toException(retrofitResponse);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private RuntimeException toException(retrofit2.Response<?> response) throws IOException {
        int code = response.code();
        String body = response.errorBody().string();

        String errorMessage = String.format("status code: %s; body: %s", code, body);
        return new RuntimeException(errorMessage);
    }
}
