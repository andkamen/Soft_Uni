package com.E01FetchingResultsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class Pr09IncreaseAgeStoredProcedure {
    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int minion_id = Integer.parseInt(reader.readLine());

        String callProcedure = "CALL usp_get_older(?);";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement increaseAge = connection.prepareCall(callProcedure)
        ) {
            increaseAge.setInt(1, minion_id);

            ResultSet resultSet = increaseAge.executeQuery();

            while (resultSet.next()) {
                String minion_name = resultSet.getString("minion_name");
                int age = resultSet.getInt("age");

                System.out.printf("%s %d \n",minion_name, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
