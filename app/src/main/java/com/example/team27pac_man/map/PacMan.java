package com.example.team27pac_man.map;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team27pac_man.Maze;
import com.example.team27pac_man.R;
import com.example.team27pac_man.configure;

public class PacMan  {
    int res;
    ImageView iView;
    Integer [] grid;
    Integer pos;
    public PacMan() {
        res = configure.getPacRes();
        grid = Maze.getDisplayIds();
        switch(res) {
            case 1:
                iView.setImageResource(R.drawable.mr_pacman);
                break;
            case 2:
                iView.setImageResource(R.drawable.ms_pacman);
                break;
            case 3:
                iView.setImageResource(R.drawable.aware_pacman);
        }
        pos = grid.length-9;
    }
    public void move(){
        onKey
    }
}
