
public class ConvertSortedListToBinarySearchTree {
	public static void main(String[] args) {
		System.out.println();
	}
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		return helper(head, null);
	}
	public TreeNode helper(ListNode head, ListNode tail) {
		if (head == tail)
			return null;
		ListNode slow = head, fast = head;
		while(fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode cur = new TreeNode(slow.val);
		cur.left = helper(head, slow);
		cur.right = helper(slow.next, tail);
		return cur;
	}

}
