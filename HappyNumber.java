import java.util.HashSet;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isHappy(int n) {
		HashSet set = new HashSet<>();
		while (n != 1) {
			int sum = 0;
			while (n != 0) {
				sum += Math.pow((n % 10), 2);
				n /= 10; 
			}
			n = sum;
			if (set.contains(n))
				break;
			set.add(n);
		}
		return n == 1;
	}
}
