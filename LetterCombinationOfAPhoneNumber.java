import java.util.*;

public class LetterCombinationOfAPhoneNumber {
	public static void main(String[] args) {
		String digits = "45";
		List<String> test = new ArrayList<String> ();
		test = letterCombinations4(digits);
		System.out.println(test);
	}
	static Map<String, String> map = new HashMap<String, String>() {{
		put("2", "abc");
		put("3", "def");
		put("4", "ghi");
		put("5", "jkl");
		put("6", "mno");
		put("7", "pqrs");
		put("8", "tuv");
		put("9", "wxyz");
	}};
	
	// Recursion
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String> ();
		if (!digits.isEmpty())
			backTrack("", digits, res);		
		return res;
	}
	public void backTrack(String combination, String nextDigits, List<String> res) {
		if (nextDigits.length() == 0)
			res.add(combination);
		else {
			String digit = nextDigits.substring(0, 1);
			for (int i = 0; i < map.get(digit).length(); i++) {
				String letter = map.get(digit).substring(i, i + 1);
				backTrack(combination + letter, nextDigits.substring(1), res);
			}
		}
	}
	
	// Iteration w/ temp list
	public static List<String> letterCombinations2(String digits) {
		List<String> res = new LinkedList<String> ();
		if (digits.isEmpty()) 
			return res;
		res.add("");
		
		String[] str = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		for(int i = 0; i < digits.length(); i++) {
			List<String> temp = new LinkedList<String> ();
			String s = str[digits.charAt(i) - '0'];
			for (int j = 0; j < s.length(); j++) {
				for (String r : res)
					temp.add(r + s.charAt(j));
			}
			res = temp;
		}
		return res;
	}
	// Iteration with LinkedList (FIFO) w/o temp list
	public static List<String> letterCombinations3(String digits) {
		LinkedList<String> res = new LinkedList<String> ();
		if (digits.isEmpty()) 
			return res;
		res.add("");
		
		String[] str = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		for(int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while(res.size() == i){
				String t = res.remove();
				for(char s : str[x].toCharArray())
					res.add(t + s);
			}
		}
		return res;
	}
	
	public static List<String> letterCombinations4(String digits) {
		LinkedList<String> res = new LinkedList<String> ();
		if (digits.isEmpty()) 
			return res;
		res.add("");
		
		String[] str = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		while(res.peek().length() != digits.length()) {
			String r = res.remove();
			String s = str[digits.charAt(r.length()) - '0']; //?
			for(char st : s.toCharArray())
				res.add(r + st);
		}
		return res;
	}
	
}
