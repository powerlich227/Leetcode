/*
 * LeetCode 148 Medium
 * 
 * Sort List
 * 
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []
 
Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-10^5 <= Node.val <= 10^5
 
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 */
public class SortList {
	public static void main(String[] args) {
		System.out.println();
	}
	// Merge & Sort
	// Slow & Fast Pointers
	// Time: O(nlogn), Space: O(logn)
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head, temp = head;
		while (fast != null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		temp.next = null;
		return helper(head, slow);
	}
	
	// Q21: Merge two sorted list
	public ListNode helper (ListNode l1, ListNode l2) {
		if (l1 == null) 
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = helper(l1.next, l2);
			return l1;
		}
		else {
			l2.next = helper(l1, l2.next);
			return l2;
		}
	}
}
