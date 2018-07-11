import java.util.ArrayList;
import java.util.HashMap;

public class Demodulation {

	private String file;
	private HashMap<Character ,String> nt1=new HashMap<>(); 
	private HashMap<String,String> nt2=new HashMap<>(); //Mapping of 2 bits to 2 nucleotide
	
	
	
	public Demodulation(String file) {
		super();
		this.file = file;
		this.initialiseHashMap();
	}

	public void initialiseHashMap()
	{
		nt1.put('A', "00");
		nt1.put('C', "01");
		nt1.put('G', "10");
		nt1.put('T', "11");
		
		nt2.put("AA", "00");
		nt2.put("AC", "01");
		nt2.put("AG", "10");
		nt2.put("AT", "11");

		nt2.put("CC", "00");
		nt2.put("CG", "01");
		nt2.put("CT", "10");
		nt2.put("CA", "11");

		nt2.put("GG", "00");
		nt2.put("GT", "01");
		nt2.put("GA", "10");
		nt2.put("GC", "11");
		
		nt2.put("TT", "00");
		nt2.put("TA", "01");
		nt2.put("TC", "10");
		nt2.put("TF", "11");



	}

	public ArrayList<String> demodulate()
	{
		ArrayList <String> toBinary=new ArrayList();
		System.out.println("demod");
		for(int i=0;i<file.length();i+=10)
		{
			
			String temp="";
			String binary="";
			for(int j=i;j<i+10;++j)
				temp+=file.charAt(j);
			binary+=nt1.get(temp.charAt(0));
			binary+=nt1.get(temp.charAt(1));
			binary+=nt1.get(temp.charAt(3));
			String a="";
			a+=temp.charAt(2);
			a+=temp.charAt(4);
			binary+=nt2.get(a);
			toBinary.add(binary);
			//System.out.println(binary);
			
		}
		return toBinary;
		
	}
	
}
