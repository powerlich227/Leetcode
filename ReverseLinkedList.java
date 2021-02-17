
public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = null;
		System.out.println(reverseList2(a));
	}
	// iteration
	public ListNode reverseList(ListNode head) {
		ListNode pre = new ListNode(0);
		ListNode cur = head;
        pre.next = head;

		while(cur != null || cur.next != null) { 
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}		
		return pre.next;
		
//		ListNode pre = null;
//		ListNode cur = head;
//
//		while(cur != null) { 
//			ListNode temp = cur.next;
//			cur.next = pre;
//			pre = cur;
//			cur = temp;
//		}		
//		return pre;
	}
	// recursion
	public static ListNode reverseList2(ListNode head) {
//		System.out.println("1 " + head.val);
		if (head == null || head.next == null)
			return head;
		ListNode cur = reverseList2(head.next);
//		System.out.println("2 " + head.val + cur.val);
//		if (cur.next != null)
//			System.out.println("2 " + head.val + cur.val + cur.next.val);
//		if (cur.next != null && cur.next.next != null)
//			System.out.println("2 " + head.val + cur.val + cur.next.val + cur.next.next.val);
		head.next.next = head;
		System.out.println("3 " + cur.val);
//		if (cur.next != null)
//			System.out.println("3 " + cur.val + cur.next.val);
//		if (cur.next != null && cur.next.next != null)
//			System.out.println("3 " + cur.val + cur.next.val + cur.next.next.val);
//		if (cur.next != null && cur.next.next != null && cur.next.next.next != null)
//			System.out.println("3 " + cur.val + cur.next.val + cur.next.next.val + cur.next.next.next.val);
//		if (cur.next.next.next.next != null)
//			System.out.println("3 " + cur.next.next.next.next.val);
		head.next = null;
		System.out.println("4 " + cur.val);
//		if (cur.next != null)
//			System.out.println("4 " + cur.val + cur.next.val);
//		if (cur.next != null && cur.next.next != null)
//			System.out.println("4 " + cur.val + cur.next.val + cur.next.next.val);
		return cur;
	}

}
