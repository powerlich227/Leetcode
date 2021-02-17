
public class PermutationSequence {
	public static void main(String[] args) {
		System.out.println();
	}
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();

		int[] fac = new int[n];
		fac[0] = 1;
		for (int i = 1; i < n; i++)
			fac[i] = fac[i - 1] * i; // [1,1,2,6,24,...n!]
		
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1; // [1,2,3,...,n]
		
        k--;
		for (int i = n; i > 0; i--) {
			int digit = k / fac[i - 1]; // the number in a digit
            
			// find the "digit"th non-zero number in nums[]	
            int index = 0, count = -1; 
			for (int j = 0; j < n; j++) {
				if (count == digit)
					break;
				if (nums[j] != 0) {
					index = j;
					count++;
				}
			}
			sb.append(nums[index]);
			nums[index] = 0; // clear this number
            k %= fac[i - 1]; // update k to next digit
		}
		return sb.toString();
	}

}
