import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ErrorDetection {
    ArrayList< char[]> ClusterA=new ArrayList();
    ArrayList< char[]> ClusterB=new ArrayList();
    String file;
    
	public ErrorDetection(ArrayList<char[]> clusterA, ArrayList<char[]> clusterB,String file) 
	{
		super();
		ClusterA = clusterA;
		ClusterB = clusterB;
		this.file=file;
	}
	
	 static int min(int x,int y,int z)
	    {
	        if (x <= y && x <= z) return x;
	        if (y <= x && y <= z) return y;
	        else return z;
	    }
	
	public void errorCorrection() throws InterruptedException, IOException
	{
		// This will reference one line at a time
        String line = null;
        String temp="";
        //RandomAccessFile aFile = new RandomAccessFile  (file, "r");
        RandomAccessFile reader = new RandomAccessFile(file,"r");
		int r=0;
		int cnt=0;
		int totalCorrections=0;
		while(true)
		{
			String c="";
			for(int i=0;i<=9&&(r=reader.read())!=-1;++i)
			{
				c+=(char)r;
				
			}
	
			if(r==-1) break;
			String original=(ClusterA.get(cnt).toString()+ClusterB.get(cnt).toString());
			totalCorrections+=this.editDistance(c,original , c.length(), original.length());
		}
		this.correctFile();
     
		
    }
	
	public int editDistance(String toBeCorrected,String original,int m,int n)
	{

	    
		// Create a table to store results of subproblems
	    int dp[][]=new int[m+1][n+1];
	 
	    // Fill d[][] in bottom up manner
	    for (int i=0; i<=m; i++)
	    {
	        for (int j=0; j<=n; j++)
	        {
	            // If first string is empty, only option is to
	            // isnert all characters of second string
	            if (i==0)
	                dp[i][j] = j;  // Min. operations = j
	 
	            // If second string is empty, only option is to
	            // remove all characters of second string
	            else if (j==0)
	                dp[i][j] = i; // Min. operations = i
	 
	            // If last characters are same, ignore last char
	            // and recur for remaining string
	            //else if(toBeCorrected.get)
	            else if (toBeCorrected.charAt(i-1)==original.charAt(j-1))
	                dp[i][j] = dp[i-1][j-1];
	 
	            // If last character are different, consider all
	            // possibilities and find minimum
	            else
	                dp[i][j] = 1 + min(dp[i][j-1],  // Insert
	                                   dp[i-1][j],  // Remove
	                                   dp[i-1][j-1]); // Replace
	        }
	    }
	 
	    return dp[m][n];
	}
		
	
	/*
	public int checkInsertionOrDeletionError(String file)
	{
		//System.out.println(2*5*ClusterA.size()+ "csize");
		return (file.length()-(10*ClusterA.size()));	
	}
	public int[] detectInsertionError(String file,int count)
	{
		int position[]=new int[count];
		String original="";
		/*  COMPUTE ORIGINAL ERROR-FREE SEQUENCE   */
		/*for(int i=0;i<ClusterA.size();++i)
		{
			String a =new String(ClusterA.get(i));
			String b =new String(ClusterB.get(i));
			original+=a+b;
		}
		int posindex=0;
		for(int i=0,j=0;i<original.length();++j)
		{
			if(original.charAt(i)!=file.charAt(j))
			{
				position[posindex]=i;
				++posindex;
			}
			else
			{
				++i;
			}
		}
		return position;
	}

	/*
	 * 
	 * Rectify this
	 */
	/*public int[] detectDeletionError(String file,int count)
	{
		int position[]=new int[count];
		String original="";
		/*  COMPUTE ORIGINAL ERROR-FREE SEQUENCE   */
		/*for(int i=0;i<ClusterA.size();++i)
		{
			String a =new String(ClusterA.get(i));
			String b =new String(ClusterB.get(i));
			original+=a+b;
		}
		int posindex=0;
		for(int i=0,j=0;i<original.length();++j)
		{
			if(original.charAt(i)!=file.charAt(j))
			{
				position[posindex]=i;
				++posindex;
			}
			else
			{
				++i;
			}
		}
		return position;
	}*/
public void correctFile() throws IOException
{
	FileWriter fw=new FileWriter(file);    
	for(int i=0;i<ClusterA.size();++i)
	{
		String s=new String(ClusterA.get(i))+new String(ClusterB.get(i));
		
		fw.write(s);
	}
	fw.close();
    //fw.write("Welcome to javaTpoint.");    
}
}


