package com.company;

import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

/**
 * Created by Sahar on 05/12/2017.
 */
public class ImgDataUtil {

    private static volatile ImgDataUtil sInstance = null;

    public static ImgDataUtil getInstance(){
        if(sInstance == null){
            synchronized (ImgDataUtil.class){
                if(sInstance == null){
                    sInstance = new ImgDataUtil();
                }
            }
        }
        return sInstance;
    }

    public BufferedImage createBufferedImageLabel(int[][] data){
        int width = data.length;
        int height = data[0].length;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int w = 0; w < width; w++){
            for(int h = 0; h < height; h++){
                img.setRGB(w, h, data[w][h]);
            }
        }
        return img;
    }
}
