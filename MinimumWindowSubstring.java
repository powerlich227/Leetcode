import java.util.HashMap;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		System.out.println();
	}
	public String minWindow(String s, String t) {
		String res = "";
		int m = s.length(), n = t.length();
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();		
		for (int i = 0; i < n; i++) {
			hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
		}
		int l = 0, r = 0, count = 0, width = Integer.MAX_VALUE;
		while (r < m) {
			if (hashMap.containsKey(s.charAt(r))) {
				hashMap.put(s.charAt(r), hashMap.get(s.charAt(r)) - 1);
				if (hashMap.get(s.charAt(r)) >= 0)
					count++;                
			}
			while (count == t.length()) {
				if (width > r - l + 1) {
					width = r - l + 1;
					res = (r == m - 1) ? s.substring(l) : s.substring(l, r + 1);
				}
				if (hashMap.containsKey(s.charAt(l)) ) {
					hashMap.put(s.charAt(l), hashMap.get(s.charAt(l)) + 1);
					if (hashMap.get(s.charAt(l)) > 0)
						count--;
				}
				l++;
			}
			r++;
		}
		return res;
	}
}
