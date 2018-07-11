import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		ByteToBinary bytetobinary=new ByteToBinary();
        ArrayList <int []> binaryEncoding=new ArrayList();
        MediaToByte obj=new MediaToByte();
        ArrayList< char[]> ClusterA=new ArrayList();
        ArrayList< char[]> ClusterB=new ArrayList();
        ArrayList< String > binary=new ArrayList();
        
		// convert file to byte[]
        byte[] bFile = obj.readBytesFromFile(args[0]);

		//java nio
		//byte[] bFile = Files.readAllBytes(new File("/Users/sureshkumarmalhotra/Documents/ACAD/SEM// 6/Natural// Computing/Project/image1").toPath());
		//byte[] bFile = Files.readAllBytes(Paths.get("C:\\temp\\testing1.txt"));

		// save byte[] into a file
		/*Path path = Paths.get("/Users/sureshkumarmalhotra/Documents/ACAD/SEM 6/Natural Computing/Project/test11.txt");
		Files.write(path, bFile);
		System.out.println("Done");*/
        
        
        
		//Print bytes[]
        
		/*for (int i = 0; i < bFile.length; i++) {
			
		    System.out.println( bFile[i]);
		}*/
		binaryEncoding=bytetobinary.convertByteToBinary(bFile);
		/*for(int i=0;i<binaryEncoding.size();++i)
		{
			int arr[]=(binaryEncoding.get(i));
			for(int k=0;k<8;++k)
			System.out.print(arr[k]);
			System.out.println();
		}*/

    
		
		
		Modulation m= new Modulation();
		  for(int i=0;i<binaryEncoding.size();++i)
          {
          	int arr[]=(binaryEncoding.get(i));
          		char DNASymbols[][]=m.map6Bit(arr);
          		//int l=DNASymbols.length;
   
        		/*for(int i1=0;i1<l;++i1)
        			{
        				for(int j=0;j<5;++j)
        					System.out.print(DNASymbols[i1][j]);
        				System.out.println();

        			}*/
        		ClusterA.add(DNASymbols[0]);
        		ClusterB.add(DNASymbols[1]);
        		
        		
          }
		  ClusterToTextFile clusterToTextFile =new ClusterToTextFile(ClusterA,ClusterB);
		  /*
		   * 
		   * PRINTING CLUSTER A AND CLUSTER B
		  for(int i=0;i<ClusterA.size();++i)
		  {
			  String a =new String(ClusterA.get(i));
			  String b =new String(ClusterB.get(i));
			  
			  System.out.println("A  "+a +"  B  "+b);
		  }*/
		  
		  
		  
		  /*
		   * 
		   * 
		   * CLUSTERS to DNA file
		   */  
		  clusterToTextFile.writeToTextfile();
			System.out.println("done writing original clusters");
			RandomAccessFile reader = new RandomAccessFile("/Users/sureshkumarmalhotra/Documents/ACAD/SEM 6/Natural Computing/Project/testimage.txt","r");
			String c =reader.readLine();
			
			System.out.println("cc "+c+ "  "+c.length());
			  ErrorDetection errordetection=new ErrorDetection(ClusterA,ClusterB);
			  System.out.println("Opening error correction");
			 // errordetection.errorCorrection("/Users/sureshkumarmalhotra/Documents/ACAD/SEM 6/Natural Computing/Project/testaa.txt");
			 /* int errorType=errordetection.checkInsertionOrDeletionError(c);
			  if(errorType==0)
			  {
				  System.out.println("NO Error detected");
			  }
			  else if(errorType>0)
			  {
				  System.out.println(errorType + "Insertion errors");
				  int position[]=errordetection.detectInsertionError(c, errorType);
				  for(int i=0;i<position.length;++i)
				  {
					  System.out.print(position[i]);
				  }
			  }
			  else
			  {
				  System.out.println(-errorType + "Deletion errors");
			  }
			  */
			  //RandomErrors randomErrors=new RandomErrors("/Users/sureshkumarmalhotra/Documents/ACAD/SEM 6/Natural Computing/Project/testaabbc.txt");
			 // randomErrors.generateRandomChannelErrors();
			  Demodulation d=new Demodulation(c);
			  binary=d.demodulate();
			  BinaryToByte o=new BinaryToByte(binary);
			  byte[] arr=o.convertBinaryToByte();
			  ByteToMedia btm=new ByteToMedia();
			  btm.convertByteToMedia(arr,args[1]);
			  System.out.println(args[0]+" "+args[1]+" ");
			  
			
			
	}	
		
	
	
		

}
