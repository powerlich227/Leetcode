import java.util.*;
/*
 * LeetCode 199 Easy
 * 
Given the root of a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 
 */
public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		System.out.println();
	}
	
	/*
	 * BFS: Queue
	 * Q102 Binary Tree Level Order Traversal
	 * Q103 Binary Tree Zig Zag Order Traversal
	 */
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == size - 1)
                    res.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
        }
        return res;
	}
	// DFS
    private List<Integer> res = new ArrayList<>();
    private int depth = 0;
	public List<Integer> rightSideView2(TreeNode root) {
		dFS(root);
		return res;
	}
	private void dFS(TreeNode root) {
		if (root == null)
			return;
		depth++;
		if (res.size() < depth)
			res.add(root.val);
		dFS(root.right);
		dFS(root.left);
		depth--;
	}
}
