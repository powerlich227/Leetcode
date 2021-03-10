import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
	public static void main(String[] args) {
		System.out.println();
	}
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0)
			return intervals;
		LinkedList<int[]> res = new LinkedList<>(); 
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		for (int[] interval : intervals) {
			if (res.isEmpty() || res.getLast()[1] < interval[0])
				res.add(interval);
			else
				res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
		}
		return res.toArray(new int[res.size()][]);
	}
}
