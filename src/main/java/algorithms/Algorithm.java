package algorithms;

import java.awt.image.BufferedImage;

public abstract class Algorithm
{
     public abstract BufferedImage createImg(int w, int h);

     static int rgbInt(int r, int g, int b) //Creates int value by bit shifting rgb values into their appropriate spots.
     {
          return (r<<16) + (g<<8) + (b);
     }
}