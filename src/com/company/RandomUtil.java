package com.company;

import java.awt.Color;

import java.util.List;
import java.util.Random;

/**
 * Created by Sahar on 05/12/2017.
 */
public class RandomUtil {
    private Random mRandy;

    private static volatile RandomUtil sInstance = null;

    private RandomUtil(){
        mRandy = new Random();
    }

    public static RandomUtil getInstance(){
        if(sInstance == null){
            synchronized (RandomUtil.class){
                if(sInstance == null){
                    sInstance = new RandomUtil();
                }
            }
        }
        return sInstance;
    }

    public int[][] generateRandomImgData(int width, int height, List<Color> colorsPalate){
        int[][] data = new int[width][height];
        for(int w = 0; w < width; w++){
            for(int h = 0; h < height; h++){
                data[w][h] =  colorsPalate.get(mRandy.nextInt(colorsPalate.size())).getRGB();
            }
        }
        return data;
    }
}
