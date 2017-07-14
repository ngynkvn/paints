package helpers;

import algorithms.*;

import java.io.*;
import java.awt.image.BufferedImage;

import javax.imageio.*;

public class ImageCreator
{
    private static Algorithm a;
    public ImageCreator(String algo)
    {
        a = new NearestNeighbor();
    }

    public void write(File f, int width, int height)
    {
        
                BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                a.createImage(img);

                try {
                ImageIO.write(img,"png",f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

}