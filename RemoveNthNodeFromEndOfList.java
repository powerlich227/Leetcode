
public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
//		int n = 5;
//		ListNode res = removeNthFromEnd(a, n);
//		System.out.println(res.val);
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		ListNode pre = head, cur = head;
		for (int i = 0; i < n; i++)
			cur = cur.next;
		if (cur == null)
			return head.next;
		while (cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}

		pre.next = pre.next.next;
		System.out.println(pre);
		return head;
	}
	// dummy node w/o checking if head node will be deleted
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, cur = dummy;
		for (int i = 0; i < n; i++)
			cur = cur.next;
		while (cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}
		pre.next = pre.next.next;
		return dummy.next;
	}
	// not in one pass
	public ListNode removeNthFromEnd3(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		// get ListNode's length
		ListNode cur = head;
		int length = 0;
		while (cur != null) {
			cur = cur.next;
			length++;
		}
		length -= n;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		cur = dummy;
		while (length > 0) {
			cur = cur.next;
			length--;
		}
		cur.next = cur.next.next;
		return dummy.next;
	}

}
