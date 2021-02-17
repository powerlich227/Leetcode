
public class IntegerToRoman {
	public static void main(String[] args) {
		System.out.println();
	}
	public String intToRoman(int num) {
		String res = "";
		char[] symbol = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int[] value = new int[]{1000, 500, 100, 50, 10, 5, 1};
		for (int i = 0; i < 7; i += 2) {
			int x = num / value[i];
			if (x < 4) {
				for (int j = 0; j < x; j++)
					res += symbol[i];
			}
			else if (x == 4) {
				res += symbol[i] + symbol[i - 1];
			}
			else if (x > 4 && x < 9) {
				res += symbol[i - 1];
				for (int j = 6; j <= x; j++)
					res += symbol[i];
			}
			else if (x == 9) {
				res += symbol[i] + symbol[i - 2];
			}
			num %= value[i];
		}
		return res;
	}
	// Greedy Method -- Treat roman symbol as coin denomination
	public String intToRoman2(int num) {
		String res = "";
		String[] symbol = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] value = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		for (int i = 0; i < value.length; i++) {
			while (num >= value[i]) {
				num -= value[i];
				res += symbol[i];
			}
		}
		return res;
	}
}
