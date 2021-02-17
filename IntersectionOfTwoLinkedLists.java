
public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int la = helper(headA);
		int lb = helper(headB);
		if(la >= lb) {
			for (int i = 0; i < la - lb; i++)
				headA = headA.next;
		}
		else {
			for (int j = 0; j < lb - la; j++)
				headB = headB.next;
		}
		while (headA != null && headB != null && headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		if (headA != null && headB != null)
			return headA;
		else
			return null;
	}
	public int helper(ListNode head) {
		int res = 0;
		while (head != null) {
			res++;
			head = head.next;
		}
		return res;
	}
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = (a != null) ? a.next : headB;
			b = (b != null) ? b.next : headA;
		}
		return a;
	}
}
