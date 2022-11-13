package com.example.team27pac_man;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class End extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        Button restart = (Button) findViewById(R.id.restart_button);
        Button quit = (Button) findViewById(R.id.end_button);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Restart works");
                setContentView(R.layout.initial_configuration);
                Intent intent = new Intent(End.this, configure.class);
                startActivity(intent);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
                finishAffinity();
                //System.exit(0);

            }
        });
    }
}
