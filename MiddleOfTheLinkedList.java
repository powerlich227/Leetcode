/*
 * LeetCode 876 Easy
 * 
 * Middle of the LinkedList
 * 
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

 
Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 */
public class MiddleOfTheLinkedList {
	// Two Pointers: slow and fast
	// slow = slow.next, fast = fast.next.next
	// time: O(n) space: O(1)
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
