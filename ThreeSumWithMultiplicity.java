/*
 * LeetCode 923 Medium
 * 
 * 
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 * 
 * As the answer can be very large, return it modulo 109 + 7.

Example 1:
Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.

Example 2:
Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways, and two 2s from [2,2,2,2] in 6 ways.
 
Constraints:
3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300

*/
public class ThreeSumWithMultiplicity {
    // x <= y <= z

	// If x != y != z, then the contribution is count[x] * count[y] * count[z].

    // If x == y != z, the contribution is C(count[x], 2) * count[z]

    // If x != y == z, the contribution is count[x] * C(count[y], 2)

    // If x == y == z, the contribution is C(count[x], 3)
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1_000_000_007;
        long[] cnt = new long[101];
        for (int i : arr)
            cnt[i]++;
        long res = 0;
        // x != y != z
        for (int i = 0; i <= 100; i++) {
            if (cnt[i] == 0)
                continue;
            for (int j = i + 1; j <= 100; j++) {
                int k = target - i - j;
                if (j < k && k <= 100) {
                    res += cnt[i] * cnt[j] * cnt[k];
                    res %= MOD;
                }
            }
        }
        // x == y != z
        for (int i = 0; i <= 100; i++) {
            if (cnt[i] == 0)
                continue;
            int k = target - i * 2;
            if (i < k && k <= 100) {
                res += cnt[i] * (cnt[i] - 1) / 2 * cnt[k];
                res %= MOD;
            }
        }
        // x != y == z
        for (int i = 0; i <= 100; i++) {
            if (cnt[i] == 0)
                continue;
            if (i % 2 == target % 2) {
                int j = (target - i) / 2;
                if (i < j && j <= 100) {
                    res += cnt[i] * cnt[j] * (cnt[j] - 1) / 2;
                    res %= MOD;
                }
            }
        }
        // x == y == z
        if (target % 3 == 0) {
            int i = target / 3;
            if (cnt[i] == 0)
                return (int) res;
            else if (i >= 0 && i <= 100) {
                res += cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                res %= MOD;
            }
        }
        return (int) res;
    }
	public static void main(String[] args) {
		ThreeSumWithMultiplicity test = new ThreeSumWithMultiplicity();
		System.out.println(test.threeSumMulti(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
		System.out.println(test.threeSumMulti(new int[] {1, 1, 2, 2, 2, 2}, 5));
	}
}
