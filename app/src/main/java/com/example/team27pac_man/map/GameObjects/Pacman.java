//package com.example.team27pac_man.map.GameObjects;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//
//import com.example.team27pac_man.R;
//
//public class Pacman extends Tile {
//    private final Sprite sprite;
//    private static final int SPRITE_SUB = 7;
//    public Pacman(Context context, Rect mapLocation) {
//        super(mapLocation);
//        this.mapLocation = new Rect((mapLocation.left - SPRITE_SUB), (mapLocation.top - SPRITE_SUB), (mapLocation.right - SPRITE_SUB), (mapLocation.bottom - SPRITE_SUB));
//        int imageId = R.drawable.aware_pacman;// HOW TO CHOOSE THE PACMAN SELECTED BY THE USER??
//        sprite = new Sprite(context, imageId, this.mapLocation);
//    }
//
//    public void draw(Canvas canvas) {
//        sprite.draw(canvas, this.mapLocation.left, this.mapLocation.top);
//    }
//}
