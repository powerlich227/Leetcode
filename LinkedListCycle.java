import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
	public static void main() {
		System.out.println();
	}
	public boolean hasCycle(ListNode head) {
		Set<ListNode> s = new HashSet<>();
		while (head != null) {
			if (s.contains(head))
				return true;
			else
				s.add(head);
			head = head.next;
		}
		return false;	
	}
	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}
