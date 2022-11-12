package com.example.team27pac_man;

public class Binky  {
    //his name is Blinky, mb. He directly chases though.
    static void chase() {
        if (GameView.getPlayer() != GameView.getBlinky()) {
            float ghostCenterX = GameView.gethMar() + GameView.getCol(GameView.getBlinky()) * GameView.getCellSize();
            float ghostCenterY = GameView.getvMar() + GameView.getRow(GameView.getBlinky()) * GameView.getCellSize();
            float playerCenterX = GameView.gethMar() + GameView.getCol(GameView.getPlayer()) * GameView.getCellSize();
            float playerCenterY = GameView.gethMar() + GameView.getRow(GameView.getPlayer()) * GameView.getCellSize();
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                if ( GameView.getCol(GameView.getBlinky()) > GameView.getCol(GameView.getPlayer()) && !GameView.getLeft(GameView.getBlinky())) {
                    GameView.setCol(GameView.getBlinky(), GameView.getCol(GameView.getBlinky()) - 1);
                } else if (!GameView.getRight(GameView.getBlinky())) {
                    GameView.setCol(GameView.getBlinky() , GameView.getCol(GameView.getBlinky()) + 1);
                }
            } else {
                if ( GameView.getRow(GameView.getBlinky()) > GameView.getRow(GameView.getPlayer()) && !GameView.getTop(GameView.getBlinky())) {
                    GameView.setRow(GameView.getBlinky(), GameView.getRow(GameView.getBlinky()) - 1);
                } else if (!GameView.getBottom(GameView.getBlinky())) {
                    GameView.setRow(GameView.getBlinky(), GameView.getRow(GameView.getBlinky()) + 1);
                }
            }
        }
    }
}
