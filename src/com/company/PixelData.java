package com.company;

/**
 * Created by Sahar on 05/12/2017.
 */
public class PixelData {
    private final int rgb;

    public PixelData(int rgb){
        this.rgb = rgb;
    }

    public int getRgb() {
        return rgb;
    }

    public static class PixelCoordinate {
        private final short x;
        private final short y;

        public PixelCoordinate(short x, short y){
            this.x = x;
            this.y = y;
        }
    }
}
