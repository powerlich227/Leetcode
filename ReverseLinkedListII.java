/*
 * LeetCode 92 Medium
 * 
 * Reverse LinkedList II
 * 
 * Given the head of a singly linked list and two integers left and right where left <= right, 
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
 
Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 */
public class ReverseLinkedListII {
	public static void main(String[] args) {
		System.out.println();
	}
	// Iteration 
	// head ... reverse part ... tail
	public ListNode reverseBetween(ListNode head, int m, int n) {		
		ListNode pre = null, cur = head, next;		
		for (int i = 1; i < m; i++) {
			pre = cur;
			cur = cur.next;
		}
		ListNode temp1 = pre, temp2 = cur;
		for (int i = m; i < n; i++) { //reverse
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		if (m > 1) // connect head
			temp1.next = pre;
		else 
			head = pre;
		temp2.next = cur; // connect tail
		return head;
	}
	
	// Recursion
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if (m == 1)
			return reverseN(head, n);
		head.next = reverseBetween2(head.next, m - 1, n - 1);		
		return head;
	}
	ListNode successor = null;
	public ListNode reverseN(ListNode head, int n) {
		if (n == 1) {
			successor = head.next;
			return head;
		}
		ListNode last = reverseN(head.next, n - 1);
		head.next.next = head;
		head.next = successor;
		return last;
	}
}
