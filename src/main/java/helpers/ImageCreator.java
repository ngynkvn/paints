package helpers;

import algorithms.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * Responsible for instantiating the correct algorithm based on user input.
 * ImageCreator also holds the logic for creating the BufferedImage and writing it to a png file.
 */
public class ImageCreator
{
    private Algorithm algorithm;
    private Map<String, Algorithm> algorithmMap = createAlgorithmMap();
    public ImageCreator(String algo)
    {
        algorithm = algorithmMap.get(algo);

        System.out.println("Using "+ algorithm.getClass().getSimpleName() +" algorithm");
    }

    /**
     * Creates a buffered image that can be processed by an algorithm. Once finished the method will
     * attempt to write the image to either the default file out.png or a user-defined output name.
     *
     * @param f The file to write to
     * @param width Width of image to write to
     * @param height Height of the image to write to
     */
    public void write(File f, int width, int height)
    {

                BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

                algorithm.createImage(img);

                try {
                ImageIO.write(img,"png",f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    static Map<String, Algorithm> createAlgorithmMap() //there is a better solution to this.
    {
        Algorithm lazy = new Lazy();
        Algorithm nearest = new NearestNeighbor();

        Map<String, Algorithm> hs = new HashMap<>();

        hs.put("lazy", lazy);
        hs.put("lines",lazy);
        hs.put("nearest",nearest);
        hs.put("default",nearest);

        return hs;
    }
    public void setAlgo(Algorithm algo)
    {
        this.algorithm = algo;
    }
}