import java.util.*;
public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println();
	}
	/*
	 * '.' Matches any single character
	 * '*' Matches zero or more of the preceding element.
	 */
	
	// Recursive
	public boolean isMatch(String s, String p) {
		if (p.isEmpty())
			return s.isEmpty();
		if (p.length() == 1)
			return (s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)));
		if (p.charAt(1) != '*') {
			if (s.isEmpty())
				return false;
			return (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
		}
		// p[1]='*' and s[0]=p[0]
		while (!s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
			if (isMatch(s, p.substring(2)))
				return true;
			s = s.substring(1); // e.g. s="aab", p="c*a*b", skip s[0],s[1] to s[2]
		}
		/* for the case of s[0]!=p[0]
		 * skip to p[2...]
		 */		
		return isMatch(s, p.substring(2));
	}
	
	// to be continued
	public boolean isMatch2(String s, String p) {
		if (p.isEmpty())
			return s.isEmpty();
		if (p.length() > 1 && p.charAt(1) == '*')
			return isMatch2(s, p.substring(2)) || (s.length() >= 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) && isMatch2(s.substring(1), p);
		else
			return s.length() >= 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) && isMatch2(s.substring(1), p);
		
	}
}
