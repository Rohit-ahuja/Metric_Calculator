import java.awt.BorderLayout;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Analyser_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE FILE NAME: ");
		String s1 = sc.next(),s2,s3,s4;
		s2 = "/home/hp/eclipse-workspace/Metric_Calc/src/" + s1;
		System.out.print("ENTER THE SECOND FILE NAME: ");
		s4 = sc.next();
		s3 = "/home/hp/eclipse-workspace/Metric_Calc/src/" + s4;
		sc.close();
		FileReader fp,fp1 ;
		Enhanced_halstead p=new Enhanced_halstead();
		ParserC c = new ParserC();

		Enhanced_halstead p1=new Enhanced_halstead();
		ParserC c1 = new ParserC();
		int N,n,N1,n1,Na1,Na,ch;
		double V,V1,D,D1,Ea,Ea1,Va,Va1;
		String str = "",str2 = "";
					try{
						fp = new FileReader(s2);
						fp1 = new FileReader(s3);
						
						while((ch = fp.read()) != -1){
							str += (char)ch;
						}
						while((ch = fp1.read()) != -1){
							str2 += (char)ch;
						}
						
					}catch(Exception e){
						System.out.print("Error");
					}
					StringTokenizer st = new StringTokenizer(str,"\n");
				    while(st.hasMoreTokens()){
				    	String str1 = st.nextToken().trim()+";";
				    	if(str1.charAt(0) != '#' && str1.charAt(0) !='/'){
				    		 p.parse(str1);
				    		 c.parse(str1);
				    	}
				    	
				    }
				    StringTokenizer st1 = new StringTokenizer(str2,"\n");
					
				    while(st1.hasMoreTokens()){
				    	String str1 = st1.nextToken().trim()+";";
				    	if(str1.charAt(0) != '#' && str1.charAt(0) !='/'){
				    		 p1.parse(str1);
				    		 c1.parse(str1);
				    	}
				    	
				    }
				N = p.N1 + p.N2;
				n = p.n1 + p.n2;
				V = N * Math.log(n);
				D = ((p.n1/2) * (p.N2/p.n2));
				
			
				Na = p.N1+p.N2+p.countop+p.countor;
				Va = Na*(Math.log(p.n1+p.n2));
				Ea = Va*((p.n1*p.N2)/(2*p.n2));
				N1 = p1.N1 + p1.N2;
				n1 = p1.n1 + p1.n2;
				V1 = N1 * Math.log(n1);
				D1 = ((p1.n1/2) * (p1.N2/p1.n2));
				
				Na1 = p1.N1+p1.N2+p1.countop+p1.countor;
				Va1 = Na1*(Math.log(p1.n1+p1.n2));
				Ea1 = Va1*((p1.n1*p1.N2)/(2*p1.n2));
				JFrame f=new JFrame();    
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JFrame f1 = new JFrame();
				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    String data[][]={{s1,Integer.toString(c.count+1),Integer.toString(N),Integer.toString(n),
			    				  Double.toString(V*D),Integer.toString(Na),Double.toString(Ea)},
			    		{s4,Integer.toString(c1.count+1),Integer.toString(N1),Integer.toString(n1),
				    				  Double.toString(V1*D1),Integer.toString(Na1),Double.toString(Ea1)}
				    
			    };    
			    String column[]={"Program","CC","N","n","E","Na","Ea"};         
			    JTable jt=new JTable(data,column);    
			    jt.setBounds(30,40,200,300);          
			    JScrollPane sp=new JScrollPane(jt);
			    String data1[][]= {{"CC","Cyclomatic Number"},
			    		{"N","Halstead program length"},
			    		{"n","Halstead vocabulary size"},
			    		{"E","Halstead effort"},
			    		{"Na","Adjoined length"},
			    		{"Ea","Adjoined effort"}};
			    String column1[]= {"","LEGEND"};
			    JTable jt1 = new JTable(data1,column1);
			    jt1.setBounds(30, 40, 200, 300);
			    JScrollPane sp1 = new JScrollPane(jt1);
			    f.add(sp,BorderLayout.NORTH);          
			    f.setSize(1000,300);    
			    f.setVisible(true); 
			    f1.add(sp1);
			    f1.setSize(400,300);
			    f1.setVisible(true);
				 }
	   
}
