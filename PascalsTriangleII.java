import java.util.ArrayList;
import java.util.List;
/*
 * LeetCode 119 Easy
 * 
 * Pascal's Triangle II
 * 
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]
 
Constraints:

0 <= rowIndex <= 33
 
Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class PascalsTriangleII {
	public static void main(String[] args) {
		PascalsTriangleII test = new PascalsTriangleII();
		System.out.println(test.getRow(3));
		System.out.println(test.getRow(0));
		System.out.println(test.getRow(1));
	}
	// recursion
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0)
        	return res;
        List<Integer> pre = getRow(rowIndex - 1);
        for (int i = 0; i < pre.size() - 1; i++) {
        	res.add(pre.get(i) + pre.get(i + 1));
        }
        res.add(1);
        return res;
    }
}
