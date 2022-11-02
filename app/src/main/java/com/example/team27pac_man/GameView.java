package com.example.team27pac_man;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.security.cert.TrustAnchor;

public class GameView extends View {

    private static int score=0;
    private enum Direction{UP,DOWN,LEFT,RIGHT}
    private  final int [][] layout= {
            {5,11,11,3,0,3,3,3,3,7},
            {1,3,7,1,4,4,2,6,4,2},
            {1,0,2,10,5,7,10,5,3,8},
            {1,4,2,1,0,2,1,0,0,12},
            {10,5,0,2,6,8,6,0,0,7},
            {10,1,4,4,11,3,7,1,7,10},
            {6,4,11,11,3,4,4,4,8,13}
    };

    private cell[][] cells;
    private cell player;
    private static final int COLS=7,ROWS=10;
    private float cellSize,hMar,vMar;
    private final float thick = 15;
    private Paint wall;
    private Paint pellets;
    private Paint playerpaint;
    Bitmap pac;
    public static int getScore(){
        return score;
    }
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        wall= new Paint();
        wall.setColor(Color.BLUE);
        wall.setStrokeWidth(thick);
        pellets = new Paint();
        pellets.setColor(Color.YELLOW);
        playerpaint=new Paint();
        playerpaint.setColor(Color.RED);
        createMaze();
    }
    private void createMaze(){
        cells=new cell[COLS][ROWS];
        for(int x = 0;x<COLS;x++){
            for(int y =0;y<ROWS;y++){

                cells[x][y]=new cell(x,y);
                if(layout[x][y]==1){
                    cells[x][y].topWall=true;
                }
                else if (layout[x][y]==2){
                    cells[x][y].bottomWall=true;

                }
                else if (layout[x][y]==3){
                    cells[x][y].leftWall=true;

                }
                else if (layout[x][y]==4){
                    cells[x][y].rightWall=true;

                }
                else if (layout[x][y]==5){
                    cells[x][y].topWall=true;
                    cells[x][y].leftWall=true;

                }
                else if (layout[x][y]==6){
                    cells[x][y].rightWall=true;
                    cells[x][y].topWall=true;

                }
                else if (layout[x][y]==7){
                    cells[x][y].bottomWall=true;
                    cells[x][y].leftWall=true;
                }
                else if (layout[x][y]==8){
                    cells[x][y].rightWall=true;
                    cells[x][y].bottomWall=true;

                }
                else if (layout[x][y]==10){
                    cells[x][y].topWall=true;
                    cells[x][y].bottomWall=true;

                }
                else if (layout[x][y]==11){
                    cells[x][y].rightWall=true;
                    cells[x][y].leftWall=true;

                }
                else if (layout[x][y]==12){
                    cells[x][y].rightWall=true;
                    cells[x][y].leftWall=true;
                    cells[x][y].bottomWall=true;

                }
                else if (layout[x][y]==13){
                    cells[x][y].topWall=true;
                    cells[x][y].bottomWall=true;
                    cells[x][y].rightWall=true;

                }

            }
        }
        player=cells[0][0];

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        int width = getWidth();
        int height =getHeight();
        cellSize = height/(ROWS+1);
        hMar = (width-COLS*cellSize)/2;
        vMar = (height-ROWS*cellSize)/2;
        canvas.translate(hMar,vMar);
        cells[3][9].pellet=false;
        cells[2][4].pellet=false;
        cells[2][5].pellet=false;
        cells[3][4].pellet=false;
        cells[3][5].pellet=false;
        cells[4][4].pellet=false;
        cells[4][5].pellet=false;
        for(int x = 0;x<COLS;x++){
            for(int y =0;y<ROWS;y++){
                if(cells[x][y].pellet){
                    canvas.drawCircle(
                            (x)*cellSize+(cellSize/2),
                            (y)*cellSize+(cellSize/2),
                            cellSize/20,
                            pellets
                    );
                }
                if(cells[x][y].topWall){
                    canvas.drawLine(
                            x*cellSize,
                            y*cellSize,
                            (x+1)*cellSize,
                            y*cellSize,
                            wall
                    );
                }

                if(cells[x][y].leftWall){
                    canvas.drawLine(
                            x*cellSize,
                            y*cellSize,
                            (x)*cellSize,
                            (y+1)*cellSize,
                            wall
                    );
                }

                if(cells[x][y].bottomWall){
                    canvas.drawLine(
                            x*cellSize,
                            (y+1)*cellSize,
                            (x+1)*cellSize,
                            (y+1)*cellSize,
                            wall
                    );
                }

                if(cells[x][y].rightWall){
                    canvas.drawLine(
                            (x+1)*cellSize,
                            y*cellSize,
                            (x+1)*cellSize,
                            (y+1)*cellSize,
                            wall
                    );
                }
            }
        }
        pac=BitmapFactory.decodeResource(getResources(),R.drawable.pac);
        canvas.drawBitmap(pac,(player.col*cellSize)+(cellSize/4),(player.row*cellSize)+(cellSize/4),null);

    }

    private void movePlayer(Direction direction){
        switch (direction){
            case UP:
                if(!player.topWall){
                player=cells[player.col][player.row-1];
                if(!player.visited){
                    player.pellet=false;
                    score=score+1;

                    player.visited=true;
                }
                }
                break;
            case DOWN:
                if(!player.bottomWall){
                    player=cells[player.col][player.row+1];
                    if(!player.visited){
                        player.pellet=false;
                        score=score+1;

                        player.visited=true;
                    }
                }
                break;
            case LEFT:
                if(!player.leftWall){
                    player=cells[player.col-1][player.row];
                    if(!player.visited){
                        player.pellet=false;
                        score=score+1;

                        player.visited=true;
                    }
                }
                break;
            case RIGHT:
                if(!player.rightWall){
                    player=cells[player.col+1][player.row];
                    if(!player.visited){
                        player.pellet=false;
                        score=score+1;
                        
                        player.visited=true;
                    }
                }
                break;
        }
        invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            return true;
        }
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            float x =event.getX();
            float y = event.getY();
            float playerCenterX = hMar+(player.col)*cellSize;
            float playerCenterY = vMar+(player.row)*cellSize;
            float dx = x-playerCenterX;
            float dy = y-playerCenterY;
            float absDx= Math.abs(dx);
            float absDy =Math.abs(dy);
            if(absDx>cellSize||absDy>cellSize){
                if(absDx>absDy){
                    //movex
                    if(dx>0){
                        movePlayer(Direction.RIGHT);
                    }else {
                        //move left
                        movePlayer(Direction.LEFT);
                    }
                } else{
                    //movey
                    if(dy>0){
                        //move up
                        movePlayer(Direction.DOWN);
                    }else {
                        //move down
                        movePlayer(Direction.UP);
                    }
                }
            }
            return true;

        }
        return super.onTouchEvent(event);
    }

    private class cell{
        boolean topWall = false;
        boolean bottomWall = false;
        boolean rightWall = false;
        boolean leftWall =false;
        boolean pellet =true;
        boolean visited =false;
        int col,row;

        public cell(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
}
