import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * LeetCode 264 Medium
 * 
 * Ugly Number II
 * 
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

Example 1:
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Example 2:
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690
 */
public class UglyNumberII {
	// dp
	// Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
	public int nthUglyNumber(int n) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (res.size() < n) {
			int m2 = res.get(i2) * 2, m3 = res.get(i3) * 3, m5 = res.get(i5) * 5;
			int min = Math.min(m2, Math.min(m3, m5));
			if (m2 == min)
				i2++;
			if (m3 == min)
				i3++;
			if (m5 == min)
				i5++;
			res.add(min);
		}
		return res.get(n - 1);
	}
	// pq
	public int nthUglyNumberII(int n) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.offer((long) 1);
		for (int i = 1; i < n; i++) {
			long cur = pq.poll();
			while (!pq.isEmpty() && pq.peek() == cur)
				cur = pq.poll(); // remove repeated number;
			pq.offer(cur * 2);
			pq.offer(cur * 3);
			pq.offer(cur * 5);
		}
		return pq.peek().intValue();
	}
	public static void main(String[] args) {
		UglyNumberII test = new UglyNumberII();
		System.out.println(test.nthUglyNumber(40));
		System.out.println(test.nthUglyNumberII(40));
	}
}
