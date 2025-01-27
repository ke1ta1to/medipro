package net.keitaito.mediproserver.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class IndexHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responseBody = "Hello, world\n";

        int statusCode = 200;

        exchange.sendResponseHeaders(statusCode, responseBody.length());
        exchange.getResponseBody().write(responseBody.getBytes());
        exchange.close();
    }

}
