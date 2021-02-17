

public class ReorderList {
	public static void main(String[] args) {
		System.out.println();
	}
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next; // head ... slow -> mid(last) ... pre(null)
		slow.next = null;
		ListNode last = mid, pre = null;
		while (last != null) {
			ListNode temp = last.next;
			last.next = pre;
			pre = last;
			last = temp;
		}
		// head ... slow -> pre ... last
		while (head != null && pre != null) {
			ListNode temp = head.next;
			head.next = pre;
			pre = pre.next;
			head.next.next = temp;
			head = temp;
		}
	}
}
