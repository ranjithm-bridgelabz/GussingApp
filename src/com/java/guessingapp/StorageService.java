package com.java.guessingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StorageService {

    public static void saveResult(String playerName, boolean result) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("game_results.txt", true))) {

            writer.write(playerName + " | " + (result ? "WIN" : "LOSS"));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving game result");
        }
    }
}

