/*
 * LeetCode 19 Meidum
 * 
 * Remove Nth Node From End of List
 * 
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 
Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
	}
	// Two Pointers, pre and cur
	// cur: to end
	// pre: to n + 1 from end of list
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		ListNode pre = head, cur = head;
		for (int i = 0; i < n; i++)
			cur = cur.next;
		if (cur == null) // remove head
			return head.next;
		while (cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}
		pre.next = pre.next.next;
		System.out.println(pre);
		return head;
	}
}
