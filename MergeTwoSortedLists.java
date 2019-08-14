
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		System.out.println("test");		
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode temp = node;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				temp.next = l1;
				l1 = l1.next;
			}
			else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if (l1 != null)
			temp.next = l1;
		else
			temp.next = l2;
		
		return node.next;
	}
}