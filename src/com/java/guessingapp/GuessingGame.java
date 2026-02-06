package com.java.guessingapp;
import java.util.Scanner;
/*
User input, higher / lower / correct feedback
 */
public class GuessingGame {

    private GameConfig config;
    private Scanner scanner;

    public GuessingGame() {
        config = new GameConfig();
        scanner = new Scanner(System.in);
    }

    public boolean startGame() {

        config.displayWelcomeMessage();

        while (config.getAttemptsLeft() > 0) {
            try {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (!ValidationService.isValidRange(guess)) {
                    throw new IllegalArgumentException("Guess must be between 1 and 100");
                }

                config.decrementAttempts();

                if (guess == config.getTargetNumber()) {
                    System.out.println("🎉 Correct! You won!");
                    return true;
                }

                if (guess > config.getTargetNumber()) {
                    System.out.println("Too HIGH!");
                } else {
                    System.out.println("Too LOW!");
                }

                if (config.getHintCount() < 2) {
                    config.incrementHint();
                    System.out.println(
                            HintService.generateHint(config.getTargetNumber(), config.getHintCount())
                    );
                }

                System.out.println("Attempts left: " + config.getAttemptsLeft());
                System.out.println("--------------------------------");

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        System.out.println("❌ Game Over! Number was: " + config.getTargetNumber());
        return false;
    }
}
