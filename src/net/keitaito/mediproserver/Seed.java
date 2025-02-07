package net.keitaito.mediproserver;

import java.sql.Connection;

public class Seed {

    public void start() throws ClassNotFoundException {
        App app = new App();
        app.init();
        Connection connection = app.getConnection();
        String[] sqls = {
                "INSERT INTO inputs (name, world_name, input_text) VALUES ('Alice', '0_tutorial', 'I am Alice.')",
                "INSERT INTO inputs (name, world_name, input_text) VALUES ('Bob', '0_tutorial', 'I am Bob.')",
                "INSERT INTO inputs (name, world_name, input_text) VALUES ('Charlie', '0_tutorial', 'I am Charlie.')",
                "INSERT INTO inputs (name, world_name, input_text) VALUES ('Alice', '2_walking', 'I am Alice.')",
                "INSERT INTO inputs (name, world_name, input_text) VALUES ('Bob', '2_walking', 'I am Bob.')",
                "INSERT INTO inputs (name, world_name, input_text) VALUES ('Charlie', '3_spike', 'I am Charlie.')",
        };
        for (String sql : sqls) {
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Seed seed = new Seed();
        try {
            seed.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
