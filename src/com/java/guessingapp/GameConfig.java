package com.java.guessingapp;

import java.util.Random;

public class GameConfig {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;

    private int targetNumber;
    private int attemptsLeft;
    private int hintCount;

    public GameConfig() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
        this.attemptsLeft = MAX_ATTEMPTS;
        this.hintCount = 0;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void decrementAttempts() {
        attemptsLeft--;
    }

    public int getHintCount() {
        return hintCount;
    }

    public void incrementHint() {
        hintCount++;
    }

    public void displayWelcomeMessage() {
        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Rules:");
        System.out.println("- Guess a number between 1 and 100");
        System.out.println("- Maximum attempts: 7");
        System.out.println("- Hints are limited");
        System.out.println("------------------------------------");
    }
}

