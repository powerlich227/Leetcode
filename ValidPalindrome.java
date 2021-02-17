
public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left)))
				left++;
			else if (!Character.isLetterOrDigit(s.charAt(right)))
				right--;
			else if ((s.charAt(left) + 32 - 'a') % 32 != (s.charAt(right) + 32 - 'a') % 32)
				return false;
			else {
				left++;
				right--;
			}
		}
		return true;
	}
}
