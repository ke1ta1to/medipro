package net.keitaito.mediproserver;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import net.keitaito.mediproserver.handlers.IndexHandler;

public class App {

    public void start() throws IOException {
        int port = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/v1", new IndexHandler());
        server.start();
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.start();
    }

}
