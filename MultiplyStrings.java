/*
 * LeetCode 43
 * 
 * Multiply Strings
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
 
Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
		// num1[i] * num2[j] will be placed at indices [i + j, i + j + 1]
		int m = num1.length(), n = num2.length();
		int[] result = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int sum = result[i + j + 1] + multi;
				result[i + j + 1] = sum % 10;
				result[i + j] += sum / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int res : result) {
			if (sb.length() != 0 || res != 0)
				sb.append(res);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
	public static void main(String[] args) {
		String num1 = "2", num2 = "3", num3 = "123", num4 = "456";
		String num5 = "0", num6 = "0";
		System.out.println(multiply(num1, num2));
		System.out.println(multiply(num3, num4));
		System.out.println(multiply(num5, num6));
	}
}
