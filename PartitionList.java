
public class PartitionList {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, cur = head;
		while (pre.next != null && pre.next.val < x)
			pre = pre.next;
		cur = pre;
		while (cur.next != null) {
			if (cur.next.val < x) {
				ListNode temp = cur.next;
				cur.next = temp.next;
				temp.next = pre.next;
				pre.next = temp;
				pre = pre.next;
			}
			else
				cur = cur.next;
		}
		return dummy.next;
	}

}
