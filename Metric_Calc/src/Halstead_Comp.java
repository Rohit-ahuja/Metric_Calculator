import java.io.FileReader;
import java.util.StringTokenizer;

public class Halstead_Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		String str = "";
		FileReader fp ;
		try{
			fp = new FileReader("F:/New folder/Metric_Calc/src/abc.txt");
			//fp1 = fp;
			while((ch = fp.read()) != -1){
				str += (char)ch;
			}
			
		}catch(Exception e){
			System.out.print("Error");
		}
		StringTokenizer st = new StringTokenizer(str,"\n");
		ParserH p = new ParserH();
	    while(st.hasMoreTokens()){
	    	String str1 = st.nextToken().trim()+";";
	    	if(str1.charAt(0) != '#' && str1.charAt(0) !='/'){
	    		  p.parse(str1);
	    	}
	    }
	    System.out.println("n1 = "+p.n1);
	    System.out.println("N1 = "+p.N1);
	    System.out.println("n2 = "+p.n2);
	    System.out.println("N2 = "+p.N2);
	}

}
