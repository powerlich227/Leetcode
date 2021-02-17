
public class PowerOfThree {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isPowerOfThree(int n) {
		while (n > 0 && n % 3 == 0) 
			n /= 3;
		return n == 1;
	}

}
