package com.example.team27pac_man;

public class Pinky{
    //this one corners the left and bottom
    static void chase() {
        //cell player = GameView.getPlayer();
        if (GameView.getPlayer() != GameView.getPinky()) {
            float ghostCenterX = GameView.gethMar() + GameView.getCol(GameView.getPinky()) * GameView.getCellSize();
            float ghostCenterY = GameView.getvMar() + GameView.getRow(GameView.getPinky()) * GameView.getCellSize();
            float playerCenterX = GameView.gethMar() + GameView.getCol(GameView.getPlayer()) * GameView.getCellSize();
            float playerCenterY = GameView.gethMar() + GameView.getRow(GameView.getPlayer()) * GameView.getCellSize();
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                //moveLeft *if pinky cell is not a left wall
                if ( GameView.getCol(GameView.getPinky()) > GameView.getCol(GameView.getPlayer()) - 1 && !GameView.getLeft(GameView.getPinky()))  {
                    GameView.setCol(GameView.getPinky(), GameView.getCol(GameView.getPinky()) - 1);
                } else if (!GameView.getRight(GameView.getPinky())) {
                    //move right
                    GameView.setCol(GameView.getPinky() , GameView.getCol(GameView.getPinky()) + 1);
                }
            } else {
                if ( GameView.getRow(GameView.getPinky()) > GameView.getRow(GameView.getPlayer()) - 1 && !GameView.getTop(GameView.getPinky())) {
                    //move up *if pinky cell is not a top wall
                    GameView.setRow(GameView.getPinky(), GameView.getRow(GameView.getPinky()) - 1);
                } else if (!GameView.getBottom(GameView.getPinky())) {
                    //move down
                    GameView.setRow(GameView.getPinky(), GameView.getRow(GameView.getPinky()) + 1);
                }
            }
        }

    }
}
