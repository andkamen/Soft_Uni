package com.E01FetchingResultsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pr05ChangeTownNamesCasing {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String targetCountry = reader.readLine();


        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            ResultSet resultSet = null;
            Statement statement = connection.createStatement();

            String query = String.format("SELECT name FROM towns\n" +
                    "WHERE country = '%s'\n" +
                    "ORDER BY town_id", targetCountry);

            resultSet = statement.executeQuery(query);
            List<String> townsToChange = new ArrayList<>();

            while (resultSet.next()) {
                townsToChange.add(resultSet.getString("name"));
            }

            for (String town : townsToChange) {
                query = String.format(" UPDATE towns\n" +
                        "            SET name = '%s'\n" +
                        "            WHERE name = '%s'", town.toUpperCase(), town);

                statement.executeUpdate(query);

                town = town.toUpperCase();
            }

            System.out.println(String.format("%d town names were affected. %s", townsToChange.size(), townsToChange.toString().toUpperCase()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
