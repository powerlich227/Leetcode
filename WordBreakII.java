import java.util.*;
public class WordBreakII {
	public static void main(String[] args) {
		System.out.println();
	}
	/*
	 * 	BackTracking
	 *  DFS
	 */
	Map<String, List<String>> map = new HashMap<>();	
	public List<String> wordBreak(String s, List<String> wordDict) {
		if (map.containsKey(s))
			return map.get(s);
		List<String> res = new ArrayList<>();
		if (s.isEmpty()) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> remain = wordBreak(s.substring(word.length()), wordDict);
				for (String str : remain) {
					res.add(word + (str.isEmpty() ? "" : " ") + str);
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
