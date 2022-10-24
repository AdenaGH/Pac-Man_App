package com.example.sprint1intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);
        Button start = (Button) (findViewById(R.id.start_button));
        Button quit = (Button) (findViewById(R.id.quit_button));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.initial_configuration);
                //Intent intent = new Intent(IntroScreen.this, MainActivity.class);
                //startActivity(intent);
            }
        });
        quit.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}