package com.example.team27pac_man;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Maze extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maze);
        TextView playerName = (TextView) findViewById(R.id.nameTextView);
        TextView score = (TextView) findViewById(R.id.scoreTextView);
        TextView lives = (TextView) findViewById(R.id.livesTextView);
        TextView difficulty = (TextView) findViewById(R.id.difficultyTextView);
        //playerName.setText();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
