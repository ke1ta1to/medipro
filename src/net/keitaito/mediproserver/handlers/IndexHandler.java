package net.keitaito.mediproserver.handlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import net.keitaito.mediproserver.App;
import net.keitaito.mediproserver.Inputs;

public class IndexHandler implements HttpHandler {

    private final App app;
    private Gson gson = new Gson();

    public IndexHandler(App app) {
        this.app = app;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equals("GET")) {
            // リクエストをprint
            System.out.println(exchange.getRequestMethod() + " " + exchange.getRequestURI());
            String sql = "SELECT * FROM inputs";
            Connection connection = app.getConnection();
            try {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                List<Inputs> inputs = new ArrayList<>();
                while (resultSet.next()) {
                    Inputs input = new Inputs();
                    input.setId(resultSet.getInt("id"));
                    input.setName(resultSet.getString("name"));
                    input.setWorld_name(resultSet.getString("world_name"));
                    input.setInput_text(resultSet.getString("input_text"));
                    inputs.add(input);
                }

                String json = gson.toJson(inputs);

                int statusCode = 200;
                Headers headers = exchange.getResponseHeaders();
                headers.add("Content-Type", "application/json");
                String responseBody = json;
                exchange.sendResponseHeaders(statusCode, responseBody.length());
                exchange.getResponseBody().write(responseBody.getBytes());
                exchange.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (exchange.getRequestMethod().equals("POST")) {
            // ボディーからjsonを生成
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            Inputs input = gson.fromJson(requestBody, Inputs.class);

            // insert
            String sql = "INSERT INTO inputs (name, world_name, input_text) VALUES ('" + input.getName() + "','"
                    + input.getWorld_name() + "', '" + input.getInput_text() + "')";

            Connection connection = app.getConnection();
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);

                int statusCode = 201;
                Headers headers = exchange.getResponseHeaders();
                headers.add("Content-Type", "application/json");
                exchange.sendResponseHeaders(statusCode, 0);
                exchange.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int statusCode = 405;
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, 0);
        exchange.close();
    }
}
