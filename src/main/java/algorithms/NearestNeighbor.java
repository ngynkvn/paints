package algorithms;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 *
 */
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

        int no_good = 0;
        int good = 0;

        int rgbInt = startingPixel.getRGB();
        img.setRGB(point.x,point.y,rgbInt);
        selectNextPoint(point, available);
        
        while(!available.isEmpty())
        {
            int threshold = 10;
            Color best = colorList.get(0);
            int currentRGB = img.getRGB(point.x, point.y);
            for(Color c : colorList) 
            {
                if(distBetween(currentRGB, c.getRGB()) < threshold)
                {
                    best = c;
                    continue;
                }
            }
            //debug
            if(best.equals(colorList.get(0)))
                no_good++;
            else
                good++;

            available.remove(point);
            colorList.remove(best);

            selectNextPoint(point,available);
            img.setRGB(point.x, point.y, best.getRGB());
            
        }
        System.out.println("Good pixels:"+good + " Bad:" + no_good);
    }

    static void selectNextPoint(Point p, HashSet<Point> possible)
    {
        ArrayList<Point> points = getSurroundingPoints(p);

        Collections.shuffle(points);

        for(Point x : points)
        {
            if(possible.contains(x)){
                p.x = x.x;
                p.y = x.y;
                return;
            }
        }
        //Select next random point off hashSet if pixels around point are exhausted
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

    static double distBetween(int a, int b) // Euclidean color distance, see : https://en.wikipedia.org/wiki/Color_difference
    {
        int rD = (a >> 16) - (b >> 16);
        int gD = (a >> 8 & 255) - (b >> 8 & 255); //extract color values from RGB int
        int bD = (a & 255) - (b & 255);

        return Math.sqrt(Math.pow(rD,2) + Math.pow(gD,2) + Math.pow(bD,2));
    }

    static ArrayList<Point> getSurroundingPoints(Point p)
    {
        int currX = p.x - 1;
        int currY = p.y + 1;
        ArrayList<Point> arr = new ArrayList<Point>(9);
        for(int i = 0; i < 3; i++)
        {
            arr.add(new Point(currX,currY + i));
            arr.add(new Point(currX + 1,currY + i));
            arr.add(new Point(currX + 2,currY + i));
        }
        return arr;
    }
}