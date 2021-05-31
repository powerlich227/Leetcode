import java.util.HashMap;

/*
 * LeetCode 166 Medium
 * 
 * Fraction to Recurring Decimal
 * 
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
If multiple answers are possible, return any of them.
It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 
Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"

Example 4:
Input: numerator = 4, denominator = 333
Output: "0.(012)"

Example 5:
Input: numerator = 1, denominator = 5
Output: "0.2"
 

Constraints:
-2^31 <= numerator, denominator <= 2^31 - 1
denominator != 0
 */
public class FractionToRecurringDecimal {
	// str += numerator / denominator, rem = numerator % denominator
	// str += (rem * 10) / denominator, rem = (rem * 10) % denominator
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		
		int s1 = numerator > 0 ? 1 : -1;
		int s2 = denominator > 0 ? 1 : -1;
		if (s1 * s2 < 0)
			sb.append('-');
		
		long num = Math.abs((long)numerator);
		long denom = Math.abs((long)denominator);
		sb.append(num / denom);

		num %= denom;
		if (num == 0)
			return sb.toString();
		sb.append('.');
		
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(num, sb.length());
		while (num != 0) {
			num *= 10;
			sb.append(num / denom);
			num %= denom;
			if (map.containsKey(num)) {
				sb.insert(map.get(num), "(");
				sb.append(')');
				return sb.toString();
			}
			map.put(num, sb.length());
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		FractionToRecurringDecimal test = new FractionToRecurringDecimal();
		System.out.println(test.fractionToDecimal(1, 2));
		System.out.println(test.fractionToDecimal(2, 1));
		System.out.println(test.fractionToDecimal(2, 3));
		System.out.println(test.fractionToDecimal(1, 6));
		System.out.println(test.fractionToDecimal(1, 5));
	}
}
