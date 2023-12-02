package com.example.crosswordapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Handler handler;

    // Flags to represent completion status for each level
    private boolean level1Completed = false;
    private boolean level2Completed = false;
    private boolean level3Completed = false;
    private boolean level4Completed = false;
    private boolean level5Completed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        handler = new Handler();

        simulateProgress();

        // Set OnClickListener for Level 1 button
        Button levelButton1 = findViewById(R.id.levelButton1);
        levelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the CrosswordGameActivity when Level 1 button is clicked
                Intent intent = new Intent(MainActivity.this, CrosswordGameActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for Level 2 button
        Button levelButton2 = findViewById(R.id.levelButton2);
        levelButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the CrosswordGameActivity when Level 2 button is clicked
                Intent intent = new Intent(MainActivity.this, CrosswordGameActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for Level 3 button
        Button levelButton3 = findViewById(R.id.levelButton3);
        levelButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the CrosswordGameActivity when Level 3 button is clicked
                Intent intent = new Intent(MainActivity.this, CrosswordGameActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for Level 4 button
        Button levelButton4 = findViewById(R.id.levelButton4);
        levelButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the CrosswordGameActivity when Level 4 button is clicked
                Intent intent = new Intent(MainActivity.this, CrosswordGameActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for Level 5 button
        Button levelButton5 = findViewById(R.id.levelButton5);
        levelButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the CrosswordGameActivity when Level 5 button is clicked
                Intent intent = new Intent(MainActivity.this, CrosswordGameActivity.class);
                startActivity(intent);
            }
        });
    }

    private void simulateProgress() {
        // Simulate progress as before...
    }

    private void updateProgressBar() {
        int totalLevels = 5; // Total number of levels
        int completedLevels = 0;

        // Count the number of completed levels
        if (level1Completed) completedLevels++;
        if (level2Completed) completedLevels++;
        if (level3Completed) completedLevels++;
        if (level4Completed) completedLevels++;
        if (level5Completed) completedLevels++;

        // Calculate progress based on completed levels
        final int progress = (completedLevels * 100) / totalLevels;

        handler.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(progress);
            }
        });
    }
}
