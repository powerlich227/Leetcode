import java.util.*;
/*
 * LeetCode 234 Easy
 * 
 * Palindrom LinkedList
 * 
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	public static void main(String[] args) {
		System.out.println();
	}
	// stack
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head, fast = head;
		Stack<Integer> stack = new Stack<>();
		while (fast.next != null && fast.next.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next == null)
			stack.pop();
		
		ListNode mid = slow.next;
		while (mid.next != null) {
			int temp = stack.pop();
			if (temp != mid.val)
				return false;
			mid = mid.next;
		}
		return true;
	}
	// post-order traverse Linked List
	ListNode left;
	public boolean isPalindrome2(ListNode head) {
		left = head;
		return traverse(head);
	}
	public boolean traverse(ListNode right) {
		if (right == null)
			return true;
		boolean res = traverse(right.next);
		
		res = res && (left.val == right.val);
		left = left.next;
		return res;
	}
	// T:O(n) S:O(1)
	public boolean isPalindrome3(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = slow.next; // the node after the mid-node
		
		ListNode left = head, right = reverse(slow);	
		while (right != null) {
			if (left.val != right.val)
				return false;
			left = left.next;
			right = right.next;
		}
		return true;
	}
	public ListNode reverse(ListNode head) {
//		//Recursion
//		if (head.next == null)
//			return head;
//		ListNode last = reverse(head.next);
//		head.next.next = head;
//		head.next = null;
//		return last;
		
		//Iteration
		ListNode pre = null, cur = head, next = head;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
