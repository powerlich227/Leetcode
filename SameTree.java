
public class SameTree {
	public static void main(String args[]) {
		TreeNode node1_1 = new TreeNode(1);
		TreeNode node1_2 = new TreeNode(2);
		TreeNode node1_3 = new TreeNode(3);
		node1_1.left = node1_2;
		node1_1.right = node1_3;
		TreeNode node2_1 = new TreeNode(1);
		TreeNode node2_2 = new TreeNode(2);
		TreeNode node2_3 = new TreeNode(3);
		node2_1.left = node2_2;
		node2_1.right = node2_3;
		SameTree test = new SameTree();
		System.out.println(test.isSameTree(node1_1, node2_1));
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
