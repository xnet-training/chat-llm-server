package com.crossnetcorp.chat.llmserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class MainApp {
    static String COPYRIGHT_MSG = "CROSSNET SAC | Copyright (c) 2024\n" + "Todos los derechos reservados.\n"
            + "gRPC Server started at %d";

    static String DEFAULT_MODEL_ID = "gemma:2b";

    public static void main(String[] args) {
        try {
            Integer port = args.length > 0 ? Integer.parseInt(args[0]) : 8999;
            String apiKey = args.length > 1 ? args[1] : System.getenv("API_KEY");
            String url = args.length > 2 ? args[2] : System.getenv("OLLAMA_URL");
            String model = args.length > 3 ? args[3] : System.getenv("MODEL_ID");

            model = (model == null || (model != null && "".equals(model.trim()))) ? DEFAULT_MODEL_ID : model;

            Server server = ServerBuilder.forPort(port).addService(new LlmServerImpl(model, url, apiKey)).build();

            server.start();
            System.out.println(String.format(COPYRIGHT_MSG, server.getPort()));
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
