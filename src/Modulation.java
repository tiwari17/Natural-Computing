import java.util.ArrayList;
import java.util.HashMap;

public class Modulation {
	
	HashMap<Datum, DatumCharPair> nt2=new HashMap<>(); //Mapping of 2 bits to 2 nucleotide
	HashMap<Datum, Character> nt1=new HashMap<>(); //Mapping of 2 bits to 1 nucleotide
	//ArrayList <char [] >errorFreeModulated;
	public char [][] map6Bit(int[] bytes) {
		//System.out.println("in map6BIt");
		Datum d;
		DatumChar d1, d2, d3, d4;
		DatumCharPair dcp;
		char[][] c=new char[4][5];
		
		for(int i=0; i<6; i+=2) {
			
			if(bytes[i]==0 && bytes[i+1]==0) {
				
				d=new Datum(bytes[i], bytes[i+1]);
				
				for(int j=0; j<4; j++)
					c[j][i/2]='A';
				
				nt1.put(d, 'A');
			}
			
			else if(bytes[i]==0 && bytes[i+1]==1) {
				
				d=new Datum(bytes[i], bytes[i+1]);
				
				for(int j=0; j<4; j++)
					c[j][i/2]='C';
				
				nt1.put(d, 'C');
			}
			
			else if(bytes[i]==1 && bytes[i+1]==0) {
				
				d=new Datum(bytes[i], bytes[i+1]);
				
				for(int j=0; j<4; j++)
					c[j][i/2]='G';
				
				nt1.put(d, 'G');
			}
			
			else if(bytes[i]==1 && bytes[i+1]==1) {
				
				d=new Datum(bytes[i], bytes[i+1]);
				
				for(int j=0; j<4; j++)
					c[j][i/2]='T';
				
				nt1.put(d, 'T');
			}
		}
		
		
		d=new Datum(bytes[6], bytes[7]);
		
		if(bytes[6]==0 && bytes[7]==0) {
			d1=new DatumChar('A', 'A');
			d2=new DatumChar('C', 'C');
			d3=new DatumChar('G', 'G');
			d4=new DatumChar('T', 'T');
			
			dcp=new DatumCharPair(d1, d2, d3, d4);
		}
		
		else if(bytes[6]==0 && bytes[7]==1) {
			
			d1=new DatumChar('A', 'C');
			d2=new DatumChar('C', 'G');
			d3=new DatumChar('G', 'T');
			d4=new DatumChar('T', 'A');
			
			dcp=new DatumCharPair(d1, d2, d3, d4);
		}
		
		else if(bytes[6]==1 && bytes[7]==0) {
			
			d1=new DatumChar('A', 'G');
			d2=new DatumChar('C', 'T');
			d3=new DatumChar('G', 'A');
			d4=new DatumChar('T', 'C');
			
			dcp=new DatumCharPair(d1, d2, d3, d4);
		}
		
		else {
			
			d1=new DatumChar('A', 'T');
			d2=new DatumChar('C', 'A');
			d3=new DatumChar('G', 'C');
			d4=new DatumChar('T', 'G');
			
			dcp=new DatumCharPair(d1, d2, d3, d4);
		}
		
		nt2.put(d, dcp);
		
		c[0][3]=d1.a;
		c[0][4]=d1.b;
		
		c[1][3]=d2.a;
		c[1][4]=d2.b;
		
		c[2][3]=d3.a;
		c[2][4]=d3.b;
		
		c[3][3]=d4.a;
		c[3][4]=d4.b;
		
		for(int i=0; i<4; i++) {
			
			char temp=c[i][2];
				c[i][2]=c[i][3];
				c[i][3]=temp;
		}
	    char cc[][]= runLengthLimitation(c);
		return cc;
	}
	
	
	public char [][] runLengthLimitation(char arr[][])

	{
		//char temp [][]=new char[4][];
		int count=0;
		for(int i=0;i<4;++i)
		{
			if(!(arr[i][0]== arr[i][1]&&arr[i][0]==arr[i][2]||arr[i][3]==arr[i][4]))
			{
				++count;
			}
		} 
		char ans[][]=new char [count][];
		int c=0;

		for(int i=0;i<4;++i)
		{
			if(!(arr[i][0]==arr[i][1]&&arr[i][0]==arr[i][2]||arr[i][3]==arr[i][4]))
			{
				ans[c]=arr[i];
				++c;
			}
		}
		return ans;
	}


	


}
