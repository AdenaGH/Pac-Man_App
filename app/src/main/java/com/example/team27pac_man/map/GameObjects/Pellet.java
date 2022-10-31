//package com.example.team27pac_man.map.GameObjects;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//
//import com.example.team27pac_man.R;
//
//public class Pellet extends Tile {
//    private final Sprite sprite;
//    private static final int PELLET_SUB = 21;
//    public Pellet(Context context, Rect mapLocation) {
//        super(mapLocation);
//        this.mapLocation = new Rect((mapLocation.left - PELLET_SUB), (mapLocation.top - PELLET_SUB), (mapLocation.right - PELLET_SUB), (mapLocation.bottom - PELLET_SUB));
//        int imageId = R.drawable.pellet;
//        sprite = new Sprite(context, imageId, this.mapLocation);
//    }
//    public void draw(Canvas canvas) {
//        sprite.draw(canvas, this.mapLocation.left, this.mapLocation.top);
//    }
//}
