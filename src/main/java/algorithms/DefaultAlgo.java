package algorithms;

import java.awt.image.BufferedImage;
import java.awt.*;

public class DefaultAlgo extends Algorithm
{
    public void createImage(BufferedImage img)
    {

        Color[] pixelArray = createColorArray();

        for(int i = 0; i < 32*64*32; i++)
        {
            int x = i & 255;
            int y = i / 256;
            Color pix = pixelArray[i];
            int r = pix.getRed() * 8; //16-23
            int g = pix.getGreen() * 4; //8-15
            int b = pix.getBlue() * 8; //0-7

            int rgb = rgbInt(r,g,b);

            img.setRGB(x, y, rgb);
        }
    }
}