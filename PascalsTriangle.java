import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		System.out.println();
	}
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (numRows == 0)
    		return res;
		List<Integer> first = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        first.add(1);
		res.add(first);
    	for (int i = 1; i < numRows; i++) {
    		List<Integer> cur = new ArrayList<>();
    		cur.add(1);
    		for (int j = 0; j < pre.size() - 1; j++)
    			cur.add(pre.get(j) + pre.get(j + 1));
    		cur.add(1);
            pre = cur;
    		res.add(cur);
    	}
        return res;
    }
}
