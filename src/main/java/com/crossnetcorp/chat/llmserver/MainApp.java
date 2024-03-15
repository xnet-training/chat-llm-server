package com.crossnetcorp.chat.llmserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(8999).addService(new LlmServerImpl()).build();
            server.start();
            System.out.println("CROSSNETCORP\n\ngRPC Server started at " + server.getPort());
            server.awaitTermination();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
