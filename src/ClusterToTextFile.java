import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ClusterToTextFile {

	 ArrayList< char[]> ClusterA=new ArrayList();
     ArrayList< char[]> ClusterB=new ArrayList();
     
     
	public ClusterToTextFile(ArrayList<char[]> clusterA, ArrayList<char[]> clusterB) 
	{
		super();
		ClusterA = clusterA;
		ClusterB = clusterB;
	}
	
	public void writeToTextfile()  throws IOException 
	{
				
			    RandomAccessFile writer = new RandomAccessFile("/Users/sureshkumarmalhotra/Documents/ACAD/SEM 6/Natural Computing/Project/testimage.txt", "rw");
			    //writer.writeChars("ORIGINAL FILE \n");
			    for(int i=0;i<this.ClusterA.size();++i)
			    {
			    	String a= new String(this.ClusterA.get(i));
			    	String b= new String(this.ClusterB.get(i));
			    	writer.writeBytes(a+b);
			    	//writer.writeBytes(" ");
			    }
			    //writer.seek(position);
			    //writer.writeInt(data);
			    writer.close();
	}

     
     
		
	
}
