//package com.example.team27pac_man.map.GameObjects;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//
//import com.example.team27pac_man.R;
//
//public class PowerPellet extends Tile {
//    private final Sprite sprite;
//    private static final int POWER_PELLET_SUB = 17;
//    public PowerPellet(Context context, Rect mapLocation) {
//        super(mapLocation);
//        this.mapLocation = new Rect((mapLocation.left - POWER_PELLET_SUB), (mapLocation.top - POWER_PELLET_SUB), (mapLocation.right - POWER_PELLET_SUB), (mapLocation.bottom - POWER_PELLET_SUB));
//        int imageId = R.drawable.power_pellet;
//        sprite= new Sprite(context, imageId, this.mapLocation);
//    }
//    public void draw(Canvas canvas) {
//        sprite.draw(canvas, this.mapLocation.left, this.mapLocation.top);
//    }
//}
