import java.util.*;
/*
 * LeetCode 116 Medium
 * 
 * Populating Next Right Pointers in Each Node
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 

The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]

Explanation: Given the above perfect binary tree (Figure A), 
your function should populate each next pointer to point to its next right node, just like in Figure B. 
The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Follow up:
You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
		System.out.println();
	}
	// Recursion 1
	public Node connect(Node root) {
		if (root == null)
			return null;
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null) {
			if (root.next != null)
				root.right.next = root.next.left;
//			else
//				root.right.next = null;
		}
		connect(root.left);
		connect(root.right);
		return root;
	}
	// Recursion 2
	public Node connect4(Node root) {
		if (root == null)
			return null;
		connectTwoNode(root.left, root.right);
		return root;
	}
	public void connectTwoNode(Node node1, Node node2) {
		if (node1 ==  null || node2 == null)
			return;
		node1.next = node2;
		
		connectTwoNode(node1.left, node1.right);
		connectTwoNode(node1.right, node2.left);
		connectTwoNode(node2.left, node2.right);
	}
	// iteration -- queue
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
