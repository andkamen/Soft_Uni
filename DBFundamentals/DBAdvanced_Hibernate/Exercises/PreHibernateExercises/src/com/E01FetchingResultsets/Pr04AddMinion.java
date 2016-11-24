package com.E01FetchingResultsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Pr04AddMinion {
    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] minionData = reader.readLine().split(" ");
        String[] villainData = reader.readLine().split(" ");

        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];
        String villainName = villainData[1];
        Integer town_id = null;
        Integer minion_id = null;
        Integer villain_id = null;  //minions_villains should have worked with names not ids ☻ ↓

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            ResultSet resultSet = null;
            Statement statement = connection.createStatement();

            //check if town exists.
            String query = String.format("SELECT name FROM towns\n" +
                    "WHERE name = '%s'", minionTown);

            resultSet = statement.executeQuery(query);

            //this returns false if the cursor is not before the first record or if there are no rows in the ResultSet.
            //if town doesn't exist -> add it
            if (!resultSet.isBeforeFirst()) {
                query = String.format("INSERT INTO towns(name)\n" +
                        "VALUES ('%s');", minionTown);

                int count = statement.executeUpdate(query);
                if (count > 0) {
                    System.out.println(String.format("Town %s was added to the database.", minionTown));
                }
            }

            //check if villain exists
            query = String.format("SELECT villain_name FROM villains\n" +
                    "WHERE villain_name = '%s'", villainName);

            resultSet = statement.executeQuery(query);

            //if not, add it
            if (!resultSet.isBeforeFirst()) {
                query = String.format("INSERT INTO villains(villain_name, evilness_factor)\n" +
                        "VALUES ('%s','%s');", villainName, "evil");

                int updateCount = statement.executeUpdate(query);
                if (updateCount > 0) {
                    System.out.println(String.format("Villain %s was added to the database.", villainName));
                }
            }

            //get id of the minion's town (minion table stores town id not its name)
            query = String.format("SELECT town_id FROM towns\n" +
                    "WHERE name = '%s'", minionTown);

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                town_id = resultSet.getInt("town_id");
            }

            //add minion to table
            query = String.format("INSERT INTO minions(minion_name, age, town_id)\n" +
                    "VALUES ('%s',%d,%d);", minionName, minionAge, town_id);

            statement.executeUpdate(query);

            //get id of the minion (that was just added) that needs to be set to a villain
            query = String.format("SELECT minion_id FROM minions\n" +
                    "WHERE minion_name = '%s' AND age = %d AND minions.town_id = %d", minionName, minionAge, town_id);

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                minion_id = resultSet.getInt("minion_id");
            }

            //get villain id as well
            query = String.format("SELECT villain_id FROM villains\n" +
                    "WHERE villain_name = '%s'", villainName);

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                villain_id = resultSet.getInt("villain_id");
            }

            //FINALLY add minion to be a servant of the villain using their IDs

            query = String.format("INSERT INTO villains_minions(villain_id, minion_id)\n" +
                    "VALUES (%d,%d);", villain_id, minion_id);

            int updateCount = statement.executeUpdate(query);
            if (updateCount > 0) {
                System.out.println(String.format("Successfully added %s to be minion of %s",minionName, villainName));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
