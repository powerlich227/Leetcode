import java.util.*;
public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams2(strs));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if (!map.containsKey(key)) 
				map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}
	public static List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		int[] count = new int[26];
		for (String str : strs) {
			Arrays.fill(count, 0);
			char[] ch = str.toCharArray();
			for (char c : ch)
				count[c - 'a']++;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++)
				sb.append(count[i]);
			String key = sb.toString();
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
