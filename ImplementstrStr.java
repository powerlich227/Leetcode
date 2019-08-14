
public class ImplementstrStr {
	public static void main(String[] args) {
		System.out.println("test");
	}
    public int strStr(String haystack, String needle) {
    	int m, n, j;
    	m = haystack.length();
    	n = needle.length();
    	if (m < n)
    		return -1;    	
    	for (int i = 0; i <= m - n; i++) {
    		for (j = 0; j < n; j++) {
    			if (haystack.charAt(i + j) != needle.charAt(j))
    				break;
    		}
    		if (j == n)
    			return i;
    	}   	
    	if (needle.isEmpty())
    		return 0;
    	return -1;
    }
}
