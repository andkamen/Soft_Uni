package com.E01FetchingResultsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pr07PrintAllMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet = null;

            String query = String.format("SELECT minion_name FROM minions\n" +
                    "                    ORDER BY minion_id");

            resultSet = statement.executeQuery(query);
            List<String> minions = new ArrayList<>();

            while (resultSet.next()) {
                minions.add(resultSet.getString("minion_name"));
            }
            int forward_index = 0;
            int reverse_index = minions.size() - 1;
            for (int i = 0; i <= minions.size() / 2; i++) {
                if (forward_index == reverse_index) {
                    System.out.println(minions.get(forward_index++));
                    break;
                } else {
                    System.out.println(minions.get(forward_index++));
                }
                System.out.println(minions.get(reverse_index--));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
