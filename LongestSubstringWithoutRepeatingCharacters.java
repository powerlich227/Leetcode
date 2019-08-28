import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println();
	}
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int ret = 0;
		int i = 0, j = 0; // Range[i,j]
		while (i < s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				j++; // extend j
				set.add(s.charAt(j));
				ret = Math.max(ret, j - i);
			}
			else {
				i++;
				set.remove(s.charAt(i));
			}
		}
		return ret;
	}
	public int lengthOfLongestSubstring2(String s) {
		int ret = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < s.length(); j++) {
			if (map.containsKey(s.charAt(j)))
				i = Math.max(map.get(s.charAt(j)), i); //skip all the elements in the range [i,j]
			ret = Math.max(ret, j - i + 1);
			map.put(s.charAt(j), j + 1); //let i to be j + 1;
		}
		return ret;
	}
}
