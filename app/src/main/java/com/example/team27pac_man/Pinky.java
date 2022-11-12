package com.example.team27pac_man;

public class Pinky{
    //this one corners the left and bottom
    static void chase() {
        if (GameView.getPlayer() != GameView.getPinky()) {
            float ghostCenterX = GameView.gethMar() + GameView.getCol(GameView.getPinky()) * GameView.getCellSize();
            float ghostCenterY = GameView.getvMar() + GameView.getRow(GameView.getPinky()) * GameView.getCellSize();
            float playerCenterX = GameView.gethMar() + GameView.getCol(GameView.getPlayer()) * GameView.getCellSize();
            float playerCenterY = GameView.gethMar() + GameView.getRow(GameView.getPlayer()) * GameView.getCellSize();
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                if ( GameView.getCol(GameView.getPinky()) - 1 > GameView.getCol(GameView.getPlayer())) {
                    GameView.setCol(GameView.getPinky(), GameView.getCol(GameView.getPinky()) - 1);
                } else {
                    GameView.setCol(GameView.getPinky() , GameView.getCol(GameView.getPinky()) + 1);
                }
            } else {
                if ( GameView.getRow(GameView.getPinky()) - 1 > GameView.getRow(GameView.getPlayer())) {
                    GameView.setRow(GameView.getPinky(), GameView.getRow(GameView.getPinky()) - 1);
                } else {
                    GameView.setRow(GameView.getPinky(), GameView.getRow(GameView.getPinky()) + 1);
                }
            }
        }
    }
}
