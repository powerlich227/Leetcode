/*
 * LeetCode 206 Easy
 * 
 * Reverse Linked List
 * 
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
 
Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 
Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = null;
		System.out.println(reverseList(a));
	}
	// iteration
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head, next = head;

		while(cur != null) { 
			next = cur.next; // update next
			cur.next = pre; // reverse cur
			pre = cur; // update pre
			cur = next; // update cur
		}		
		return pre;
	}
	// recursion
	public static ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode last = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
}
