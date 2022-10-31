//package com.example.team27pac_man.map;
////Tiles class = tile map
//
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//
//import com.example.team27pac_man.GameDisplay;
//import com.example.team27pac_man.map.GameObjects.Tile;
//
//public class Tiles {
//    public static final int TILE_LENGTH_PXLS = 25;
//    public static final int NUM_ROWS = 20;
//    public static final int NUM_COLS = 16;
//    private MapLayout mapLayout;
//    private Tile[][] layout; //tileMap
////    private Bitmap mapBitMap;
//
//    public Tiles(){
//        mapLayout = new MapLayout();
//        initializeTiles();
//    }
//    private void initializeTiles(){
//        int[][] layoutIds = mapLayout.getLayoutIds();
//        layout = new Tile[NUM_ROWS][NUM_COLS];
//        for(int i = 0; i < layoutIds.length; i++){ //loops through rows
//            for (int j = 0; j < layoutIds[0].length; j++){ //loops through columns
//                layout[i][j] = Tile.getIma(layoutIds[i][j], getRectByIndex(i, j)); // i == row & j == col
//            }
//        }
//        Bitmap.Config config = Bitmap.Config.ARGB_8888;
//        mapBitMap = Bitmap.createBitmap(NUM_COLS * TILE_LENGTH_PXLS, NUM_ROWS * TILE_LENGTH_PXLS, config);
//        Canvas canvasMap = new Canvas(mapBitMap);
//        for(int i = 0; i < layoutIds.length; i++){ //loops through rows
//            for (int j = 0; j < layoutIds[0].length; j++){ //loops through columns
//                layout[i][j].draw(canvasMap);
//            }
//        }
//    }
//
//    private Rect getRectByIndex(int row, int col) {
//        return new Rect(col * TILE_LENGTH_PXLS,row * TILE_LENGTH_PXLS,(col + 1) * TILE_LENGTH_PXLS,(row + 1) * TILE_LENGTH_PXLS );
//    }
//
//    public void draw(Canvas canvas, GameDisplay display){
//        canvas.drawBitmap(mapBitMap, display.getGameRect(), display.DISPLAY_RECTANGLE, null);
//    }
//}
