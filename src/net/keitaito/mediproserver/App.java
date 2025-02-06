package net.keitaito.mediproserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.net.httpserver.HttpServer;

import net.keitaito.mediproserver.handlers.IndexHandler;

public class App {

    private Connection connection;
    private final String dbUrl = System.getenv("DATABASE_URL") != null ? System.getenv("DATABASE_URL")
            : "jdbc:sqlite:medipro.db";

    public void init() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        try {
            connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS inputs (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, world_name TEXT, input_text TEXT)";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException, ClassNotFoundException {
        int port = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/v1/inputs", new IndexHandler(this));
        server.createContext("/",
                e -> {
                    // hello world
                    String response = "Hello World!";
                    e.sendResponseHeaders(200, response.length());
                    e.getResponseBody().write(response.getBytes());

                    e.close();
                });
        server.start();
        System.out.println("Server started on port " + port);
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        App app = new App();
        try {
            app.init();
            app.start();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
