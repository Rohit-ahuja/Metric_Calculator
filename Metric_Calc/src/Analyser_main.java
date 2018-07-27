import java.io.BufferedReader;
import java.io.FileReader;

public class Analyser_main {
	public static void main(String[] args) {
		FileReader fp ;
		Enhanced_halstead p=new Enhanced_halstead();
		ParserC c = new ParserC();
		int cc = 0;
				try{
			         fp = new FileReader("E:\\major project\\Metric_Calculator-master\\Metric_Calc\\Metric_cal\\src\\abc.txt");
		             BufferedReader br=new BufferedReader(fp);
			         String s;
			
			         while((s=br.readLine())!=null)
			         {   
			        	 s=s.concat(";");
				         p.parse(s);
			         	 cc = cc+c.parse(s);
				     }
			     br.close();
			       }
				catch(Exception e){
			            System.out.print(e);
		                          }
				
				System.out.println("========================CYCLOMETRIC COMPLEXITY======================");
				System.out.println("CC: " + cc);
				System.out.println("\n========================HALSTEAD COMPLEXITY=========================");
				int N = p.N1 + p.N2;
				int n = p.n1 + p.n2;
				System.out.println("N: "+ N+"\nn: "+n);
				double V = N * Math.log(n);
				double D = ((p.n1/2) * (p.N2/p.n2));
				System.out.println("E: "+ (V*D));
				int Na;
				double Va,Ea;
				Na = p.N1+p.N2+p.countop+p.countor;
				Va = Na*(Math.log(p.n1+p.n2));
				Ea = Va*((p.n1*p.N2)/(2*p.n2));
				System.out.println("\n========================ENHANCED HALSTEAD===========================");
				System.out.println("Na:"+Na+"\nEa:"+Ea);
				 }
	   
}
