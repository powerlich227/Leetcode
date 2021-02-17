
public class JumpGameII {
	public static void main(String[] args) {
		System.out.println();
	}
	public int jump(int[] nums) {
		int res = 0, cur = 0, i = 0; // res: step, cur: current farthest index, i: available indices
		while(cur < nums.length - 1) {
			res++;
			int pre = cur; // pre: previous farthest index
			for (; i <= pre; i++)
				cur = Math.max(cur, i + nums[i]);		
		}
		return res;
	}

}
