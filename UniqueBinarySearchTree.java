
public class UniqueBinarySearchTree {
	public static void main(String[] args) {
		System.out.println();
	}
	// Catalan Number
	public int numTrees(int n) {
		int[] res = new int[n + 1];
		res[0] = 1; res[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++)
				res[i] += res[j] * res[i - j - 1];
		}
		return res[n];
		
	}

}
