package com.E01FetchingResultsets;

import java.sql.*;

public class Pr02GetVillainNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    //Replace with your user name
    private static final String USER = "root";
    //Replace with your password
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = null;

            String query = String.format("SELECT\n" +
                    "villain_name,\n" +
                    "COUNT(vm.minion_id) as minion_count\n" +
                    "FROM villains as v\n" +
                    "INNER JOIN villains_minions as vm\n" +
                    "  ON v.villain_id = vm.villain_id\n" +
                    "GROUP BY villain_name\n" +
                    "HAVING COUNT(vm.minion_id) >%d",3);

            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String villain_name = resultSet.getString("villain_name");
                Integer minion_count = resultSet.getInt("minion_count");
                System.out.println(String.format("%s, %d",villain_name, minion_count));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
