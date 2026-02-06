package com.java.guessingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * UC5 - Game result storage using File Handling and JDBC
 */
public class StorageService {

    // JDBC configuration
    private static final String URL =
            "jdbc:mysql://localhost:3306/guessing_app";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void saveResult(String playerName, boolean result) {

       //store in file
        saveToFile(playerName, result);

        // store in database
        saveToDatabase(playerName, result);
    }

    /*
     * File handling storage
     */
    private static void saveToFile(String playerName, boolean result) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("game_results.txt", true))) {

            writer.write(playerName + " | " + (result ? "WIN" : "LOSS"));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving result to file");
        }
    }

    /*
     * JDBC storage
     */
    private static void saveToDatabase(String playerName, boolean result) {

        String sql =
                "INSERT INTO game_results (player_name, result) VALUES (?, ?)";

        try (Connection con =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, playerName);
            ps.setString(2, result ? "WIN" : "LOSS");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error saving result to database");
        }
    }
}
