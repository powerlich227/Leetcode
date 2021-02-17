import java.util.*;

public class MergeKSortedLists {
	public static void main(String[] args) {
		System.out.println();
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		
		// lambda expression in java 8
		// comparator (x,y) return x - y
 		Queue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
		
		for (ListNode list : lists) {
			if (list != null) {
				pq.offer(list);
			}
		}
		ListNode dummy = new ListNode(0), cur = dummy;
		while (!pq.isEmpty()) {
			ListNode list = pq.poll();
			cur.next = list;
			cur = cur.next;
			if (cur.next != null)
				pq.offer(cur.next);
			
		}
		return dummy.next;
	}

}
