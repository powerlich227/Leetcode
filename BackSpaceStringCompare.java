import java.util.Stack;

/*
 * LeetCode 844 Easy
 * 
 * BackSpace String Compare
 * 
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a##c", t = "#a#c"
Output: true
Explanation: Both s and t become "c".

Example 4:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 
Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 

Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackSpaceStringCompare {
	// follow up: O(n) time and O(1) space
    // Two Pointers, reverse traverse
    public boolean backspaceCompare(String s, String t) {
        int m = s.length(), n = t.length();
        int p = m - 1, q = n - 1;
        int skipS = 0, skipT = 0;
        while (p >= 0 || q >= 0) {
            while (p >= 0) {
                if (s.charAt(p) == '#') {
                    p--;
                    skipS++;
                }
                else if (skipS > 0) {
                    p--;
                    skipS--;
                }
                else
                    break;
            }
            while (q >= 0) {
                if (t.charAt(q) == '#') {
                    q--;
                    skipT++;
                }
                else if (skipT > 0) {
                    q--;
                    skipT--;
                }
                else
                    break;            
            }
            if (p >= 0 && q >= 0 && s.charAt(p) != t.charAt(q))
                return false;
            if (p >= 0 ^ q >= 0)
                return false;
            p--;
            q--;
        }
        return true;
    }
    // stack O(n) time and O(n) space
    public boolean backspaceCompare2(String s, String t) {
    	Stack<Character> st1 = new Stack<>();
    	Stack<Character> st2 = new Stack<>();
    	for (char c : s.toCharArray()) {
    		if (c == '#') {
    			if (!st1.isEmpty())
    				st1.pop();
    		}
    		else 
    			st1.push(c);	
    	}
    	for (char c : t.toCharArray()) {
    		if (c == '#') {
    			if (!st2.isEmpty())
    				st2.pop();
    		}
    		else 
    			st2.push(c);	
    	}
    	String newS = st1.toString();
    	String newT = st2.toString();
    	return newS.equals(newT) ? true : false;
    }
	public static void main(String[] args) {
		BackSpaceStringCompare test = new BackSpaceStringCompare();
		System.out.println(test.backspaceCompare("ab#c", "ad#c"));
		System.out.println(test.backspaceCompare("ab##", "c#d#"));
		System.out.println(test.backspaceCompare("a##c", "#a#c"));
		System.out.println(test.backspaceCompare("a#c", "b"));
		System.out.println(test.backspaceCompare2("ab#c", "ad#c"));
		System.out.println(test.backspaceCompare2("ab##", "c#d#"));
		System.out.println(test.backspaceCompare2("a##c", "#a#c"));
		System.out.println(test.backspaceCompare2("a#c", "b"));
	}
}
