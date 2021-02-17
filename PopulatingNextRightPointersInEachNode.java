import java.util.*;

public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
		System.out.println();
	}
	// iterative
	public Node connect(Node root) {
		if (root == null)
			return null;
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null) {
			if (root.next != null)
				root.right.next = root.next.left;
			else
				root.right.next = null;
		}
		connect(root.left);
		connect(root.right);
		return root;
	}
	// recursive -- queue
	public Node connect2(Node root) {
		if (root == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
            int m = queue.size();
			for (int i = 0; i < m; i++) {
				Node cur = queue.poll();
				if (i < m - 1)
					cur.next = queue.peek();
				if (cur.left != null) {
					queue.offer(cur.left);
					queue.offer(cur.right);
				}
			}
		}
		return root;
    }
	// constant extra space
	public Node connect3(Node root) {
		if (root == null)
			return null;
		Node start = root, cur = null;
		while (start.left != null) {
			cur = start;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null)
					cur.right.next = cur.next.left;
                cur = cur.next;
            }
			start = start.left;
		}
		return root;
    }
}
