
public class ExcelSheetColumnTitleII {
	public static void main(String[] args) {
		System.out.println();
	}
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			if (n % 26 == 0) {
				sb.append('Z');
				n -= 26;
			}
			else {
                sb.append((char)(n % 26 - 1 + 'A'));
				n -= n % 26;
			}
			n /= 26;
		}
		return sb.reverse().toString();
	}
	public String convertToTitle2(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append((char)(n % 26 + 'A'));
			n /= 26;
		}
		return sb.reverse().toString();
	}
}
