
public class SwapNodesInPairs {
	public static void main(String[] args) {
		System.out.println();	
	}
	// head = 1-2-3-4
	public ListNode swapPairs(ListNode head) {
		
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		
		dummy.next = head; // pre = dummy = 0-1-2-3-4
		while (pre.next != null && pre.next.next != null) {
			ListNode temp = pre.next.next; // temp = 2-3-4; temp = 4
			pre.next.next = temp.next; // pre = 0-1-3-4; pre = 1-3
			temp.next = pre.next; // temp = 2-1-3-4; temp = 4-3
			pre.next = temp; // pre = 0-2-1-3-4; pre = 1-4-3
			pre = temp.next; // pre = 1-3-4; pre = 3;
		}
		return dummy.next;
	}
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = head.next;
		head.next = swapPairs2(head.next.next);
		temp.next = head;
		return temp;
	}
}
