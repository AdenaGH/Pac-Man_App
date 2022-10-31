//package com.example.team27pac_man.map.GameObjects;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//
//import com.example.team27pac_man.R;
//
//public class GhostBox extends Tile {
//    private final Sprite sprite;
//    private static final int GHOST_BOX = 4;
//    public GhostBox(Context context, Rect mapLocation) {
//        super(mapLocation);
//        this.mapLocation = new Rect((mapLocation.left * GHOST_BOX), (mapLocation.top * GHOST_BOX), (mapLocation.right * GHOST_BOX), (mapLocation.bottom * GHOST_BOX));
//        int imageId = R.drawable.ghostbox;
//        sprite = new Sprite(context, imageId, this.mapLocation);
//    }
//    public void draw(Canvas canvas) {
//        sprite.draw(canvas, this.mapLocation.left, this.mapLocation.top);
//    }
//}
