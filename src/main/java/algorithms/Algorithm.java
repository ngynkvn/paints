package algorithms;

import java.awt.image.BufferedImage;
import java.awt.*;

public abstract class Algorithm {
    public abstract void createImage(BufferedImage i);

    public static int rgbInt(int r, int g, int b) //Creates int value by bit shifting rgb values into their appropriate spots.
    {
        return (r << 16) + (g << 8) + (b);
    }

    public static int rgbInt(Color c) {
        return rgbInt(c.getRed(), c.getGreen(), c.getBlue());
    }

    public static Color[] createColorArray() {
        Color[] arr = new Color[32 * 64 * 32];
        int arr_i = 0;
        for (int r = 0; r < 32; r++)
            for (int g = 0; g < 64; g++)
                for (int b = 0; b < 32; b++) {
                    arr[arr_i++] = new Color(r * 8, g * 4, b * 8);
                }
        return arr;
    }
}