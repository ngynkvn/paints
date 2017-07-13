import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.*;
import algo.*;

public class ImageCreator
{
    private final Algorithm algo;
    ImageCreator(String algo)
    {
        algo = new defaultAlgo();
    }
    public static void write(File f, int width, int height)
    {
                BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                
                // Pixel[] pixelArray = Pixel.createPixelArray();

                // for(int i = 0; i < 32*64*32; i++)
                // {
                // int x = i & 255;
                // int y = i / 256;
                // Pixel pix = pixelArray[i];
                // int r = pix.r() * 8; //16-23
                // int g = pix.g() * 4; //8-15
                // int b = pix.g() * 8; //0-7

                // int rgb = rgbInt(r,g,b);

                // img.setRGB(x, y, rgb);
                // }

                try {
                ImageIO.write(img,"png",f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    private static int rgbInt(int r, int g, int b) //Creates int value by bit shifting rgb values into their appropriate spots.
    { 
        return (r<<16) + (g<<8) + (b);
    }

}