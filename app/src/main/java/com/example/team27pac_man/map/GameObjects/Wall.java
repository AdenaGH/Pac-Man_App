//package com.example.team27pac_man.map.GameObjects;
//
////import android.graphics.Canvas;
////import android.graphics.Rect;
//import com.example.team27pac_man.R;
//import android.content.Context;
//
//
//
//public class Wall extends Tile {
////    private final Sprite sprite;
//    private  static final int SPRITE_SUB = 7;
//    private int randomNumber = (int)((Math.random() * 14 ) + 0); //Random no between 0 to 14
//    private enum WallType{
//        DLEFT_WALL,
//        DT_WALL,
//        HLONG_WALL,
//        HSHORT_WALL,
//        LEFTL_WALL,
//        LT_WALL,
//        RECTANGLE_WALL,
//        RL_WALL,
//        RLEFT_WALL,
//        RT_WALL,
//        SQUARE_WALL,
//        T_WALL,
//        URIGHT_WALL,
//        VLONG_WALL,
//        VSHORT_WALL
//    }
//    public Wall(Context context, Rect mapLocation) {
//        super(mapLocation);
//        this.mapLocation = new Rect((mapLocation.left - SPRITE_SUB), (mapLocation.top - SPRITE_SUB), (mapLocation.right - SPRITE_SUB), (mapLocation.bottom - SPRITE_SUB));
//        int imageId = getWallSprite();
//        sprite = new Sprite(context, imageId, this.mapLocation);
//    }
//
//
//    @Override
//    public void draw(Canvas canvas) {
//        sprite.draw(canvas, this.mapLocation.left, this.mapLocation.top);
//    }
//
//    private int getWallSprite(){
//        switch(WallType.values()[randomNumber]) {
//            case DLEFT_WALL:
//                return R.drawable.dleft_wall;
//            case DT_WALL:
//                return R.drawable.dt_wall;
//            case HLONG_WALL:
//                return R.drawable.hlong_wall;
//            case HSHORT_WALL:
//                return R.drawable.hshort_wall;
//            case LEFTL_WALL:
//                return R.drawable.leftl_wall;
//            case LT_WALL:
//                return R.drawable.lt_wall;
//            case RECTANGLE_WALL:
//                return R.drawable.rectangle_wall;
//            case RL_WALL:
//                return R.drawable.rl_wall;
//            case RLEFT_WALL:
//                return R.drawable.rleft_wall;
//            case RT_WALL:
//                return R.drawable.rt_wall;
//            case SQUARE_WALL:
//                return R.drawable.square_wall;
//            case T_WALL:
//                return R.drawable.t_wall;
//            case URIGHT_WALL:
//                return R.drawable.uright_wall;
//            case VLONG_WALL:
//                return R.drawable.vlong_wall;
//            case VSHORT_WALL:
//                return R.drawable.vshort_wall;
//            default:
//                return R.drawable.no_image;
//        }
//    }
//
//}
