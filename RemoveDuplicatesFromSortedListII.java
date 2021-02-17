
public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode removeDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		// to avoid the head node is deleted, build a dummy node(-1) as the new head node
		ListNode dummy = new ListNode(-1); 
		dummy.next = head; 
		
		ListNode pre = dummy;
		while (pre.next != null) {
			ListNode cur = pre.next;
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next != cur)
				pre.next = cur.next;
			else
				pre = pre.next;
				
		}
		return dummy.next;
	}
}
