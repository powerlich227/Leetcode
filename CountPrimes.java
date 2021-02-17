
public class CountPrimes {
	public static void main(String[] args) {
		System.out.println();
	}
	public int countPrimes(int n) {
		int res = 0;
		boolean[] prime = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (prime[i])
				continue;
			res++;
			for (int j = 2; i * j < n; j++)
				prime[i * j] = true;
		}
		return res;
	}
}
