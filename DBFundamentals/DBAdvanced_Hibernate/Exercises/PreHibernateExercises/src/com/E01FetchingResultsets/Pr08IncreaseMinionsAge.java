package com.E01FetchingResultsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class Pr08IncreaseMinionsAge {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] minion_ids = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String getMinionDataStr = "SELECT minion_name FROM minions " +
                "WHERE minion_id = ? ";

        String updateMinionDataStr = "UPDATE minions " +
                "SET minion_name = ? ," +
                "    age = age + 1 " +
                "WHERE minion_id = ? ";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement getMinionData = connection.prepareStatement(getMinionDataStr);
             PreparedStatement updateMinionData = connection.prepareStatement(updateMinionDataStr);
        ) {
            ResultSet resultSet = null;

            for (int minion_id : minion_ids) {
                //get minion by id
                getMinionData.setInt(1, minion_id);
                resultSet = getMinionData.executeQuery();

                resultSet.next();
                String minion_name = resultSet.getString("minion_name");

                //change minion name to title Case.
                String[] nameData = minion_name.split(" ");
                String titleCaseName = "";
                for (int i = 0; i < nameData.length; i++) {
                    //capitalize first letter
                    titleCaseName += ("" + nameData[i].charAt(0)).toUpperCase();
                    //if name is longer than 1 letter, add the rest of it
                    if (nameData[i].length() > 1) {
                        titleCaseName += nameData[i].substring(1).toLowerCase();
                    }
                    //add separation between name parts
                    titleCaseName += " ";
                }

                updateMinionData.setString(1, titleCaseName.trim());
                updateMinionData.setInt(2, minion_id);
                updateMinionData.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
