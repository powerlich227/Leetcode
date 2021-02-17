import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
	public static void main(String[] args) {
		System.out.println();
	}
	public Node connect(Node root) {
		Node dummy = new Node(0, null, null, null), cur = dummy; // cur for node connection at next level.
		Node head = root;
		while (root != null) {
			if (root.left != null) {
				cur.next = root.left;
				cur = cur.next;
			}
			if (root.right != null) {
				cur.next = root.right;
				cur = cur.next;
			}
			root = root.next;
			// reach the end of this level
			if (root == null) {
				cur = dummy; 
				root = dummy.next; //  dummy.next == cur.next == first node of next level
				dummy.next = null;
			}
		}
		return head;
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
				if (cur.left != null) 
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
		}
		return root;
    }

}
