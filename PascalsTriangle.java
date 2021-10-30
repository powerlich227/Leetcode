import java.util.ArrayList;
import java.util.List;
/*
 * LeetCode 118 Easy
 * 
 * Pascal's Triangle
 * 
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
 
Constraints:
1 <= numRows <= 30
 */
public class PascalsTriangle {
	public static void main(String[] args) {
		PascalsTriangle test = new PascalsTriangle();
		System.out.println(test.generate(5));
		System.out.println(test.generate(1));
	}
	// dp
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<>();
//    	if (numRows == 0)
//    		return res;
		List<Integer> first = new ArrayList<>();
        first.add(1);
		res.add(first);

        List<Integer> pre = new ArrayList<>();
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
