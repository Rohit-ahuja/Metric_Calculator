
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
	    if (str.equals("if") || str.equals("else") ||                                 //auto	double	int	struct
	    		/*break	long	switch
	    case	enum	register	typedef
	    char	extern	return	union
	    const	float	short	unsigned
	    continue	for	signed	void
	    default	goto	sizeof	volatile
	    do	static	while*/
	        str.equals("while") || str.equals("do") || 
	        str.equals("break") || 
	         str.equals("continue") || str.equals("int")
	        || str.equals("double") || str.equals("float")
	        || str.equals("return") || str.equals("char")
	        || str.equals("case") || str.equals("char")
	        || str.equals("sizeof") || str.equals("long")
	        || str.equals("short") || str.equals("typedef")
	        || str.equals("switch") || str.equals("unsigned")
	        || str.equals("void") || str.equals("static")
	        || str.equals("struct") || str.equals("goto"))
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
	 
	// Parsing the input STRING.
	void parse(String str)
	{
	    int left = 0, right = 0;
	    int len = str.length();
	    len--;
	    //System.out.println(len);
	    while (right < len && left <= right) {
	        if (isDelimiter(str.charAt(right)) == false)
	            right++;
	 
	        if (isDelimiter(str.charAt(right)) == true && left == right) {
	            if (isOperator(str.charAt(right)) == true)
	                System.out.println(str.charAt(right)+" IS AN OPERATOR\n");
	 
	            right++;
	            left = right;
	        } else if (isDelimiter(str.charAt(right)) == true && left != right
	                   || (right == len && left != right)) {
	            //String subStr = subString(str, left, right - 1);
	        	String subStr = str.substring(left,right);
	        	//System.out.println(subStr+"hello");
	            if (isKeyword(subStr) == true)
	                System.out.println(subStr+" IS A KEYWORD\n");
	 
	            else if (isInteger(subStr) == true)
	                System.out.println(subStr+" IS AN INTEGER\n");
	 
	            else if (isRealNumber(subStr) == true)
	                System.out.println(subStr+" IS A REAL NUMBER\n");
	 
	            else if (validIdentifier(subStr) == true
	                     && isDelimiter(str.charAt(right-1)) == false)
	                System.out.println(subStr+" IS A VALID IDENTIFIER\n");
	 
	            else if (validIdentifier(subStr) == false
	                     && isDelimiter(str.charAt(right-1)) == false)
	                System.out.println(subStr+" IS NOT A VALID IDENTIFIER\n");
	            left = right;
	        }
	    }
	    return;
	}
	 

}
