import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * LeetCode 870 Medium
 * 
 * Advantage Shuffle
 *
 * You are given two integer arrays nums1 and nums2 both of the same length. 
 * The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].

Return any permutation of nums1 that maximizes its advantage with respect to nums2.
 
Example 1:
Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
Output: [2,11,7,15]

Example 2:
Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
Output: [24,32,8,12]
 
Constraints:

1 <= nums1.length <= 10^5
nums2.length == nums1.length
0 <= nums1[i], nums2[i] <= 10^9
 */
public class AdvantageShuffle {
	// pq: nums2 large to small;
	// nums1 sort: small to large
	// two pointers: left -> small, right -> large
	public int[] advantageCount(int[] nums1, int[] nums2) {
		int n = nums1.length;
		Arrays.sort(nums1);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
		for (int i = 0; i < n; i++) {
			pq.offer(new int[] {i, nums2[i]});
		}
		
		int left = 0, right = n - 1;
		int[] res = new int[n];
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int idx = cur[0], val = cur[1];
			if (nums1[right] > val) {
				res[idx] = nums1[right];
				right--;
			}
			else if (nums1[right] <= val) {
				res[idx] = nums1[left];
				left++;
			}
		}		
		return res;	
	}
	public static void main(String[] args) {
		AdvantageShuffle test = new AdvantageShuffle();
		System.out.println(Arrays.toString(test.advantageCount(new int[] {2, 7, 11, 15}, new int[] {1, 10, 4, 11})));
		System.out.println(Arrays.toString(test.advantageCount(new int[] {12, 24, 8, 32}, new int[] {13, 25, 32, 11})));
	}
}
