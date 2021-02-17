
public class ReverseLinkedListII {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		dummy.next = head;
		
		for (int i = 0; i < m - 1; i++)
			pre = pre.next;
		ListNode cur = pre.next;
		
		for (int i = m; i < n; i++) {
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		return dummy.next;
	}

}
