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
        HashSet<Point> available = new HashSet<Point>();

        populate(available);

        Point point = new Point(128,128);

        available.remove(point);
        Color startingPixel = colorList.remove(0);

        assert available.size() == colorList.size();

        int rgbInt = startingPixel.getRGB();
        img.setRGB(point.x,point.y,rgbInt);
        selectNextPoint(point, available);
        
        while(!available.isEmpty())
        {
            int threshold = 100;
            Color best = colorList.get(0);
            int currentRGB = img.getRGB(point.x, point.y);
            for(Color c : colorList) 
            {
                if(Math.abs(currentRGB - c.getRGB()) < threshold)
                {
                    best = c;
                    continue;
                }
            }
            
            available.remove(point);
            colorList.remove(best);

            selectNextPoint(point,available);
            img.setRGB(point.x, point.y, best.getRGB());
            
        }

    }

    static void selectNextPoint(Point p, HashSet<Point> possible)
    {
        int currX = p.x - 1;
        int currY = p.y + 1;
        ArrayList<Point> points = new ArrayList<Point>(9);
        for(int i = 0; i < 3; i++)
        {
            points.add(new Point(currX,currY + i));
            points.add(new Point(currX + 1,currY + i));
            points.add(new Point(currX + 2,currY + i));
        }

        Collections.shuffle(points);

        for(Point x : points)
        {
            if(possible.contains(x)){
                p.x = x.x;
                p.y = x.y;
                return;
            }
        }
        //Select next random point off hashSet is pixels around point are exhausted
        for(Point next : possible)
        {
            p.x = next.x;
            p.y = next.y;
            return;
        }
    }
    static void populate(HashSet<Point> hs)
    {
        for(int i = 0; i < 256; i++)
            for(int j = 0; j<256; j++)
                hs.add(new Point(i,j));
    }
}