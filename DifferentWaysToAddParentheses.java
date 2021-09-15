import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * LeetCode 241 Medium
 * 
 * Different Ways to Add Parentheses
 * 
Given a string expression of numbers and operators, 
return all possible results from computing all the different possible ways to group numbers and operators. 
You may return the answer in any order.


Example 1:
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]

Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
 */
public class DifferentWaysToAddParentheses {
	HashMap<String, List<Integer>> memo = new HashMap<>();
	public List<Integer> diffWaysToCompute(String expression) {
		if (memo.containsKey(expression))
			return memo.get(expression);
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(expression.substring(0, i));
				List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
				for (int j = 0; j < left.size(); j++) {
					for (int k = 0; k < right.size(); k++) {
						if (c == '+')
							res.add(left.get(j) + right.get(k));
						else if (c == '-')
							res.add(left.get(j) - right.get(k));
						else
							res.add(left.get(j) * right.get(k));
					}
				}
			}
		}
		if (res.isEmpty())
			res.add(Integer.parseInt(expression));
		memo.put(expression, res);
		return res;
	}
	public static void main(String[] args) {
		DifferentWaysToAddParentheses test = new DifferentWaysToAddParentheses();
		System.out.println(test.diffWaysToCompute("2-1-1"));
		System.out.println(test.diffWaysToCompute("2*3-4*5"));		
	}

}
