/*
 * LeetCode 24 Medium
 * 
 * Swap Nodes in Pairs
 * 
Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]
 
Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
public class SwapNodesInPairs {
	public static void main(String[] args) {
		System.out.println();	
	}
	// Recursion
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode temp = head.next;
		head.next = swapPairs(head.next.next);
		temp.next = head;
		return temp;
	}
	// Iteration
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = head.next;
		head.next = swapPairs2(head.next.next);
		temp.next = head;
		return temp;
	}
}
