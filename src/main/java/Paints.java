import java.io.*;
import helpers.*;

/**
 * Main file.
 */
public class Paints
{
    public static final int IMAGE_WIDTH = 256;
    public static final int IMAGE_HEIGHT = 256;

    public static void main(String[] args)
    {
        Arguments a = new Arguments(args);

        File outFile = new File(a.getFileOutName());

        ImageCreator img = new ImageCreator(a.getAlgo());

        img.write(outFile, IMAGE_WIDTH, IMAGE_HEIGHT);
    }
}