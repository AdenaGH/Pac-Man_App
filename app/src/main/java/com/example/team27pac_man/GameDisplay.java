//package com.example.team27pac_man;
//import android.graphics.Rect;
//
//public class GameDisplay {
//
//    public final Rect DISPLAY_RECTANGLE;
//    private final int widthPx, heightPx;
//    private final double centerX, centerY;
//
//
//    public GameDisplay(int widthPx, int heightPx) {
//        this.widthPx = widthPx;
//        this.heightPx = heightPx;
//        DISPLAY_RECTANGLE = new Rect(0,0, widthPx, heightPx);
//        centerX = widthPx/2.0;
//        centerY = heightPx/2.0;
//    }
//    public Rect getGameRect(){
//        return new Rect((int)(centerX - widthPx/2), (int)(centerY - heightPx/2), (int)(centerX + widthPx/2), (int) centerY + heightPx/2);
//    }
//}
