
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		System.out.println("test");		
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}
			else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null)
			cur.next = l1;
		else
			cur.next = l2;
		
		return dummy.next;
	}
	
	// Recursion
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
//		if (l1 == null) 
//			return l2;
//		if (l2 == null)
//			return l1;
//		if (l1.val < l2.val) {
//			l1.next = mergeTwoLists2(l1.next, l2);
//			return l1;
//		}
//		else {
//			l2.next = MergeTwoLists2(l1, l2.next);
//			return l2;
//		}
		if (l1 == null || (l2 != null && l2.val <= l1.val)) {
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		if (l1 != null)
			l1.next = mergeTwoLists2(l1.next, l2);
		return l1;
	}
}