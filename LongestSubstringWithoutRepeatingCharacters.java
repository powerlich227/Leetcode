import java.util.HashMap;	
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println();
	}
	// Sliding Window 1 with hashset
	public int lengthOfLongestSubstring(String s) {
//		Set<Character> set = new HashSet<>();
//		int res = 0, i = 0, j = 0; // Range[i,j]
//		while (i < s.length() && j < s.length()) {
//			if (!set.contains(s.charAt(j))) {
//				set.add(s.charAt(j++)); // extend j
//				res = Math.max(res, j - i);
//			}
//			else
//				set.remove(s.charAt(i++)); // extend i
//		}
//		return res;
		HashSet<Character> set = new HashSet<>();
		int res = 0, l = 0, r = 0;
		while (r < s.length()) {
			if (!set.contains(s.charAt(r))) {
				set.add(s.charAt(r));
				r++;
				res = Math.max(set.size(), res);
			}
			else {
				set.remove(s.charAt(l));
				l++;
			}
		}
		return res;
	}
	// Sliding Window 2 with hashmap
	public int lengthOfLongestSubstring2(String s) {
		int res = 0, i = -1; // i = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0; j < s.length(); j++) {
			// if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) > i
			//		i = map.get(s.charAt(j);
			if (map.containsKey(s.charAt(j))) // 
				i = Math.max(map.get(s.charAt(j)), i); // update i;
			map.put(s.charAt(j), j); // update hashmap {s(j), j};
			res = Math.max(res, j - i);
		}
		return res;
	}
	// Sliding Window 3 with ASCII 128
	public int lengthOfLongestSubstring3(String s) {
		int res = 0, i = 0;
		int[] m = new int[128];
		for (int j = 0; j < s.length(); j++) {
			i = Math.max(i, m[s.charAt(j)]);
			m[s.charAt(j)] = j + 1;
			res = Math.max(res, j - i + 1);
		}
		return res;
	}
}
