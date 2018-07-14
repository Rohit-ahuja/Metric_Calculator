
public class Parser {

	boolean isDelimiter(char ch)
	{
	    if (ch == ' ' || ch == '+' || ch == '-' || ch == '*' || 
	        ch == '/' || ch == ',' || ch == ';' || ch == '>' || 
	        ch == '<' || ch == '=' || ch == '(' || ch == ')' || 
	        ch == '[' || ch == ']' || ch == '{' || ch == '}')
	        return (true);
	    return (false);
	}
	 
	// Returns 'true' if the character is an OPERATOR.
	boolean isOperator(char ch)
	{
	    if (ch == '+' || ch == '-' || ch == '*' || 
	        ch == '/' || ch == '>' || ch == '<' || 
	        ch == '=')
	        return (true);
	    return (false);
	}
	 
	// Returns 'true' if the string is a VALID IDENTIFIER.
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
	 
	// Returns 'true' if the string is a KEYWORD.
	boolean isKeyword(String str)
	{
	    if (!str.equals("if") || !str.equals("else") ||
	        !str.equals("while") || !str.equals("do") || 
	        !str.equals("break") || 
	         !str.equals("continue") || !str.equals("int")
	        || !str.equals("double") || !str.equals("float")
	        || !str.equals("return") || !str.equals("char")
	        || !str.equals("case") || !str.equals("char")
	        || !str.equals("sizeof") || !str.equals("long")
	        || !str.equals("short") || !str.equals("typedef")
	        || !str.equals("switch") || !str.equals("unsigned")
	        || !str.equals("void") || !str.equals("static")
	        || !str.equals("struct") || !str.equals("goto"))
	        return (true);
	    return (false);
	}
	 
	// Returns 'true' if the string is an INTEGER.
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
	 
	// Returns 'true' if the string is a REAL NUMBER.
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
	 
	// Extracts the SUBSTRING.
	String subString(String str, int left, int right)
	{
	    int i;
	    char subStr[] = new char[right - left + 1];
	 
	    for (i = left; i <= right; i++)
	        subStr[i - left] = str.charAt(i);
	    //subStr[right - left + 1] = '\0';
	    String s1 = new String(subStr);
	    System.out.println(s1.length());
	    return (new String(subStr));
	}
	 
	// Parsing the input STRING.
	void parse(String str)
	{
	    int left = 0, right = 0;
	    int len = str.length();
	    len--;
	    while (right <= len && left <= right) {
	        if (isDelimiter(str.charAt(right)) == false)
	            right++;
	 
	        if (isDelimiter(str.charAt(right)) == true && left == right) {
	            if (isOperator(str.charAt(right)) == true)
	                System.out.println(" IS AN OPERATOR\n"+ str.charAt(right));
	 
	            right++;
	            left = right;
	        } else if (isDelimiter(str.charAt(right)) == true && left != right
	                   || (right == len && left != right)) {
	            String subStr = subString(str, left, right - 1);
	 
	            if (isKeyword(subStr) == true)
	                System.out.println(" IS A KEYWORD\n"+ subStr);
	 
	            else if (isInteger(subStr) == true)
	                System.out.println(" IS AN INTEGER\n"+ subStr);
	 
	            else if (isRealNumber(subStr) == true)
	                System.out.println(" IS A REAL NUMBER\n"+ subStr);
	 
	            else if (validIdentifier(subStr) == true
	                     && isDelimiter(str.charAt(right-1)) == false)
	                System.out.println("'%s' IS A VALID IDENTIFIER\n"+ subStr);
	 
	            else if (validIdentifier(subStr) == false
	                     && isDelimiter(str.charAt(right-1)) == false)
	                System.out.println("'%s' IS NOT A VALID IDENTIFIER\n"+ subStr);
	            left = right;
	        }
	    }
	    return;
	}
	 

}
