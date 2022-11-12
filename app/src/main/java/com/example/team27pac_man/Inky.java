package com.example.team27pac_man;

public class Inky {
    //corners from the top and right
    static void chase() {
        if (GameView.getPlayer() != GameView.getInky()) {
            float ghostCenterX = GameView.gethMar() + GameView.getCol(GameView.getInky()) * GameView.getCellSize();
            float ghostCenterY = GameView.getvMar() + GameView.getRow(GameView.getInky()) * GameView.getCellSize();
            float playerCenterX = GameView.gethMar() + GameView.getCol(GameView.getPlayer()) * GameView.getCellSize();
            float playerCenterY = GameView.gethMar() + GameView.getRow(GameView.getPlayer()) * GameView.getCellSize();
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                if ( GameView.getCol(GameView.getInky()) + 1 > GameView.getCol(GameView.getPlayer())) {
                    GameView.setCol(GameView.getInky(), GameView.getCol(GameView.getInky()) - 1);
                } else {
                    GameView.setCol(GameView.getInky() , GameView.getCol(GameView.getInky()) + 1);
                }
            } else {
                if ( GameView.getRow(GameView.getInky()) + 1 > GameView.getRow(GameView.getPlayer())) {
                    GameView.setRow(GameView.getInky(), GameView.getRow(GameView.getInky()) - 1);
                } else {
                    GameView.setRow(GameView.getInky(), GameView.getRow(GameView.getInky()) + 1);
                }
            }
        }
    }
}
