import java.util.Stack;

/*
 * LeetCode 224 Hard
 * 
 * Basic Calculator
 * 
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 
Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:
1 <= s.length <= 3 * 10^5
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation.
'-' could be used as a unary operation but it has to be inside parentheses.
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
 */
public class BasicCalculator {
	public int calculate(String s) {
		StringBuilder sb = new StringBuilder(s);
		return helper(sb);
	}
	// stack: '+', '-', '*', '/'
	// recursion: '(',')'
	public int helper(StringBuilder s) {
		Stack<Integer> st = new Stack<>();
		int n = s.length(), res = 0, num = 0;
		char sign = '+';
		while (s.length() > 0) {
			char c = s.charAt(0);
			s.deleteCharAt(0);
			if (Character.isDigit(c))
				num = 10 * num + (c - '0');
			if (c == '(')
				num = helper(s);
			if ((!Character.isDigit(c) && c != ' ') || s.length() == 0) {
				switch(sign) {
					case '+':
						st.push(num);
						break;
					case '-':
						st.push(-num);
						break;
				}
				sign = c;
				num = 0;
			}
			if (c == ')')
				break;
		}
		while (!st.isEmpty())
			res += st.pop();
		
		return res;
	}
	public static void main(String[] args) {
		BasicCalculator test = new BasicCalculator();
		System.out.println(test.calculate("1 + 1"));
		System.out.println(test.calculate("2-1 + 2 "));
		System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
}
