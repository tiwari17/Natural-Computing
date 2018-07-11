import java.util.ArrayList;

public class ByteToBinary {
	
	
	public ArrayList<int [] > convertByteToBinary(byte [] bFile)
	{
		System.out.println("in bytetobinary");
		ArrayList<int []> binary = new ArrayList();
		for (int i = 0; i < bFile.length; i++) 
		{
			
				String s=Integer.toBinaryString( bFile[i] & 0xFF);
			
	           if(s.length()<8)
	           {
	        	   String a="";
	        	   for(int j=0;j<8-s.length();++j)
	        		   a+="0";
	        	   s=a+s;
	           }
	           int [] arr = new int [8];
	           
	           for(int k=0;k<8;++k)
	           {
	        	   if(s.charAt(k)=='0')
	        	   {
	        		   arr[k]=0;
	        	   }
	        	   else
	        	   {
	        		   arr[k]=1;
	        	   }
	           }
	           binary.add(arr);
	          //System.out.println( bFile[i]);
        }  
		return binary;
		
	}

}
