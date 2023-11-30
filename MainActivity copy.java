package com.example.crosswordgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "CrosswordPreferences";
    private static final String KEY_CURRENT_LEVEL = "currentLevel";

    private CrosswordGame crosswordGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crosswordGame = new CrosswordGame();

        Button resumeButton = findViewById(R.id.SaveGame);
        Button shareButton = findViewById(R.id.shareButton);

        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load saved level and resume the game
                int savedLevel = loadSavedLevel();
                crosswordGame.resumeGame(savedLevel);
                // Add code to start the game activity
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Share achievement
                shareAchievement(crosswordGame.getScore());
            }
        });

        Button saveButton = findViewById(R.id.SaveGame);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCurrentLevel(crosswordGame.getCurrentLevel());
                showSavedMessage();
            }
        });
    }

    private void showSavedMessage() {
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    // Save the current level
    private void saveCurrentLevel(int level) {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putInt(KEY_CURRENT_LEVEL, level);
        editor.apply();
    }

    // Load the saved level
    private int loadSavedLevel() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return prefs.getInt(KEY_CURRENT_LEVEL, 1); // Default level is 1
    }

    // Share achievement on social media
    private void shareAchievement(int score) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "I just scored " + score + " in Crossword Game!");
        startActivity(Intent.createChooser(shareIntent, "Share your achievement"));
    }
}


