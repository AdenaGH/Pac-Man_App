package com.example.team27pac_man;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.os.Handler;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.team27pac_man.Maze;
import com.example.team27pac_man.R;
import com.example.team27pac_man.configure;

public class Pacman  {
    int res;
    ImageView iView;
    Integer [] grid;
    Integer pos;
    float x1;
    float x2;
    float y1;
    float y2;
    final Handler handler = new Handler();
    public static int LONG_PRESS_TIME = 750;
    int nextDirection = 2;

    public Pacman() {
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
    Runnable longPressed = new Runnable() {
        public void run() {
            Log.i("info", "LongPress");
//            Intent pauseIntent = new Intent(getContext(), PauseActivity.class);
//            getContext().startActivity(pauseIntent);
        }
    };

    //    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case(MotionEvent.ACTION_DOWN): {
                x1 = event.getX();
                y1 = event.getY();
                handler.postDelayed(longPressed, LONG_PRESS_TIME);
                break;
            }
            case(MotionEvent.ACTION_UP):{
                x2 = event.getX();
                y2 = event.getY();
                calcSwipeDirection();
                handler.removeCallbacks(longPressed);
                break;
            }
        }
        return true;
    }

    private void calcSwipeDirection() {
        float xDiff = (x2 - x1);
        float yDiff = (y2 - y1);
        if(Math.abs(yDiff) > Math.abs(xDiff)){
            if(yDiff < 0){
                nextDirection = 0;
            } else if(yDiff > 0){
                nextDirection = 2;
            }
        } else{
            if(xDiff <0){
                nextDirection = 3;
            } else if(xDiff > 0){
                nextDirection = 1;
            }
        }
    }

//    public void movePacman(){
//        onKeyP
//    }


}

