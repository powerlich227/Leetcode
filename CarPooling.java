/*
 * LeetCode 1094 Medium
 * 
 * Car Pooling
 * 
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers 
and the locations to pick them up and drop them off are fromi and toi respectively. 
The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

Example 1:
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Example 2:
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
 
Constraints:

1 <= trips.length <= 1000
trips[i].length == 3
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= capacity <= 10^5
 */
public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		int[] nums = new int[1001];
		Difference dif = new Difference(nums);
		for (int[] trip : trips) {
			int i = trip[1], j = trip[2];
			int val = trip[0];
			dif.increment(i, j, val);
		}
		int[] res = dif.result();
		for (int r : res) {
			if (r > capacity)
				return false;
		}
		return true;
	}
	
	class Difference {
		private int[] diff;
		public Difference(int[] nums) {
			int n = nums.length;
			diff = new int[n];
			diff[0] = nums[0];
			for (int i = 1; i < n; i++)
				diff[i] = nums[i] - nums[i - 1];
		}
		public void increment(int i, int j, int val) {
			diff[i] += val;
			diff[j] -= val;
		}
		public int[] result() {
			int n = diff.length;
			int[] res = new int[n];
			res[0] = diff[0];
			for (int i = 1; i < n; i++)
				res[i] = res[i - 1] + diff[i];
			return res;
		}
	}
	public static void main(String[] args) {
		CarPooling test = new CarPooling();
		System.out.println(test.carPooling(new int[][] {{2,1,5},{3,3,7}}, 4));
		System.out.println(test.carPooling(new int[][] {{2,1,5},{3,3,7}}, 5));
	}
}
