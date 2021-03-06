import java.util.HashSet;
/*
 * LeetCode 141 Easy
 * 
 * Linked List Cycle
 * 
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

 
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:
The number of the nodes in the list is in the range [0, 104].
-10^5 <= Node.val <= 10^5
pos is -1 or a valid index in the linked-list.
 */
public class LinkedListCycle {
	public static void main() {
		System.out.println();
	}
	// HashSet
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> s = new HashSet<>();
		while (head != null) {
			if (s.contains(head))
				return true;
			else
				s.add(head);
			head = head.next;
		}
		return false;	
	}
	// two pointers
	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
