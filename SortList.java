
public class SortList {
	public static void main(String[] args) {
		System.out.println();
	}
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
	
	// Q21: merge two sorted list
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
