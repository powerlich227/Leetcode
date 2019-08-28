
public class AddStrings {
	public static void main(String[] args) {
		System.out.println();
		
	}
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int m = num1.length() - 1;
		int n = num2.length() - 1;
		int carry = 0;
		while (m >= 0 || n >= 0) {
			int sum = carry;
			if (m >= 0)
				sum += num1.charAt(m--) - '0';
			if (n >= 0)
				sum += num2.charAt(n--) - '0';
			carry = sum / 10;
			sb.append(sum % 10);
		}
		if (carry == 1)
			sb.append(1);
		return sb.reverse().toString();
	}
}
