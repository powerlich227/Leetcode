
public class ReverseNodesInKGroups {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 0)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, cur = head;
		int i = 1;
		while (cur.next != null) {
			if (i % k == 0) {
				pre = helper(pre, cur.next); // from pre-1-2-3(cur)-4(next) to 3-2-1(pre)-4
				cur = pre.next;
			}
			else
				cur = cur.next;
			i++;
		}
		
		return dummy.next;
		
	}
	// helper: reverse 1 group
	public ListNode helper(ListNode pre, ListNode next) {
		ListNode last = pre.next, cur = last.next; // 0(pre)-1(last)-2(cur)-3-4(next) to 3-2-1(last)-4(next/cur)
		while (cur != next) {
			last.next = cur.next; // 0(pre)-1(last)-3-4(next)
			cur.next = pre.next; // 2(cur)-1(last)-3-4(next)
			pre.next = cur; // 0(pre)-2(cur)-1(last)-3-4(next)
			cur = last.next; // 3(cur)-4(next)
		}
		return last; // return the last-node as the pre-node of next group
	}
	public ListNode reverseKGroup2(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		ListNode cur = head;
		for (int i = 0; i < k; i++) {
			if (cur == null)
				return head;
			cur = cur.next;
		}
		ListNode newHead = helper2(head, cur); // newHead...head->cur
		head.next = reverseKGroup2(cur, k); //newHead...head->newHead...head->...
		return newHead;
		
	}
	public ListNode helper2(ListNode head, ListNode next) {
		ListNode newHead = next;
		while (head != next) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead; // res == tail...head
	}
}
