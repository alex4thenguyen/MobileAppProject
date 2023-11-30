package com.example.crosswordgame;

public class CrosswordGame {

    private static final int MAX_LEVEL = 5; // Adjust this based on the number of levels in your game

    private int currentLevel;
    private int score;

    public CrosswordGame() {
        // Initialize game variables
        currentLevel = 1;
        score = 0;
    }

    // Methods for game logic, scoring, etc.

    public void resumeGame(int level) {
        // Implement logic to resume the game at the specified level
        if (level > 0 && level <= MAX_LEVEL) {
            currentLevel = level;
        } else {
            // Handle invalid level
            currentLevel = 1;
        }
    }

    public int getScore() {
        return score;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

}

