//package com.example.team27pac_man.map.GameObjects;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//
//import com.example.team27pac_man.R;
//
//public class Ghost extends Tile {
//    private final Sprite sprite;
//    public int ghostIndex = 0;
//
//    public Ghost(Context context, Rect mapLocation) {
//        super(mapLocation);
//        int imageId = getGhostSprite();
//        sprite = new Sprite(context, imageId, this.mapLocation);
//    }
//
//    private enum GhostType {
//        BLUE,
//        GREEN,
//        PINK,
//        YELLOW
//    }
//
//    private int getGhostSprite() {
//        switch (GhostType.values()[ghostIndex]) {
//            case BLUE:
//                return R.drawable.blue;
//            case GREEN:
//                return R.drawable.green;
//            case PINK:
//                return R.drawable.pink_modified;
//            case YELLOW:
//                return R.drawable.yellow;
//            default:
//                return R.drawable.no_image;
//        }
//    }
//    public void draw(Canvas canvas) {
//
//        sprite.draw(canvas, this.mapLocation.left, this.mapLocation.top);
//    }
//}
