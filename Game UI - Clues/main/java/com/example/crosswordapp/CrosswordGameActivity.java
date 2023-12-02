package com.example.crosswordapp;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CrosswordGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossword_game);

        // Initialize crossword grid
        GridLayout crosswordGrid = findViewById(R.id.crosswordGrid);
        initializeCrosswordGrid(crosswordGrid);

        // Add clues to the layout
        addClues();
    }

    private void initializeCrosswordGrid(GridLayout gridLayout) {
        // Add crossword grid cells dynamically or load from data
        for (int i = 0; i < gridLayout.getRowCount(); i++) {
            for (int j = 0; j < gridLayout.getColumnCount(); j++) {
                TextView cell = new TextView(this);
                cell.setText(""); // Set text or load crossword data
                cell.setBackgroundResource(R.drawable.cell_background); // Customize cell background
                gridLayout.addView(cell);
            }
        }
    }

    private void addClues() {
        // Add clues dynamically or load from data
        LinearLayout cluesLayout = findViewById(R.id.cluesLayout);

        TextView acrossClueHead = new TextView(this);
        acrossClueHead.setText("Across:");
        acrossClueHead.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(acrossClueHead);

        TextView acrossClue1 = new TextView(this);
        acrossClue1.setText("1. A type of rock often used for roofing");
        acrossClue1.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(acrossClue1);

        TextView acrossClue2 = new TextView(this);
        acrossClue2.setText("2. Not fresh anymore");
        acrossClue2.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(acrossClue2);

        TextView acrossClue3 = new TextView(this);
        acrossClue3.setText("3. Minimum or smallest amount");
        acrossClue3.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(acrossClue3);

        TextView newLine = new TextView(this);
        newLine.setText("");
        newLine.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(newLine);

        TextView downClueHead = new TextView(this);
        downClueHead.setText("Down:");
        downClueHead.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(downClueHead);

        TextView downClue1 = new TextView(this);
        downClue1.setText("1. To take something without permission");
        downClue1.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(downClue1);

        TextView downClue2 = new TextView(this);
        downClue2.setText("2. Plural of a story or narrative");
        downClue2.setTextColor(getResources().getColor(android.R.color.white));
        cluesLayout.addView(downClue2);

        // Add more clues as needed
    }
}
