
public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isPowerOfTwo(int n) {
		int count = 0;
		while (n > 0) {
			count += (n & 1);
			n >>= 1;
		}
        return count == 1;
    }
	public boolean isPowerOfTwo2(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
}
