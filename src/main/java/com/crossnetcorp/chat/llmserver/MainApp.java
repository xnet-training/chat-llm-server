package com.crossnetcorp.chat.llmserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class MainApp {
    static String COPYRIGHT_MSG = "CROSSNET SAC | Copyright (c) 2024\n" + "Todos los derechos reservados.\n"
            + "gRPC Server started at %d";

    public static void main(String[] args) {
        try {
            Integer port = args.length > 0 ? Integer.parseInt(args[0]) : 8999;
            String apiKey = args.length > 1 ? args[0] : System.getenv("API_KEY");

            Server server = ServerBuilder.forPort(port).addService(new LlmServerImpl(apiKey)).build();

            server.start();
            System.out.println(String.format(COPYRIGHT_MSG, server.getPort()));
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
