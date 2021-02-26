import java.util.*;
public class WordPattern {
	public static void main(String[] args) {
		System.out.println();
	}
	// pattern "abba"
	// s "dog cat cat dog"
	public boolean wordPattern(String pattern, String s) {
		HashMap map = new HashMap<>();
		String[] words = s.split(" "); // "dog", "cat", "cat", "dog"
		if (pattern.length() != words.length)
			return false;
		for (Integer i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			String word = words[i];
			
			if (!map.containsKey(c))
				map.put(c, i);
			if (!map.containsKey(word))
				map.put(word, i);
			if (map.get(c) != map.get(word))
				return false;
		}
		
		return true;	
	}
	
}
