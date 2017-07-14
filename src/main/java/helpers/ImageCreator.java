package helpers;

import algorithms.*;

import java.io.*;
import java.awt.image.BufferedImage;

import javax.imageio.*;

/**
 * Responsible for instantiating the correct algorithm based on user input.
 * ImageCreator also holds the logic for creating the BufferedImage and writing it to a png file.
 */
public class ImageCreator
{
    private static Algorithm algorithm;
    public ImageCreator(String algo)
    {
        if(algo.equalsIgnoreCase("lazy") || algo.equalsIgnoreCase("lines")){
            algorithm = new Lazy();
        } else {
            algorithm = new NearestNeighbor();
        }
        System.out.println("Using "+ algorithm.getClass().getSimpleName() +" algorithm");
    }

    /**
     * Creates a buffered image that can be processed by an algorithm. Once finished the method will * attempt to write the image to either the default file out.png or a user-defined output name.
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

}