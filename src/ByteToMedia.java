import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteToMedia {
	
	public void convertByteToMedia(byte bFile[],String destination) throws IOException
	{
		 Path path = Paths.get(destination);
		// Path path=Paths.get(destination);
         Files.write(path, bFile);
         System.out.println("Done");
        
	}

}
