import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public static void main(String[] args) {
		System.out.println();
	}
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex == 0) {
        	res.add(1);
        	return res;
        }       
        List<Integer> pre = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
        	res = new ArrayList<>();
        	res.add(1);
        	for (int j = 0; j < pre.size() - 1; j++)
        		res.add(pre.get(j) + pre.get(j + 1));
        	res.add(1);
        	pre = res;
        }
        return res;
    }
}
