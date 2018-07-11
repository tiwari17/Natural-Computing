import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class RandomErrors {

	String file;

	public RandomErrors(String file) {
		super();
		this.file = file;
	}
	
	public void generateRandomChannelErrors() throws IOException
	{
		Random random=new Random();
		char[] alphabetSet= {'A','T','G','C'};
		int index=random.nextInt(4);
		int numberOfError=random.nextInt(1000);
		int insertionError=random.nextInt(numberOfError);
		int deletionError=random.nextInt(numberOfError-insertionError);
		int substitutionError=numberOfError-insertionError-deletionError;
		
		
		RandomAccessFile aFile = new RandomAccessFile("/Users/sureshkumarmalhotra/Documents/ACAD/SEM 6/Natural Computing/Project/testimage.txt", "rw");
		//RandomAccessFile bFile = new RandomAccessFile("/Users/sureshkumarmalhotra/Documents/ACAD/SEM 6/Natural Computing/Project/testimage.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
       // FileChannel outChannel= bFile.getChannel();
       // ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("numof errors "+numberOfError);
        int length=(int) aFile.length();
        for(int i=0;i<numberOfError;++i)
        {
        	int pos=random.nextInt(length);
 
        	aFile.seek(pos);
        	aFile.write(alphabetSet[index]);
        	index=random.nextInt(4);
        }
        
   
        inChannel.close();
        aFile.close();
       //buffer.put
		
	}
	
}