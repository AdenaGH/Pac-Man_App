package com.example.team27pac_man;

//import static com.example.team27pac_man.GameView.*;

import android.util.Log;

public class Clyde {
    //@Override
    static void chase() {
        double c_f = Math.random();

        if ( 0 < 1) {
            System.out.println(c_f);
            if (GameView.getPlayer() != GameView.getClyde()) {
                float ghostCenterX = GameView.gethMar() + GameView.getCol(GameView.getClyde()) * GameView.getCellSize();
                float ghostCenterY = GameView.getvMar() + GameView.getRow(GameView.getClyde()) * GameView.getCellSize();
                float playerCenterX = GameView.gethMar() + GameView.getCol(GameView.getPlayer()) * GameView.getCellSize();
                float playerCenterY = GameView.gethMar() + GameView.getRow(GameView.getPlayer()) * GameView.getCellSize();
                float dx = Math.abs(playerCenterX - ghostCenterX);
                float dy = Math.abs(playerCenterY - ghostCenterY);
                if (dx > dy) {
                    //moveLeft
                    if (GameView.getCol(GameView.getClyde()) > GameView.getCol(GameView.getPlayer()) && !GameView.getLeft(GameView.getClyde())) {
                        //GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) - 1);
                    } else if (!GameView.getRight(GameView.getClyde())) {
                        //GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) + 1);
                    }
//                    }  else if (GameView.getRow(GameView.getClyde()) > GameView.getRow(GameView.getPlayer()) && !GameView.getTop(GameView.getClyde())) {
//                        //GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) - 1);
//                    } else if (!GameView.getBottom(GameView.getClyde())) {
//                        //GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) + 1);
//                    }
                } else {
                    if (GameView.getRow(GameView.getClyde()) > GameView.getRow(GameView.getPlayer())) {// && !GameView.getTop(GameView.getClyde())) {
                        GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) + 1);
                    } else if (GameView.getRow(GameView.getClyde()) > GameView.getRow(GameView.getPlayer())) { //&& !GameView.getBottom(GameView.getClyde())) {
                        GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) - 1);
                    }
//                    } else if (GameView.getCol(GameView.getClyde()) > GameView.getCol(GameView.getPlayer()) && !GameView.getLeft(GameView.getClyde())) {
//                        GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) - 1);
//                    } else if (!GameView.getRight(GameView.getClyde())) {
//                        GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) + 1);
//                    }
                }
            }
        } else {
            //fleeing bc clyde is a bit silly
        }
            if (GameView.getPlayer() != GameView.getClyde()) {
                float ghostCenterX = GameView.gethMar() + GameView.getCol(GameView.getClyde()) * GameView.getCellSize();
                float ghostCenterY = GameView.getvMar() + GameView.getRow(GameView.getClyde()) * GameView.getCellSize();
                float playerCenterX = GameView.gethMar() + GameView.getCol(GameView.getPlayer()) * GameView.getCellSize();
                float playerCenterY = GameView.gethMar() + GameView.getRow(GameView.getPlayer()) * GameView.getCellSize();
                float dx = Math.abs(playerCenterX - ghostCenterX);
                float dy = Math.abs(playerCenterY - ghostCenterY);
                if (dx > dy) {
                    if (GameView.getCol(GameView.getClyde()) > GameView.getCol(GameView.getPlayer())) {
                        GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) + 1);
                    } else {
                        GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) - 1);
                    }
                } else {
                    if (GameView.getRow(GameView.getClyde()) > GameView.getRow(GameView.getPlayer())) {
                        GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) + 1);
                    } else {
                        GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) - 1);
                    }
                }

        }
    }
}
