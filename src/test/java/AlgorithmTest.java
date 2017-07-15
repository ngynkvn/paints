import org.junit.Test;

import algorithms.*;
import java.awt.*;
import java.util.*;

import static org.junit.Assert.*;

public class AlgorithmTest
{
	@Test
	public void testAllUniquePixels()
	{
		Color[] arr = Algorithm.createColorArray();
		HashSet<Color> a = new HashSet<>();

		for(Color c : arr)
		{
			assertFalse("Found a duplicate color.",a.contains(c));
			a.add(c);
		}
	}
	@Test
	public void testAllUniquePixelsByRGBInt()
	{
		Color[] arr = Algorithm.createColorArray();
		HashSet<Integer> b = new HashSet<>();

		for(Color c : arr)
		{
			assertFalse("Found a duplicate color.",b.contains( Algorithm.rgbInt(c) ) );
			b.add(Algorithm.rgbInt(c));
		}
	}
}