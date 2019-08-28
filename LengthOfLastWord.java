
public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println();
	}
	public int lengthOfLastWord(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				if (s.charAt(i - 1) == ' ' && i > 0)
					res = 1;
				else
					res++;
			}
		}
		return res;
	}
	public int lengthOfLastWord2(String s) {
		int res = 0;
		int right = s.length() - 1;
		while (right >= 0 && s.charAt(right) == ' ')
			right--;
		while (right >= 0 && s.charAt(right) != ' ') {
			right--;
			res++;
		}
		return res;
	}
	public int lengthOfLastWord3(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}
}
