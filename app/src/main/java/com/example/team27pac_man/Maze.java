package com.example.team27pac_man;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.content.Context;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.util.DisplayMetrics;
import androidx.appcompat.app.AppCompatActivity;

public class Maze extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int screenWidth;
    private int totalRows;
    private int totalColumns;
    private int blockLength;
    private Bitmap[][] layout;
//    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maze);
        TextView playerName = (TextView) findViewById(R.id.nameTextView);
        TextView score = (TextView) findViewById(R.id.scoreTextView);
        TextView lives = (TextView) findViewById(R.id.livesTextView);
        TextView difficulty = (TextView) findViewById(R.id.difficultyTextView);
        playerName.setText("Player name: "+ configure.getPlayerName());
        lives.setText("Lives: "+ configure.getLives());
        difficulty.setText("Difficulty: " + configure.getDifficulty());
        //score.setText();
        initializeSize(); //creates the maze
    }

    public void initializeSize(){
        createNewLayout();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;// width of screen
        totalColumns = 16; // 408 pixels into 16 columns- column size = 25
        totalRows = 20; // 520 pixels into 20 rows - row size = 26
//        screenHeight = displayMetrics.heightPixels;
        //height and width of an image
        blockLength = screenWidth/totalColumns;
//        int blockHeight = screenHeight/totalRows;
        initializeBitMap(blockLength);
//
//        };
    }
    private void initializeBitMap(int blockSize){
        int spriteSize = (blockSize/9) * 9; // multiple of 9
        int ghostBoxSize = blockSize * 4; // for 4 ghosts
    }

    //layout key:
    // 0: random wall
    // 1: normal pellets
    // 2: pacman(starting position)
    // 3: ghosts(starting position)
    // 4: ghostbox
    // 5: do nothing(skip the block)
    // 6: horizontal long wall(for border)
    // 7: vetical long wall(for border)
    // 8: power pellets - 5
    private void createNewLayout(){
        int[][] layoutIds = {
                {6, 5, 6, 5, 6, 5, 6, 5, 6, 5, 6, 5, 6, 5, 6, 5},
                {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
                {7, 5, 1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 7, 5},
                {5, 5, 1, 0, 5, 1, 0, 5, 1, 1, 0, 5, 1, 1, 5, 5},
                {7, 5, 8, 5, 5, 1, 5, 5, 1, 1, 5, 5, 1, 1, 7, 5},
                {5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5},
                {7, 5, 1, 0, 5, 1, 1, 1, 1, 1, 1, 0, 5, 1, 7, 5},
                {5, 5, 1, 5, 5, 1, 1, 1, 1, 1, 1, 5, 5, 8, 5, 5},
                {5, 5, 1, 1, 1, 1, 4, 5, 5, 5, 1, 1, 1, 1, 5, 5},
                {5, 5, 1, 0, 5, 1, 5, 3, 3, 5, 1, 0, 5, 1, 5, 5},
                {5, 5, 1, 5, 5, 1, 5, 3, 3, 5, 1, 5, 5, 1, 5, 5},
                {5,5,1,1,1,1,5,5,5,5,1,8,1,1,5,5},
                {7, 5, 1, 0, 5, 1, 1, 1, 1, 1, 1, 0, 5, 1, 7, 5},
                {5,5,1,5,5,1,0,5,1,1,1,5,5,1,5,5},
                {7,5,1,1,1,1,5,5,1,1,1,1,1,1,7,5},
                {5,5,1,0,5,1,1,1,1,1,0,5,1,1,5,5},
                {7,5,1,5,5,1,1,1,1,1,5,5,1,1,7,5},
                {5,5,1,1,1,1,1,1,8,1,1,1,1,1,5,5},
                {6,5,6,5,6,5,5,5,5,5,6,5,6,5,7,5},
                {5,5,5,5,5,5,5,2,5,5,5,5,5,5,5,5}

        };
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
