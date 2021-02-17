
public class FactorialTrailingZeroes {
	public static void main(String[] args) {
		System.out.println();
	}
	public int trailingZeroes(int n) {
		int res = 0;
		while (n > 0) {
			res += n / 5;
			n /= 5;
		}
		return res;
	}
	public int trailingZeroes2(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes2(n / 5);
	}

}
