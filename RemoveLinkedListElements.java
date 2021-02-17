
public class RemoveLinkedListElements {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		
		while(pre.next != null) {
			if (pre.next.val == val) {
				pre.next = pre.next.next;
			}
			else
				pre = pre.next;
		}		
		return dummy.next;
	}

}
