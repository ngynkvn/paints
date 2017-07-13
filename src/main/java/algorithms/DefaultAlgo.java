package algorithms;

import java.awt.image.BufferedImage;
import helpers.Pixel;

public class DefaultAlgo extends Algorithm
{
    public BufferedImage createImg(int width, int height)
    {
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Pixel[] pixelArray = Pixel.createPixelArray();

        for(int i = 0; i < 32*64*32; i++)
        {
            int x = i & (width - 1);
            int y = i / (height*2);
            Pixel pix = pixelArray[i];
            int r = pix.r() * 8; //16-23
            int g = pix.g() * 4; //8-15
            int b = pix.g() * 8; //0-7

            int rgb = rgbInt(r,g,b);

            img.setRGB(x, y, rgb);
        }
        return img;
    }
}