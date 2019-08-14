
public class CountAndSay {
	public static void main(String args[]) {
		System.out.println("test");
	}
	public String countAndSay(int n) {
		if (n <= 0)
			return "";
		String string = "1";
		while (n > 1) {
			n--;
			String temp = "";
			for (int i = 0; i < string.length(); i++) {
				int count = 1;
				while (i + 1 < string.length() && 
						string.charAt(i) == string.charAt(i + 1)) {
					count++;
					i++;
				}
				temp += Integer.toString(count) + string.charAt(i);
			}
			string = temp;
		}	
		return string;
	}

}
