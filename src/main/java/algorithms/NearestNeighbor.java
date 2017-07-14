package algorithms;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.*;

public class NearestNeighbor extends Algorithm
{
    public void createImage(BufferedImage img)
    {
        Color [] _arr = createColorArray();
        ArrayList<Color> colorList = new ArrayList<>(Arrays.asList(_arr)); //convert to arraylist
        int x = 128;
        int y = 128;
        Color startingPixel = colorList.remove(0);
        int rgbInt = startingPixel.getRGB();
        img.setRGB(x,y,rgbInt);

        while(!colorList.isEmpty())
        {
            
        }

    }
}