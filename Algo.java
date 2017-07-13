import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.*;
public class Algo
{
    public static void write(File f, String a, int width, int height)
    {
                BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                
                Pixel[] pixelArray = Pixel.createPixelArray();

                for(int i = 0; i < 32*32*32; i++)
                {
                int x = i & 255;
                int y = i / 256;
                img.setRGB(x, y, 1);
                }

                try {
                ImageIO.write(img,"png",f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

}