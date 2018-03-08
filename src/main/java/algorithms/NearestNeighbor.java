package algorithms;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.*;

/**
 * I intended for this to be similar to a "nearest neighbor" in terms of selecting colors
 * The algorithm attempts to select colors off the color array that are similar to the current pixel * being viewed. 
 * Color differences are computed using the pythagorean theorem, however apparently
 * this does not match up with human perceptions. Still happy with how the picture turns out.
 */
public class NearestNeighbor extends Algorithm {
    private int THRESHOLD;

    private ArrayList<Pair<Point, Integer>> order;

    {
        this.order = new ArrayList<>();
    }

    public NearestNeighbor(int THRESHOLD) {
        this.THRESHOLD = THRESHOLD;
    }

    public NearestNeighbor() {
        THRESHOLD = 10;
    }

    public void createImage(BufferedImage img) {
        Color[] _arr = createColorArray();
        ArrayList<Color> colorList = new ArrayList<>(Arrays.asList(_arr)); //convert to arraylist
        HashSet<Point> available = new HashSet<Point>();

        populate(available);

        Point point = new Point(128, 128);

        available.remove(point);
        Color startingPixel = colorList.remove(0);

        int rgbInt = startingPixel.getRGB();
        img.setRGB(point.x, point.y, rgbInt);
        selectNextPoint(point, available);

        while (!available.isEmpty()) {
            Color best = colorList.get(0);
            int currentRGB = img.getRGB(point.x, point.y);
            for (Color c : colorList) {
                if (distBetween(currentRGB, c.getRGB()) < THRESHOLD) {
                    best = c;
                    break;
                }
            }
            available.remove(point);
            colorList.remove(best);

            selectNextPoint(point, available);
            order.add(new Pair(new Point(point), best.getRGB()));
            img.setRGB(point.x, point.y, best.getRGB());

        }
    }
    public ArrayList<Pair<Point,Integer>> getOrder()
    {
        return order;
    }
    private static void selectNextPoint(Point p, HashSet<Point> possible) {
        ArrayList<Point> points = getSurroundingPoints(p);

        Collections.shuffle(points);

        for (Point x : points) {
            if (possible.contains(x)) {
                p.x = x.x;
                p.y = x.y;
                return;
            }
        }
        //Select next random point off hashSet if pixels around point are exhausted

        if (possible.size() != 0) {
            Point n = possible.iterator().next();
            p.x = n.x;
            p.y = n.y;
        }
    }

    private static void populate(HashSet<Point> hs) {
        for (int i = 0; i < 256; i++)
            for (int j = 0; j < 256; j++)
                hs.add(new Point(i, j));
    }

    private static double distBetween(int a, int b) // Euclidean color distance, see : https://en.wikipedia.org/wiki/Color_difference
    {
        int rD = (a >> 16) - (b >> 16);
        int gD = (a >> 8 & 255) - (b >> 8 & 255); //extract color values from RGB int
        int bD = (a & 255) - (b & 255);

        return Math.sqrt(Math.pow(rD, 2) + Math.pow(gD, 2) + Math.pow(bD, 2));
    }

    public static ArrayList<Point> getSurroundingPoints(Point p) {
        int currX = p.x;
        int currY = p.y;
        ArrayList<Point> arr = new ArrayList<>(9);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                arr.add(new Point(currX + i, currY + j));
            }
        }
        return arr;
    }
}