
public class NumberOf1Bits {
	public static void main(String[] args) {
		System.out.println();
	}
	public int hammingWeight(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += (n & 1);
			n = n >> 1;
		}
		return res;
	}
}
