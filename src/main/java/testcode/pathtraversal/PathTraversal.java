package testcode.pathtraversal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class PathTraversal {
    static final String safefinalString = "SAFE";
    public static void main(String[] args) throws IOException, URISyntaxException {
        String input = args.length > 0 ? args[0] : "../../../../etc/password\u0000";
        new File(input);
        new File("test/" + input, "misc.jpg");
        new RandomAccessFile(input, "r");
        new File(new URI(args[0]));
        
        new FileReader(input);
        new FileInputStream(input);
        
        new FileWriter(input);
        new FileWriter(input, true);
        new FileOutputStream(input);
        new FileOutputStream(input, true);
        
        // false positive test
        new RandomAccessFile("safe", args[0]);
        new FileWriter("safe".toUpperCase());
        new File(new URI("safe"));

        Files.createTempFile(input,"safe").toFile();
        Files.createTempFile("safe",input).toFile();
        Files.createTempFile(new File("safeDir").toPath(),"safe",input).toFile();
        new File(safefinalString);
    }
}
