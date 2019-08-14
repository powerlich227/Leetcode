import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String[] args) {
		String s1 = "()";
		System.out.println("test");
	}
    public boolean isValid(String s) {
    	Stack<Character> temp = new Stack<>();
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') 
    			temp.push(s.charAt(i));
    		if (s.charAt(i) == '}' && (temp.empty() || temp.pop() != '{'))
    			return false;
    		if (s.charAt(i) == ']' && (temp.empty() || temp.pop() != '['))
    			return false;
    		if (s.charAt(i) == ')' && (temp.empty() || temp.pop() != '('))
    			return false;
    	}
        if (!temp.empty())
            return false;
		return true;
    }
}