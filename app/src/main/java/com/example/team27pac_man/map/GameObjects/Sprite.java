//package com.example.team27pac_man.map.GameObjects;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Rect;
//import android.graphics.Canvas;
//import android.content.Context;
//
//public class Sprite {
//    private static Bitmap bitmap;
//    private static Rect rect;
//    public Sprite(Context context, int imageId, Rect mapLocation){
//        rect = mapLocation;
//        initializeBitmap(context, imageId);
//    }
//
//    private void initializeBitmap(Context context, int imageId) {
//        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//        bitmapOptions.inScaled = false;
//        bitmap = BitmapFactory.decodeResource(context.getResources(), imageId, bitmapOptions);
//    }
//
//    public static void draw(Canvas canvas, int x, int y){
//        canvas.drawBitmap(bitmap, rect, new Rect(x, y, x + getWidth(), y + getHeight()), null );
//    }
//
//    public static int getWidth() {
//        return rect.width();
//    }
//    public static int getHeight(){
//        return rect.height();
//    }
//}
