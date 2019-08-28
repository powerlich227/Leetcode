
public class PlusOne {
	public static void main(String[] args) {
		System.out.println();
	}
	public int[] plusOne(int[] digits) {
		int n = digits.length;
        int[] res = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] == 9)
				digits[i] = 0;
            else {
                digits[i]++;
                return digits;
            }
		}
		res[0] = 1;
		return res;
	}
}
