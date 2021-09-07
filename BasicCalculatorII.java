import java.util.Stack;

/*
 * LeeCode 227 Medium
 * 
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-2^31, 2^31 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 
Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 10^5
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 */
public class BasicCalculatorII {
	// stack
	public int calculate(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int m = s.length();
		Stack<Integer> st = new Stack<Integer>();
		int cur = 0, res = 0;
		char op = '+';
		for (int i = 0; i < m; i++) {				
			char c = s.charAt(i);
			if (Character.isDigit(c))
				cur = cur * 10 + c - '0';
			if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == m - 1) {
				if (op == '+')
					st.push(cur);
				else if (op == '-')
					st.push(-cur);
				else if (op == '*')
					st.push(st.pop() * cur);
				else if (op == '/')
					st.push(st.pop() / cur);
				op = c;
				cur = 0;
			}
 		}
		while (!st.isEmpty())
			res += st.pop();
		return res;
	}
	public static void main(String[] args) {
		BasicCalculatorII test = new BasicCalculatorII();
		System.out.println(test.calculate("3+2*2"));
		System.out.println(test.calculate(" 3/2 "));
		System.out.println(test.calculate(" 3+5 / 2 "));
	}

}
