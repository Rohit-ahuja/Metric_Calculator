import java.io.*;
import java.util.*;
public class Analyser {

	public static void main(String[] args) throws IOException{
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
		Parser p = new Parser();
	    while(st.hasMoreTokens()){
	    	String str1 = st.nextToken();
	    	if(str1.charAt(0) != '#'){
	    		p.parse(str1);
	    	}
	    	//System.out.print(st.nextToken());
	    	//st.nextToken();
	    }
	    //p.parse("int a=10;");
	}

}

