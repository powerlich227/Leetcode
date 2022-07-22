/*
 * LeetCode 86 Medium
 * 
 * Partition List
 * 
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
 
Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
 */
public class PartitionList {
	public static void main(String[] args) {
		System.out.println();
	}
	// Two Pointers p1, p2;
	// p1: less, p2: greater or equal, p: head
	public ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(-101), dummy2 = new ListNode(-101);
		ListNode p1 = dummy1, p2 = dummy2, p = head;
		while (p != null) {
			if (p.val < x) {
				p1.next = p;
				p1 = p1.next;
			}
			else {
				p2.next = p;
				p2 = p2.next;
			}
			ListNode temp = p.next;
			p.next = null;
			p = temp;
		}
		p1.next = dummy2.next;
		return dummy1.next;
	}
}
