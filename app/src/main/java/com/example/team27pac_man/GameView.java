package com.example.team27pac_man;

import android.app.Activity;
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
    Context context;
    private static int score=0;
    private enum Direction{UP,DOWN,LEFT,RIGHT}
    private  final int [][] layout= {
            {5,11,11,3,0,3,3,3,3,7},
            {1,3,7,1,4,4,2,6,4,2},
            {1,0,2,10,5,7,10,5,3,8},
            {1,4,2,10,0,2,1,0,0,12},
            {10,5,0,2,6,8,1,4,4,7},
            {10,1,4,4,11,3,0,3,7,10},
            {6,4,11,11,3,4,4,4,4,8}
    };

    private cell[][] cells;
    private static cell player;
    private static cell blue_ghost;
    private static cell pink_ghost;
    private static cell red_ghost;
    private static cell yellow_ghost;
    private static final int COLS=7,ROWS=10;
    private static float cellSize,hMar,vMar;
    private final float thick = 15;
    private Paint thinwall;
    private Paint wall;
    private Paint pellets;
    private  Paint power;
    Bitmap pac;
    Bitmap blue;
    Bitmap red;
    Bitmap yellow;
    Bitmap pink;
    public static int getScore(){
        return score;
    }
    public static void setScore(int score) {
        GameView.score = score;
    }
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        wall= new Paint();
        wall.setColor(Color.BLUE);
        wall.setStrokeWidth(thick);
        thinwall= new Paint();
        thinwall.setColor(Color.WHITE);
        thinwall.setStrokeWidth(5);
        pellets = new Paint();
        pellets.setColor(Color.YELLOW);
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
        player=cells[3][9];
        blue_ghost=cells[2][4];
        red_ghost=cells[2][5];
        pink_ghost=cells[4][4];
        yellow_ghost=cells[4][5];


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
        cells[3][9].visited=true;
        for(int x = 0;x<COLS;x++){
            for(int y =0;y<ROWS;y++){

                if(cells[x][y].pellet){
                    if((x==0 && y ==0)||(x==6 && y==0)||(x==0 && y ==9)||(x==6 && y ==9)){
                        canvas.drawCircle(
                                (x)*cellSize+(cellSize/2),
                                (y)*cellSize+(cellSize/2),
                                cellSize/5,
                                pellets
                        );

                    }else {
                        canvas.drawCircle(
                                (x)*cellSize+(cellSize/2),
                                (y)*cellSize+(cellSize/2),
                                cellSize/20,
                                pellets
                        );
                    }

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
                    if(x==3 && y==3){
                        canvas.drawLine(
                                x*cellSize,
                                (y+1)*cellSize,
                                (x+1)*cellSize,
                                (y+1)*cellSize,
                                thinwall
                        );

                    }else{
                        canvas.drawLine(
                                x*cellSize,
                                (y+1)*cellSize,
                                (x+1)*cellSize,
                                (y+1)*cellSize,
                                wall
                        );

                    }


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
        switch(configure.getPacRes()) {
            case 1:
                pac=BitmapFactory.decodeResource(getResources(),R.drawable.mrpac);
                break;
            case 2:
                pac=BitmapFactory.decodeResource(getResources(),R.drawable.mspacman);
                break;
            case 3:
                pac=BitmapFactory.decodeResource(getResources(),R.drawable.awarepac);
                break;
        }
        canvas.drawBitmap(pac,(player.col*cellSize)+(cellSize/4),(player.row*cellSize)+(cellSize/4),null);


        blue=BitmapFactory.decodeResource(getResources(),R.drawable.blue);
        canvas.drawBitmap(blue,(blue_ghost.col*cellSize)+(cellSize/4),(blue_ghost.row*cellSize)+(cellSize/4),null);
        pink=BitmapFactory.decodeResource(getResources(),R.drawable.pink);
        canvas.drawBitmap(pink,(pink_ghost.col*cellSize)+(cellSize/4),(pink_ghost.row*cellSize)+(cellSize/4),null);
        red=BitmapFactory.decodeResource(getResources(),R.drawable.red);
        canvas.drawBitmap(red,(red_ghost.col*cellSize)+(cellSize/4),(red_ghost.row*cellSize)+(cellSize/4),null);
        yellow=BitmapFactory.decodeResource(getResources(), R.drawable.yellow);
        canvas.drawBitmap(yellow,(yellow_ghost.col*cellSize)+(cellSize/4),(yellow_ghost.row*cellSize)+(cellSize/4),null);

    }

    private void movePlayer(Direction direction){
        switch (direction){
            case UP:
                if(!player.topWall){
                    player=cells[player.col][player.row-1];
                    if(!player.visited){
                        player.pellet=false;
                        if((player.col==0 && player.row ==0)||(player.col==6 && player.row==0)||(player.col==0 && player.row==9)||(player.col==6 && player.row==9)){
                            score=score+10; //make a bigger change?
                        }else{
                            score=score+1;

                        }

                        TextView scoreText = (TextView) ((Maze)context).findViewById(R.id.scoreTextView);
                        scoreText.setText("Score: " + score);
                        scoreText.invalidate();
                        player.visited=true;
                    }
                }
                break;
            case DOWN:
                if(!player.bottomWall){
                    player=cells[player.col][player.row+1];
                    if(!player.visited){

                        player.pellet=false;
                        if((player.col==0 && player.row ==0)||(player.col==6 && player.row==0)||(player.col==0 && player.row==9)||(player.col==6 && player.row==9)){
                            score=score+10;
                        }else{
                            score=score+1;

                        }

                        TextView scoreText = (TextView) ((Maze)context).findViewById(R.id.scoreTextView);
                        scoreText.setText("Score: " + score);
                        scoreText.invalidate();
                        player.visited=true;
                    }
                }
                break;
            case LEFT:
                if(!player.leftWall){
                    if(player.col==0 && player.row==4){
                        player=cells[6][4];
                    }else{player=cells[player.col-1][player.row];}

                    if(!player.visited){

                        player.pellet=false;
                        if((player.col==0 && player.row ==0)||(player.col==6 && player.row==0)||(player.col==0 && player.row==9)||(player.col==6 && player.row==9)){
                            score=score+10;
                        }else{
                            score=score+1;

                        }

                        TextView scoreText = (TextView) ((Maze)context).findViewById(R.id.scoreTextView);
                        scoreText.setText("Score: " + score);
                        scoreText.invalidate();
                        player.visited=true;
                    }
                }
                break;
            case RIGHT:

                if(!player.rightWall){
                    if(player.col==6 && player.row==4){
                        player=cells[0][4];
                    }else{player=cells[player.col+1][player.row];}
                    if(!player.visited){

                        player.pellet=false;
                        if((player.col==0 && player.row ==0)||(player.col==6 && player.row==0)||(player.col==0 && player.row==9)||(player.col==6 && player.row==9)){
                            score=score+10;
                        }else{
                            score=score+1;

                        }

                        TextView scoreText = (TextView) ((Maze)context).findViewById(R.id.scoreTextView);
                        scoreText.setText("Score: " + score);
                        scoreText.invalidate();
                        player.visited=true;
                    }
                }
                break;
        }
        clydeChase();
        blinkyChase();
        inkyChase();
        pinkyChase();
        invalidate();
        if(player == red_ghost || player == yellow_ghost || player == blue_ghost || player == pink_ghost) {
          //
        }
    }
    public static cell getPlayer() {
        return player;
    }
    public static cell getClyde() {
        return yellow_ghost;
    }
    public static cell getPinky() {
        return pink_ghost;
    }
    public static cell getInky() {
        return blue_ghost;
    }
    public static cell getBlinky() {
        return red_ghost;
    }
    public static float getCellSize() {
        return cellSize;
    }
    public static float gethMar() {
        return hMar;
    }
    public static float getvMar() {
        return vMar;
    }

    public static int getCol(cell cell) {
        return cell.col;
    }
    public static int getRow(cell cell) {
        return cell.row;
    }
    public static void setCol(cell cell, int newCol) {
        cell.col = newCol;
    }
    public static void setRow(cell cell, int newRow) {
        cell.row = newRow;
    }
    public static boolean getLeft(cell cell) {
        return cell.leftWall;
    }
    public static boolean getRight(cell cell) {
        return cell.rightWall;
    }
    public static boolean getTop(cell cell) {
        return cell.topWall;
    }
    public static boolean getBottom(cell cell) {
        return cell.bottomWall;
    }

     void pinkyChase() {
        //cell player = player;
        if (player != pink_ghost) {
            float ghostCenterX = hMar + (pink_ghost.col) * cellSize;
            float ghostCenterY = vMar + GameView.getRow(pink_ghost) * cellSize;
            float playerCenterX = hMar + (player.col) * cellSize;
            float playerCenterY = hMar + GameView.getRow(player) * cellSize;
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                //moveLeft *if pinky cell is not a left wall
                if ( (pink_ghost.col) > (player.col) - 1 )  {
                   //pink_ghost.col = pink_ghost.col - 1;
                    pink_ghost= cells[pink_ghost.col-1][pink_ghost.row];
                } else if (!pink_ghost.rightWall) {
                    //move right
                    pink_ghost= cells[pink_ghost.col+1][pink_ghost.row];
                }
            } else {
                if ( (pink_ghost.row) > (player.row) - 1 && !pink_ghost.topWall) {
                    //move up *if pinky cell is not a top wall
                    pink_ghost= cells[pink_ghost.col][pink_ghost.row - 1];
                } else if (!pink_ghost.bottomWall)  {
                    //move down
                    pink_ghost= cells[pink_ghost.col][pink_ghost.row + 1];
                }
            }
        }

    }

    void blinkyChase() {
        //cell player = player;
        if (player != red_ghost) {
            float ghostCenterX = hMar + (red_ghost.col) * cellSize;
            float ghostCenterY = vMar + GameView.getRow(red_ghost) * cellSize;
            float playerCenterX = hMar + (player.col) * cellSize;
            float playerCenterY = hMar + GameView.getRow(player) * cellSize;
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                //moveLeft *if pinky cell is not a left wall
                if ( (red_ghost.col) > (player.col) + 1 && !red_ghost.leftWall)  {
                    //red_ghost.col = red_ghost.col - 1;
                    red_ghost= cells[red_ghost.col-1][red_ghost.row];
                } else if (!red_ghost.rightWall) {
                    //move right
                    red_ghost= cells[red_ghost.col+1][red_ghost.row];
                }
            } else {
                if ( (red_ghost.row) > (player.row) + 1 && !red_ghost.topWall) {
                    //move up *if pinky cell is not a top wall
                    red_ghost= cells[red_ghost.col][red_ghost.row - 1];
                } else if (!red_ghost.bottomWall)  {
                    //move down
                    red_ghost= cells[red_ghost.col][red_ghost.row + 1];
                }
            }
        }

    }

    void inkyChase() {
        //cell player = player;
        if (player != blue_ghost) {
            float ghostCenterX = hMar + (blue_ghost.col) * cellSize;
            float ghostCenterY = vMar + GameView.getRow(blue_ghost) * cellSize;
            float playerCenterX = hMar + (player.col) * cellSize;
            float playerCenterY = hMar + GameView.getRow(player) * cellSize;
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                //moveLeft *if pinky cell is not a left wall
                if ( (blue_ghost.col) > (player.col) && !blue_ghost.leftWall)  {
                    //blue_ghost.col = blue_ghost.col - 1;
                    blue_ghost= cells[blue_ghost.col-1][blue_ghost.row];
                } else if (!blue_ghost.rightWall) {
                    //move right
                    blue_ghost= cells[blue_ghost.col+1][blue_ghost.row];
                }
            } else {
                if ( (blue_ghost.row) > (player.row)  && !blue_ghost.topWall) {
                    //move up *if pinky cell is not a top wall
                    blue_ghost= cells[blue_ghost.col][blue_ghost.row - 1];
                } else if (!blue_ghost.bottomWall)  {
                    //move down
                    blue_ghost= cells[blue_ghost.col][blue_ghost.row + 1];
                }
            }
        }

    }

    void clydeChase() {
        //cell player = player;
        if (player != pink_ghost) {
            float ghostCenterX = hMar + (pink_ghost.col) * cellSize;
            float ghostCenterY = vMar + GameView.getRow(pink_ghost) * cellSize;
            float playerCenterX = hMar + (player.col) * cellSize;
            float playerCenterY = hMar + GameView.getRow(player) * cellSize;
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            double rand = Math.random();
            //sometimes he flees
            if (rand < 0.51) {
                if (dx > dy) {
                    //moveLeft *if pinky cell is not a left wall
                    if ((pink_ghost.col) > (player.col) && !pink_ghost.leftWall) {
                        //pink_ghost.col = pink_ghost.col - 1;
                        pink_ghost = cells[pink_ghost.col - 1][pink_ghost.row];
                    } else if (!pink_ghost.rightWall) {
                        //move right
                        pink_ghost = cells[pink_ghost.col + 1][pink_ghost.row];
                    }
                } else {
                    if ((pink_ghost.row) > (player.row) && !pink_ghost.topWall) {
                        //move up *if pinky cell is not a top wall
                        pink_ghost = cells[pink_ghost.col][pink_ghost.row - 1];
                    } else if (!pink_ghost.bottomWall) {
                        //move down
                        pink_ghost = cells[pink_ghost.col][pink_ghost.row + 1];
                    }
                }
            } else {
                if (dx > dy) {
                    //moveLeft *if pinky cell is not a left wall
                    if ((pink_ghost.col) > (player.col) && !pink_ghost.leftWall) {
                        //pink_ghost.col = pink_ghost.col - 1;
                        pink_ghost = cells[pink_ghost.col + 1][pink_ghost.row];
                    } else if (!pink_ghost.rightWall) {
                        //move right
                        pink_ghost = cells[pink_ghost.col - 1][pink_ghost.row];
                    }
                } else {
                    if ((pink_ghost.row) > (player.row) && !pink_ghost.topWall) {
                        //move up *if pinky cell is not a top wall
                        pink_ghost = cells[pink_ghost.col][pink_ghost.row + 1];
                    } else if (!pink_ghost.bottomWall) {
                        //move down
                        pink_ghost = cells[pink_ghost.col][pink_ghost.row - 1];
                    }
                }
            }
        }

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

                        movePlayer(Direction.DOWN);
                    }else {

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
