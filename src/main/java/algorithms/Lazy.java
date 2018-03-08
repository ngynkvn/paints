package algorithms;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.*;

/* 
 * 
 * Not really an algorithm, implementation here just displays the created color array.
 * Also serves as a demonstration that the algorithm is actually working
 */
public class Lazy  extends Algorithm {
    public void createImage(BufferedImage img) {

        Color[] pixelArray = createColorArray();

        for (int i = 0; i < 32 * 64 * 32; i++) {
            int x = i & 255;
            int y = i / 256;
            Color pix = pixelArray[i];
            // int r = pix.getRed() * 8; //16-23
            // int g = pix.getGreen() * 4; //8-15
            // int b = pix.getBlue() * 8; //0-7

            int rgb = pix.getRGB();

            img.setRGB(x, y, rgb);
        }
    }
    public ArrayList<Pair<Point,Integer>> getOrder()
    {
        return null;
    }
}