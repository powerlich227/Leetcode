import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * LeetCode 652 Medium
 * 
 * Find Duplicate Subtrees
 * 
 * Given the root of a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with the same node values.

Example 1:
Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]

Example 2:
Input: root = [2,1,1]
Output: [[1]]

Example 3:
Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 */
public class FindDuplicateSubtrees {
	List<TreeNode> res = new ArrayList<>();
	Map<String, Integer> memo = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return res;
    }
    public String helper(TreeNode root) {
    	if (root == null)
    		return "#";
    	String left = helper(root.left);
    	String right = helper(root.right);   	
    	String subTree = left + "," + right + "," + root.val;
    	
    	if (memo.getOrDefault(subTree, 0) == 1)
    		res.add(root);  	
    	memo.put(subTree, memo.getOrDefault(subTree, 0) + 1);
    	
    	return subTree;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
