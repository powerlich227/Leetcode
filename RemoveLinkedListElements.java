/*
 * LeetCode 203 Easy
 * 
 * Remove Linked List Elements
 * 
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.


Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 10^4].
1 <= Node.val <= 50
0 <= val <= 50
 */
public class RemoveLinkedListElements {
	public static void main(String[] args) {
		System.out.println();
	}
	// recursion
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		if (head.val == val)
			return head.next;
		return head;
	}
	// iteration
	public ListNode removeElements2(ListNode head, int val) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		
		while(pre.next != null) {
			if (pre.next.val == val) {
				pre.next = pre.next.next;
			}
			else
				pre = pre.next;
		}		
		return dummy.next;
	}

}
