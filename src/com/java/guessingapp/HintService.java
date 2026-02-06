package com.java.guessingapp;

public class HintService {

    public static String generateHint(int target, int hintCount) {

        if (hintCount == 1) {
            return (target % 2 == 0) ? "Hint: Number is EVEN" : "Hint: Number is ODD";
        }

        if (hintCount == 2) {
            return target > 50 ? "Hint: Number is GREATER than 50" : "Hint: Number is LESS than or equal to 50";
        }

        return "No more hints available!";
    }
}

