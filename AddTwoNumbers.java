
public class AddTwoNumbers {
	public static void main(String[] args) {
		System.out.println();
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
//        	int digit1;
//        	if (l1 == null)
//        		digit1 = 0;
//        	else
//        		digit1 = l1.val;
        	int digit1 = l1 == null ? 0 : l1.val;
        	int digit2 = l2 == null ? 0 : l2.val;
        	int sum = digit1 + digit2 + carry;
        	carry = sum >= 10 ? 1 : 0;
        	cur.next = new ListNode(sum % 10);
        	cur = cur.next;
        	if (l1 != null)
        		l1 = l1.next;
        	if (l2 != null)
        		l2 = l2.next;
        }
        if (carry == 1) 
        	cur.next = new ListNode(1);
        return dummy.next;
    }
}
