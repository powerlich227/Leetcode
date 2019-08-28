
public class ClimbingStairs {
	public static void main(String[] args) {
		System.out.println();
	}
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] res = new int[n];
		res[0] = 1; res[1] = 2;
		for(int i = 2; i < n; i++) {
			res[i] = res[i - 1] + res[i - 2]; // f(n) = f(n-1) + f(n-2)
		}
		return res[n - 1];
	}
	public int climbStairs2(int n) {
		int x = 1; //f(0) and f(n-2)
		int y = 1; //f(1) and f(n-1)
		while (n > 0) {
			n--;
			y += x; //
			x = y - x;
		}
		return x;
	}
	public int climbStairs3(int n) {
		return (int) ((1.0 / Math.sqrt(5)) * (Math.pow((1 + Math.sqrt(5)) / 2, n + 1) - Math.pow((1 - Math.sqrt(5)) / 2, n + 1)));
	} 
}
