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
        a = new DefaultAlgo();
    }

    public void write(File f, int width, int height)
    {
                BufferedImage img = a.createImg(width,height);

                try {
                ImageIO.write(img,"png",f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

}