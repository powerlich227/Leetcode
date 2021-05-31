import java.util.Stack;
/*
 * LeetCode 20 Easy
 * 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Example 5:
Input: s = "{[]}"
Output: true
 

Constraints:
1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
	
	public static void main(String[] args) {
		String s = "()", s2 = "()[]{}", s3 = "(]", s4 = "([)]", s5 = "{[]}";
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid(s));
		System.out.println(test.isValid(s2));
		System.out.println(test.isValid(s3));
		System.out.println(test.isValid(s4));
		System.out.println(test.isValid(s5));
	}
	
	// stack
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