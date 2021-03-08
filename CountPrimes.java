
public class CountPrimes {
	public static void main(String[] args) {
		System.out.println();
	}
	
	/*
	 * Sieve of Eratosthenes
	 * 2,4,6...
	 * 3,6,9...
	 * ...
	 * n^0.5, 2*n^0.5, ....
	 * 
	 * Count the number of prime numbers less than a non-negative number n
	 */
	
	public int countPrimes(int n) {
		int res = 0;
		boolean[] prime = new boolean[n]; // 1...n-1 "false"
		for (int i = 2; i < n; i++) { // start from 2
			if (prime[i])
				continue;
			res++;
			for (int j = 2; i * j < n; j++)
				prime[i * j] = true;
		}
		return res;
	}
}
