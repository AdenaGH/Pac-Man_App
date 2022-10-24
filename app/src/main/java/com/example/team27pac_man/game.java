package com.example.team27pac_man;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class game extends AppCompatActivity {
    TextView lives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        lives = findViewById(R.id.textView4);
        String dif =getIntent().getStringExtra("difficulty");
        if(dif.equals("Passive")){
            lives.setText("6");
        }
        if(dif.equals("Easy")){
            lives.setText("5");
        }
        if(dif.equals("Medium")){
            lives.setText("4");
        }
        if(dif.equals("Hard")){
            lives.setText("3");
        }
        if(dif.equals("Expert")){
            lives.setText("2");
        }

    }
}