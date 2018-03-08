package helpers;

/**
 * Handles the command line arguments that are passed to the program, for now it only holds
 * a user-defined file output name and algorithm to use.
 * 
 * @author Kevin Nguyen
 */
public class Arguments {
    private final String fileOutName;
    private final String algo;

    public Arguments(String[] args) {
        if (args.length == 0) {
            fileOutName = "out.png";
            algo = "default";
        } else if (args.length == 1) {
            fileOutName = ensurePngExtension(args[0]);
            algo = "default";
        } else {
            fileOutName = ensurePngExtension(args[0]);
            algo = args[1];
        }
    }

    static String ensurePngExtension(String fileName) {
        if (fileName.toLowerCase().endsWith(".png")) {
            return fileName;
        } else {
            return fileName.concat(".png");
        }
    }

    public String getFileOutName() {
        return fileOutName;
    }

    public String getAlgo() {
        return algo;
    }
}