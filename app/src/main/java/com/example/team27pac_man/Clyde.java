package com.example.team27pac_man;

//import static com.example.team27pac_man.GameView.*;

public class Clyde {
    //@Override
    static void chase() {
        if (GameView.getPlayer() != GameView.getClyde()) {
            float ghostCenterX = GameView.gethMar() + GameView.getCol(GameView.getClyde()) * GameView.getCellSize();
            float ghostCenterY = GameView.getvMar() + GameView.getRow(GameView.getClyde()) * GameView.getCellSize();
            float playerCenterX = GameView.gethMar() + GameView.getCol(GameView.getPlayer()) * GameView.getCellSize();
            float playerCenterY = GameView.gethMar() + GameView.getRow(GameView.getPlayer()) * GameView.getCellSize();
            float dx = Math.abs(playerCenterX - ghostCenterX);
            float dy = Math.abs(playerCenterY - ghostCenterY);
            if (dx > dy) {
                if ( GameView.getCol(GameView.getClyde()) > GameView.getCol(GameView.getPlayer())) {
                    GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) - 1);
                } else {
                    GameView.setCol(GameView.getClyde(), GameView.getCol(GameView.getClyde()) + 1);
                }
            } else {
                if ( GameView.getRow(GameView.getClyde()) > GameView.getRow(GameView.getPlayer())) {
                    GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) - 1);
                } else {
                    GameView.setRow(GameView.getClyde(), GameView.getRow(GameView.getClyde()) + 1);
                }
            }
        }

    }
}
