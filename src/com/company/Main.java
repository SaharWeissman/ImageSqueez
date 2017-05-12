package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random sRandy;

    public static void main(String[] args) {
	    System.out.println("Welcome to Image squeeze!\n");
        Scanner scanner = new Scanner(System.in);
        String widthStr, heightStr = null;
        int width = 0, height = 0;
        boolean inputCorrect = false;
        loopA:while(!inputCorrect) {
            System.out.println("please enter img width & height (<pos_int_width> <pos_int_height>): ");
            loopB:while (((widthStr = scanner.next()) != null && !widthStr.isEmpty()) &&
                    ((heightStr = scanner.next()) != null && !heightStr.isEmpty())) {
                try {
                    width = Integer.valueOf(widthStr);
                    height = Integer.valueOf(heightStr);
                    if(width > 0 && height > 0) {
                        inputCorrect = true;
                        break loopA;
                    }
                }catch (NumberFormatException e){
                    break loopB;
                }
                System.err.println("\nInput is incorrect! must be an integer! please try again...");
            }
        }

        System.out.println("\nImage dimensions entered are: width = " + width +", height = " + height);

        // generate random img data
        List<Color> colors = new ArrayList<>();
        colors.add(new Color(240,248,255));
        colors.add(new Color(230,230,250));
        colors.add(new Color(176,224,230));
        colors.add(new Color(173,216,230));
        colors.add(new Color(135,206,250));
        colors.add(new Color(135,206,235));
        colors.add(new Color(0,191,255));
        colors.add(new Color(176,196,222));
        colors.add(new Color(30,144,255));
        colors.add(new Color(100,149,237));
        colors.add(new Color(70,130,180));
        colors.add(new Color(240,248,255));
        colors.add(new Color(240,248,255));
        colors.add(new Color(95,158,160));
        colors.add(new Color(25,25,112));
        colors.add(new Color(0,0,139));
        colors.add(new Color(65,105,225));
        colors.add(new Color(72,61,139));
        colors.add(new Color(95,158,160));
       int[][] imgData = RandomUtil.getInstance().generateRandomImgData(width, height,colors);

        // create buffered img from random data
        BufferedImage img = ImgDataUtil.getInstance().createBufferedImageLabel(imgData);

        // display img
        JLabel jLabel = new JLabel(new ImageIcon(img));

        JPanel jPanel = new JPanel();
        jPanel.add(jLabel);
        JFrame r = new JFrame("Image");
        r.setSize(1500, 1500);
        r.add(jPanel);
        JButton saveButton = new JButton("Save to file");
        jPanel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileLocation = "C:\\Users\\Sahar\\Desktop\\" + System.currentTimeMillis() + ".isqz";
                File imgFile = FileUtils.getInstance().createFileFromImgData(imgData, fileLocation);
                if(imgFile != null){
                    imgFile.setReadable(true);
                    System.out.println("\nFile Saved Successfully to: " + fileLocation);
                    System.exit(0);
                }else{
                    System.err.println("\nUnable to save file (null)!");
                    System.exit(2);
                }
            }
        });
        r.setVisible(true);
    }
}
