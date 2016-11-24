package com.E01FetchingResultsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Pr03GetMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villain_id = Integer.parseInt(reader.readLine());


        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = null;
            String query = String.format("SELECT\n" +
                    "  villain_name,\n" +
                    "  minion_name,\n" +
                    "  age\n" +
                    "FROM villains as v\n" +
                    "INNER JOIN villains_minions as vm\n" +
                    "  ON v.villain_id = vm.villain_id\n" +
                    "INNER JOIN minions as m\n" +
                    "  ON vm.minion_id = m.minion_id\n" +
                    "WHERE v.villain_id = %d;", villain_id);


            resultSet = statement.executeQuery(query);

            int counter = 1;
            while (resultSet.next()) {
                if (resultSet.isFirst()) {
                    String villain_name = resultSet.getString("villain_name");
                    System.out.println(String.format("Villain: %s", villain_name));
                }

                String minion_name = resultSet.getString("minion_name");
                Integer minion_count = resultSet.getInt("age");
                System.out.println(String.format("%d. %s %d", counter++, minion_name, minion_count));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
