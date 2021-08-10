/*
 * LeetCode 25 Hard
 * 
 * Reverse Nodes in k-Group
 * 
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Example 3:
Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]

Example 4:
Input: head = [1], k = 1
Output: [1]
 
Constraints:
The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 
Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class ReverseNodesInKGroups {
	public static void main(String[] args) {
		System.out.println();
	}
	// iteration with const extra memory space
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 0)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, cur = head;
		int i = 1;
		while (cur.next != null) {
			if (i % k == 0) {
				pre = helper(pre, cur.next); // from pre-1-2-3(cur)-4(next) to 3-2-1(pre)-4
				cur = pre.next;
			}
			else
				cur = cur.next;
			i++;
		}
		return dummy.next;		
	}
	public ListNode helper(ListNode pre, ListNode next) {
		ListNode last = pre.next, cur = last.next; // 0(pre)-1(last)-2(cur)-3-4(next) to 3-2-1(last)-4(next/cur)
		while (cur != next) {
			last.next = cur.next; // 0(pre)-1(last)-3-4(next)
			cur.next = pre.next; // 2(cur)-1(last)-3-4(next)
			pre.next = cur; // 0(pre)-2(cur)-1(last)-3-4(next)
			cur = last.next; // 3(cur)-4(next)
		}
		return last; // return the last-node as the pre-node of next group
	}
	
	// recursion
	public ListNode reverseKGroup2(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		ListNode cur = head;
		for (int i = 0; i < k; i++) {
			if (cur == null)
				return head;
			cur = cur.next;
		}
		ListNode newHead = reverse(head, cur);
		head.next = reverseKGroup2(cur, k);
		return newHead;
	}
	// reverse [head, head2)
	public ListNode reverse(ListNode head, ListNode head2) {
		ListNode pre = null, cur = head, next = head;		
		while (cur != head2) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
