
public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		System.out.println();
	}
	public int titleToNumber(String s) {
		int n = s.length() - 1;
		int res = 0;
		int temp = 1;
		for (int i = n; i >= 0; i--) {
			res += (s.charAt(i) - 'A' + 1) * temp;
			temp *= 26;
		}
		return res;
	}
}
