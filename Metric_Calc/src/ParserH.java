import java.util.*;
public class ParserH {
	ArrayList<String> opral = new ArrayList<String>();
	ArrayList<String> opreal = new ArrayList<String>();
	int n1,n2,N1,N2;
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
	
	boolean validIdentifier(String str)
	{
		char c = str.charAt(0);
	    if (c == '0' || c == '1' || c == '2' ||
	        c == '3' || c == '4' || c == '5' || 
	        c == '6' || c == '7' || c == '8' || 
	        c == '9' || isDelimiter(c) == true)
	        return (false);
	    return (true);
	}
	
	boolean isInteger(String str)
	{
	    int i, len = str.length();
	 
	    if (len == 0)
	        return (false);
	    for (i = 0; i < len; i++) {
	    	char  c = str.charAt(0);
	        if (c != '0' && c != '1' && c != '2'
	            && c != '3' && c != '4' && c != '5'
	            && c != '6' && c != '7' && c != '8'
	            && c != '9' || (c == '-' && i > 0))
	            return (false);
	    }
	    return (true);
	}
	
	boolean isRealNumber(String str)
	{
	    int i, len = str.length();
	    boolean hasDecimal = false;
	 
	    if (len == 0)
	        return (false);
	    for (i = 0; i < len; i++) {
	    	char c = str.charAt(i);
	        if (c != '0' && c != '1' && c != '2'
	            && c != '3' && c != '4' && c != '5'
	            && c != '6' && c != '7' && c != '8'
	            && c != '9' && c != '.' || 
	            (c == '-' && i > 0))
	            return (false);
	        if (c == '.')
	            hasDecimal = true;
	    }
	    return (hasDecimal);
	}
	
	boolean isOperator(char ch)
	{
	    if (ch == '+' || ch == '-' || ch == '*' || 
	        ch == '/' || ch == '>' || ch == '<' || 
	        ch == '=' || ch == '&' || ch == '|' || 
	        ch == '(' || ch == '[' || ch == '{' ||
	        ch == '%' || ch == ',' || ch == '^' || 
	        ch == '.' || ch == '?' || ch == ';')
	        return (true);
	    return (false);
	}
	
	boolean isKeyword(String str)
	{
	    if (str.equals("auto") || str.equals("double") || str.equals("int") || str.equals("struct") ||
	    	str.equals("break") ||	str.equals("else") || str.equals("if") || str.equals("long") ||
	    	str.equals("switch") ||str.equals("case") || str.equals("enum") ||str.equals("register") ||
	    	str.equals("typedef") || str.equals("char") || str.equals("extern") || str.equals("return") ||
	    	str.equals("union") || str.equals("const") || str.equals("float") || str.equals("short") ||
	    	str.equals("unsigned") || str.equals("continue") || str.equals("for") || str.equals("signed") ||
	    	str.equals("void") || str.equals("default") || str.equals("goto") || str.equals("sizeof") ||
	    	str.equals("volatile") || str.equals("do") || str.equals("if")	|| str.equals("static")	 || str.equals("while"))
	        return (true);
	    return (false);
	}
	
	public void parse(String str){
		 int left = 0, right = 0;
		    int len = str.length();
		    len--;
		    while (right < len && left <= right) {
		        if (isDelimiter(str.charAt(right)) == false)
		            right++;
		 
		        if (isDelimiter(str.charAt(right)) == true && left == right) {
		            if (isOperator(str.charAt(right)) == true){
		            	char c = str.charAt(right);
		            	if(c == '&'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '&'){
		            			opral.add("&&");
		            		}
		            		else if(c1 == '=')
		            			opral.add("&=");
		            		else{
		            			opral.add("&");
		            	    	right--;
		            		}
		            	}
		            	
		            	if(c == '|'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '|'){
		            			opral.add("||");
		            		}else if(c1 == '=')
		            				opral.add("|=");
		            		else{
		            			right--;
		            			opral.add("|");
		            		}
		            	}
		            	
		            	if(c == '('){
		            		opral.add("()");
		            	}
		            	
		            	if(c == '['){
		            		opral.add("[]");
		            	}
		            	
		            	if(c == '{'){
		            		opral.add("{}");
		            	}
		            	
		            	if(c == '+'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '+')
		            			opral.add("++");
		            		else if(c1 == '=')
		            			opral.add("+=");
		            		else{
		            			right--;
		            			opral.add("+");
		            		}
		            	}
		            	
		            	if(c == '-'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '-')
		            			opral.add("--");
		            		else if(c1 == '=')
		            			opral.add("-=");
		            		else if(c1 == '>')
		            			opral.add("->");
		            		else{
		            			right--;
		            			opral.add("-");
		            		}
		            	}
		            	
		            	if(c == '*'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '=')
		            			opral.add("*=");
		            		else{
		            			opral.add("*");
		            			right--;
		            	     }
		                 }
		            	
		            	if(c == '/'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '=')
		            			opral.add("/=");
		            		else{
		            			opral.add("/");
		            			right--;
		            	     }
		                 }
		            	
		            	if(c == '%'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '=')
		            			opral.add("%=");
		            		else{
		            			opral.add("%");
		            			right--;
		            	     }
		                 }
		            	
		            	if(c == '?')
		            		opral.add("?:");
		            	
		            	if(c == '<'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '=')
		            			opral.add("<=");
		            		else if(c1 == '<')
		            			opral.add("<<");
		            		else if(c1 == '>'){
		            			right++;
		            			if(str.charAt(right) == '=')
		            				opral.add("<>=");
		            			else{
		            				opral.add("<>");
		            				right--;
		            			}
		            			}
		            		else
		            		{
		            			opral.add("<");
		            			right--;
		            	     }
		                 }
		            	
		            	if(c == '>'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '=')
		            			opral.add(">=");
		            		else if(c1 == '>')
		            			opral.add(">>");
		            		else
		            		{
		            			opral.add(">");
		            			right--;
		            	     }
		                 }
		            	
		            	if(c == '!'){
		            		right++;
			            	char c1 = str.charAt(right);
			            	if(c1 == '=')
			           			opral.add("!=");
			           		else if(c1 == '~')
			           			opral.add("!~");
			           		else
			           		{
			           			opral.add("!");
			           			right--;
			           	     }
			             }
		            	
		            	if(c == '='){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '=')
		            			opral.add("==");
		            		else{
		            			opral.add("=");
		            			right--;
		            		}
		            	}
		            	
		            	if(c == '^'){
		            		right++;
		            		char c1 = str.charAt(right);
		            		if(c1 == '=')
		            			opral.add("^=");
		            		else{
		            			opral.add("^");
		            			right--;
		            		}
		            	}
		            	
		            	if(c == '.' || c == ',' || c ==';'){
		            		opral.add(""+c);
		            	}
		            }
		               // System.out.println(str.charAt(right)+" IS AN OPERATOR\n");
		 
		            right++;
		            left = right;
		        } else if (isDelimiter(str.charAt(right)) == true && left != right
		                   || (right == len && left != right)) {
		  
		        	String subStr = str.substring(left,right);
		  
		            if (isKeyword(subStr) == true){
		            	
		            	opral.add(subStr);
		            }
		            else if (isInteger(subStr) == true)
		                opreal.add(subStr);
		 
		            else if (isRealNumber(subStr) == true)
		            	opreal.add(subStr);
		 
		            else if (validIdentifier(subStr) == true
		                     && isDelimiter(str.charAt(right-1)) == false)
		            	opreal.add(subStr);
		            left = right;
		        }
		    }
		    Set<String> set = new HashSet<String>(opral);
	        
            Set<String> seto = new HashSet<String>(opreal);
	        
            n1 = set.size();
            n2 = seto.size();
	        N1 = opral.size();
	        N2 = opreal.size();
	}

}
