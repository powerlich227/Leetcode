import java.util.*;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		System.out.println();
	}
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

}
