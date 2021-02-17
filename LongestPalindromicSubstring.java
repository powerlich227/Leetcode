
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String str = "babad";
		String t = "$#";
    	for (int i = 0; i < str.length(); i++) {
    		t = t + str.charAt(i) + "";
    		t = t + '#' + "";
    	}
    	int n = t.length(), id = 0, mx = 0, resId = 0, resMx = 0;
    	int[] p = new int[n];
    	for (int i = 2; i < n; i++) {
    		p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
	        while (i - p[i] >= 0 && i + p[i] < n && t.charAt(i + p[i]) == t.charAt(i - p[i])) {
	        	p[i]++;
	        }
	        if (mx < i + p[i]) {
	            mx = i + p[i];
	            id = i;
	        }
	        if (resMx < p[i]) {
	            resMx = p[i];
	            resId = i;
	        }
    	}
		System.out.println(resMx);   	
		System.out.println(resId);   	
		System.out.println(str.substring((resId - resMx) / 2, (resId + resMx - 2) / 2));

	}
    public String longestPalindrome(String s) {
    	if (s == null || s.length() == 0)
    		return "";
    	if (s.length() == 1)
    		return s;
    	int n = s.length(), start = 0, end = 0;

    	for (int i = 0; i < n; i++) {
    		int l1 = searchPalindrome(s, i, i);
    		int l2 = searchPalindrome(s, i, i + 1);
    		int length = Math.max(l1, l2);
    		if (length > end - start) {
    			start = i - (length - 1) / 2;
    			end = i + length / 2;
    		}
    	}
		return s.substring(start, end + 1);     
    }
    public int searchPalindrome(String s, int left, int right) {
    	while (left >= 0 && right < s.length() 
    			&& s.charAt(left) == s.charAt(right)) {
    		right ++;
    		left --;
    	}
    	return right - left - 1;
    }
    
    // Manacher's algorithm    
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0)
    		return "";
    	if (s.length() == 1)
    		return s;
        
    	String t = "$#";
    	for (int i = 0; i < s.length(); i++) {
    		t += s.charAt(i);
    		t += '#';
    	}
    	
    	int n = t.length(), id = 0, mx = 0, resId = 0, resMx = 0;
    	int[] p = new int[n];
    	for (int i = 3; i < n; i++) {
    		p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
	        while (i - p[i] >= 0 && i + p[i] < n && t.charAt(i + p[i]) == t.charAt(i - p[i])) {
	        	p[i]++;
	        }
	        if (mx < i + p[i]) {
	            mx = i + p[i];
	            id = i;
	        }
	        if (resMx < p[i]) {
	            resMx = p[i];
	            resId = i;
	        }
    	}
    	return s.substring((resId - resMx) / 2, (resId + resMx - 2) / 2);
    }
}
