
public class ValidAnagram {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] m = new int[26];
		for (int i = 0; i < s.length(); i++)
			m[s.charAt(i) - 'a']++;
		for (int j = 0; j < t.length(); j++) {
            m[t.charAt(j) - 'a']--;
			if (m[t.charAt(j) - 'a'] < 0) 
				return false;
		}
		return true;
	}

}
