
public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if(s.charAt(l) != s.charAt(r))
				return helper(s, l, r - 1) || helper(s, l + 1, r);
			l++;
			r--;
		}
		return true;
	}
	public boolean helper(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}
