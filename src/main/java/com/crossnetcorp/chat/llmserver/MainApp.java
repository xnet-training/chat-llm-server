package com.crossnetcorp.chat.llmserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {
        try {
            Integer port = args.length > 0 ? Integer.parseInt(args[0]) : 8999;
            String apiKey = args.length > 1 ? args[0] : System.getenv("API_KEY");

            Server server = ServerBuilder.forPort(port).addService(new LlmServerImpl(apiKey)).build();

            server.start();
            System.out.println(
                    "CROSSNET SAC | Copyright (c) 2024\nTodos los derechos reservados.\ngRPC Server started at "
                            + server.getPort());
            System.out.println(String.format("LLM API Key: %s", apiKey));
            server.awaitTermination();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
