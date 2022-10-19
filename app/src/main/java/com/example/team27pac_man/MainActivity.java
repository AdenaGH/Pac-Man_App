package com.example.team27pac_man;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration);

        Spinner spinner = (Spinner) findViewById(R.id.difficultySpinner);
        Spinner spriteSpinner = (Spinner) findViewById(R.id.spriteSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficultiesArray,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spritesArray,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spriteSpinner.setAdapter(adapter2);
        spriteSpinner.setOnItemSelectedListener(this);

        TextView errorMessage = (TextView) findViewById(R.id.errorTextView);

        Button contButton = (Button) findViewById(R.id.startButton);
        Button startButton = (Button) findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = (EditText) findViewById(R.id.nameEditText);
                String playerName;
                if (editName.getText().toString().contains(" ")
                        || editName.getText().toString().isEmpty()
                        || editName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid name", Toast.LENGTH_LONG).show();

                    errorMessage.setTextColor(Color.RED);
                    errorMessage.setVisibility(View.VISIBLE);
                    contButton.setVisibility(View.GONE);
                    playerName = "Invalid input";
                } else {
                    errorMessage.setVisibility(View.GONE);
                    playerName = editName.getText().toString();

                    contButton.setVisibility(View.VISIBLE);
                    contButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setContentView(R.layout.activity_game);
                        }
                    });
                }
                TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
                nameTextView.setText("Player: " + playerName);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        switch (parent.getId()) {
            case R.id.difficultySpinner: {
                String text = parent.getItemAtPosition(pos).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);
                difficultyText.setText("Difficulty: " + text);
            }
            case R.id.spriteSpinner: {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                String text = parent.getItemAtPosition(pos).toString();
                if (text.equals("mrPacMan")) {
                    imageView.setImageResource(R.drawable.mr_pacman);
                } else if (text.equals("msPacMan")) {
                    imageView.setImageResource(R.drawable.ms_pacman);
                } else {
                    imageView.setImageResource(R.drawable.aware_pacman);
                }
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
