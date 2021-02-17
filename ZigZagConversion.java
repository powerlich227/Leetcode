
public class ZigZagConversion {
	public static void main(String[] args) {
		System.out.println();
	}
    public String convert(String s, int numRows) {
    	if (numRows <= 1)
    		return s;
        String res = "";
    	for (int i = 0; i < numRows; i++) {
    		for (int j = i; j < s.length(); j += 2 * numRows - 2) {
    			res += s.charAt(j);
    			int zigzag = j + 2 * numRows - 2 - 2 * i;
    			if (i != 0 && i != numRows - 1 && zigzag < s.length())
    				res += s.charAt(zigzag);
    		}
    	}     
        return res;
    }
    public String convert2(String s, int numRows) {
    	if (numRows <= 1)
    		return s;
    	String[] str = new String[numRows];
    	for (int i = 0; i< numRows; i++) {
    		str[i] = "";
    	}
    	int i = 0;
    	while (i < s.length()) {
    		for (int j = 0; j < numRows && i < s.length(); j++) 
    			str[j] += (s.charAt(i++)) ;
    		for (int j = numRows - 2; j > 0 && i < s.length(); j--)
    			str[j] += (s.charAt(i++));                
    	}
    	String res = "";
    	for (String st: str) {
    		res += st;
    	}
    	return res;
    }

}
