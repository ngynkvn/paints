/*
 *  Implementation of a 16-bit RGB pixel.
 *
 */
public class Pixel
{
    private int r;
    private int g;
    private int b;
    Pixel(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int r()
    {
        return r;
    }
    public int g()
    {
        return g;
    }
    public int b()
    {
        return b;
    }

    public static Pixel[] createPixelArray()
    {
        Pixel[] arr = new Pixel[32*64*32];
        int arr_i = 0;
        for(int r = 0 ; r < 32; r++)
            for(int g = 0 ; g < 64; g++)
                for(int b = 0 ; b < 32; b++){
                    arr[arr_i++] = new Pixel(r,g,b);
                }
        return arr;
    }

    public String toString()
    {
        return "R: "+ r + " G: " + g + " B: "+b;
    }
}