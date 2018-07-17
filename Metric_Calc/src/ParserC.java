
public class ParserC {
	
	boolean isDelimiter(char ch)
	{
	    if (ch == ' ' || ch == '+' || ch == '-' || ch == '*' || 
	        ch == '/' || ch == ',' || ch == ';' || ch == '>' || 
	        ch == '<' || ch == '=' || ch == '(' || ch == ')' || 
	        ch == '[' || ch == ']' || ch == '{' || ch == '}' ||
	        ch == '&' || ch =='|')
	        return (true);
	    return (false);
	}
	
	boolean isOperator(char ch)
	{
	    if (ch == '+' || ch == '-' || ch == '*' || 
	        ch == '/' || ch == '>' || ch == '<' || 
	        ch == '=' || ch == '&' || ch == '|')
	        return (true);
	    return (false);
	}
	
	boolean isKeyword(String str)
	{
	    if (str.equals("if")  ||                               
	        str.equals("while") || str.equals("do") || 
	        str.equals("for"))
	        return (true);
	    return (false);
	}
	
	public int parse(String str){
		 int left = 0, right = 0,count = 0;
		    int len = str.length();
		    len--;
		    //System.out.println(len);
		    while (right < len && left <= right) {
		        if (isDelimiter(str.charAt(right)) == false)
		            right++;
		 
		        if (isDelimiter(str.charAt(right)) == true && left == right) {
		            if (isOperator(str.charAt(right)) == true){
		            	if(str.charAt(right) == '&'){
		            		right++;
		            		if(str.charAt(right) == '&'){
		            			count++;
		            		}else{
		            			right--;
		            		}
		            	}
		            	if(str.charAt(right) == '|'){
		            		right++;
		            		if(str.charAt(right) == '|'){
		            			count++;
		            		}else{
		            			right--;
		            		}
		            	}
		            }
		               // System.out.println(str.charAt(right)+" IS AN OPERATOR\n");
		 
		            right++;
		            left = right;
		        } else if (isDelimiter(str.charAt(right)) == true && left != right
		                   || (right == len && left != right)) {
		  
		        	String subStr = str.substring(left,right);
		  
		            if (isKeyword(subStr) == true){
		            	count++;
		            	System.out.println(subStr+"is a keyword");
		            }
		 
		            left = right;
		        }
		    }
		return count;
	}
}
