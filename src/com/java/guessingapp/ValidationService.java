package com.java.guessingapp;
public class ValidationService {

    public static boolean isValidRange(int guess) {
        return guess >= 1 && guess <= 100;
    }
}

