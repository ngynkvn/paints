import java.io.*;

public class Paints
{
    public static final int IMAGE_WIDTH = 256;
    public static final int IMAGE_HEIGHT = 128;

    public static void main(String[] args)
    {
        Arguments a = new Arguments(args);

        File outFile = new File(a.getFileOutName());
        
        Algo.write(outFile,a.getAlgo(), IMAGE_WIDTH, IMAGE_HEIGHT);

    }
}