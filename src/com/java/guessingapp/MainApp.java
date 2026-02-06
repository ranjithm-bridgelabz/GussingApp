package com.java.guessingapp;

import java.util.Scanner;

/*
 * Handles game restart and exit
 */
public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.print("Enter Player Name: ");
        String playerName = scanner.nextLine();

        while (playAgain) {

            GuessingGame game = new GuessingGame();
            boolean result = game.startGame();

            StorageService.saveResult(playerName, result);

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = scanner.next();

            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("👋 Thank you for playing!");
        scanner.close();
    }
}

