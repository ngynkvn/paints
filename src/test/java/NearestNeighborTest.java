import org.junit.Test;

import algorithms.NearestNeighbor;
import java.awt.Point;
import java.util.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
public class NearestNeighborTest
{
    @Test
    public void testSurroundings()
    {
        ArrayList<Point> li = NearestNeighbor.getSurroundingPoints(new Point(0,0));
        HashSet<Point> a = new HashSet<>();
        a.add(new Point(-1,1));
        a.add(new Point(0,1));
        a.add(new Point(1,1));
        a.add(new Point(1,0));
        a.add(new Point(0,0));
        a.add(new Point(1,-1));
        a.add(new Point(0,-1));
        a.add(new Point(-1,-1));
        a.add(new Point(-1,0));
        for(Point x : li)
        {
            assertTrue(a.contains(x));
        }
    }
}