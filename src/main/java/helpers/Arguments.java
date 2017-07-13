package helpers;

public class Arguments
{
    private final String fileOutName;
    private final String algo;

    public Arguments(String [] args)
    {
        if(args.length == 0)
        {
            fileOutName = "out.png";
            algo = "default";
        }
        else if(args.length == 1)
        {
            fileOutName = args[0];
            algo = "default";
        }
        else
        {
            fileOutName = args[0];
            algo = args[1];
        }
    }

    public String getFileOutName()
    {
        return fileOutName;
    }

    public String getAlgo()
    {
        return algo;
    }
}