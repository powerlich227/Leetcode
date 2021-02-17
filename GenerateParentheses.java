import java.util.*;

public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println();
	}
	// DFS 1
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String> ();
		helper(n, n, "", res);
		return res;
	}
	public void helper(int left, int right, String out, List<String> res) {
		if (left < 0 || right < 0 || left > right) 
			return;
		if (left == 0 && right == 0) {
			res.add(out);
			return;
		}
		helper(left - 1, right, out + "(", res);
		helper(left, right - 1, out + ")", res);
	}
	// "(" + left-part + ")" + right-part
	public List<String> generateParenthesis2(int n) {
		List<String> res = new ArrayList<String> ();
		if (n == 0)
			res.add("");
		else {
			for (int i = 0; i < n; i++) {
				for (String left : generateParenthesis2(i)) {
					for (String right : generateParenthesis2(n - i - 1))
						res.add("(" + left + ")" + right);
				}
			}
		}
		return res;
	}
}
