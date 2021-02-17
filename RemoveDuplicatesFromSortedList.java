
public class RemoveDuplicatesFromSortedList {
	public static void main(String args[]) {
		System.out.println();
	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode node = head;
		while (node != null && node.next != null) {
			if (node.val == node.next.val)
				node.next = node.next.next;
			else
				node = node.next;
		}
		return head;
	}
}
