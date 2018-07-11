import java.util.ArrayList;

public class BinaryToByte {
	private ArrayList<String> binary= new ArrayList();
	
	
	public BinaryToByte(ArrayList<String> binary) {
		super();
		this.binary = binary;
	}
	
	
	public byte[] convertBinaryToByte()
	{
		byte [] bytearray=new byte[binary.size()];
		for(int i=0;i<binary.size();++i)
		{
			String s=binary.get(i);
			int val=Integer.parseInt(s,2);
			bytearray[i]=(byte) val;
			//System.out.println(bytearray[i]);
		}
		return bytearray;
	}

  

}
