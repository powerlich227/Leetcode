/*
 * LeetCode 21 Easy
 * 
 * Merge Two Sorted Lists
 * 
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []

Example 3:
Input: l1 = [], l2 = [0]
Output: [0]
 
Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		System.out.println("test");		
	}
	// Iteration
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-101);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}
			else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null)
			cur.next = l1;
		else
			cur.next = l2;
		
		return dummy.next;
	}
	
	// Recursion
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) 
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		}
		else {
			l2.next = MergeTwoLists2(l1, l2.next);
			return l2;
		}
	}
}