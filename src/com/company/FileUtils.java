package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Sahar on 05/12/2017.
 */
public class FileUtils {

    private static volatile FileUtils sInstance = null;

    public static FileUtils getInstance(){
        if(sInstance == null){
            synchronized (FileUtils.class){
                if(sInstance == null){
                    sInstance = new FileUtils();
                }
            }
        }
        return sInstance;
    }

    // file format is: <width><height><rgb_0,0><rgb_0,1>...<rgb_0,width-1><rgb_1,0>...<rgb_height-1,width-1>
    public File createFileFromImgData(int[][] imgData, String fileLocation){
        File f = null;
        FileWriter fw = null;
        try{
            f = new File(fileLocation);
            f.createNewFile();
            fw = new FileWriter(f);
            int width = imgData.length;
            int height = imgData[0].length;
            fw.write(width);
            fw.write(height);
            for(int w = 0; w < width; w++){
                for(int h = 0; h < height; h++){
                    fw.write(imgData[w][h]);
                }
            }
            fw.flush();
            fw.close();
        }catch (NumberFormatException e){
            System.err.print(e);
        } catch (IOException e) {
            System.err.print(e);
        }finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    System.err.println(e);
                    System.exit(1);
                }
            }
        }
        return f;
    }
}
