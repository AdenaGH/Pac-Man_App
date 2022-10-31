package com.example.team27pac_man.map.GameObjects;
//
//import android.graphics.Canvas;
//import android.graphics.Rect;
import android.content.Context;
import android.widget.ImageView;
import com.example.team27pac_man.R;

    public class Tile {
        private int imageId;
        protected ImageView imageView;

        public Tile(Context context, int imageId){
            this.imageId = imageId;
            imageView = new ImageView(context);
            setImageView(imageView);
        }
        //layout key:
//    // 0: random wall
//    // 1: normal pellets
//    // 2: pacman(starting position)
//    // 3: ghosts(starting position)
//    // 4: ghostbox
//    // 5: do nothing(skip the block)
//    // 6: horizontal long wall(for border)
//    // 7: vetical long wall(for border)
//    // 8: power pellets - 5
        private void setImageView(ImageView imageView) {
            if(imageId == 0){
                imageView.setImageResource(R.drawable.dleft_wall); // choose random wall
            } else if (imageId == 1){
                imageView.setImageResource(R.drawable.pellet);
            } else if(imageId == 2){
                imageView.setImageResource(R.drawable.aware_pacman);//get correct pacman!
            } else if(imageId == 3){
                imageView.setImageResource(R.drawable.blue);//choose the right ghost
            } else if(imageId == 4){
                imageView.setImageResource(R.drawable.ghostbox);
            } else if(imageId == 5){
                imageView.setImageResource(R.drawable.empty_image); //change this to transperent pixels
            } else if(imageId == 6){
                imageView.setImageResource(R.drawable.hlong_wall);
            } else if(imageId == 7){
                imageView.setImageResource(R.drawable.vlong_wall);
            } else if(imageId == 8){
                imageView.setImageResource(R.drawable.power_pellet);
            }
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
//
// public class Tile {
//    protected Rect mapLocation;
//    private static Context context;
//    public Tile(Rect mapLocation) {
//        this.mapLocation = mapLocation;
//    }
//
//    public enum TileType{
//        WALL,
//        PELLET,
//        PACMAN,
//        GHOST,
//        GHOST_BOX,
//        EMPTY_TILE,
//        H_LONG_WALL,
//        V_LONG_WALL,
//        POWER_PELLET
//    }
////HOW IS MAPLOCATION SET OR DETERMINED???
//    public static Tile getTile(int tileId, Rect mapLocation){
//        switch(TileType.values()[tileId]) {
//            case WALL:
//                return new Wall(context, mapLocation);// Wall class decided which type to use
//            case PELLET:
//                return new Pellet(context, mapLocation);
//            case PACMAN:
//                return new Pacman(context, mapLocation);
//            case GHOST:
//                return new Ghost(context, mapLocation);
//            case GHOST_BOX:
//                return new GhostBox(context, mapLocation);
//            case EMPTY_TILE:
////                return new EmptyTile(context, mapLocation);
//                return null; //do nothing
//            case H_LONG_WALL:
//                return new HLongWall(context, mapLocation);
//            case V_LONG_WALL:
//                return new VLongWall(context, mapLocation);
//            case POWER_PELLET:
//                return new PowerPellet(context, mapLocation);
//            default:
//                return new EmptyTile(context, mapLocation);
//        }
//    }
//
//    public void draw(Canvas canvas){
//
//    }
//}
