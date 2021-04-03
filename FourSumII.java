import java.util.*;

/*	LeetCode 454
 *  4 Sum II
 *  
 * 	Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < B.length; j++) {
        		int part1 = A[i] + B[j];
        		map.put(part1, map.getOrDefault(part1, 0) + 1);
        	}
        }
        for (int i = 0; i < C.length; i++) {
        	for (int j = 0; j < D.length; j++) {
        		Integer part2 = (-1) * (C[i] + D[j]);
        		res += map.getOrDefault(part2, 0);
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	int[] A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
    	System.out.println(fourSumCount(A, B, C, D));
    }
}
