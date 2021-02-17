
public class RotateList {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		
		// only if k > head.size()
		int m = 0;
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
			m++;
		}
		k %= m;	
		
		ListNode slow = head, fast = head;
		for (int i = 0; i < k; i++) {
			if (fast != null)
				fast = fast.next;
		}
		if (fast == null)
			return head;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = head;
		fast = slow.next;
		slow.next = null;
		return fast;
	}

}
