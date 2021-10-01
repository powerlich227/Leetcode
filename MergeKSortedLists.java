import java.util.*;
/*
 * LeetCode 23 Hard
 * 
 * Merge k Sorted Lists
 * 
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

 
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 

Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

 */
public class MergeKSortedLists {
	public static void main(String[] args) {
		System.out.println();
	}
	// pq
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		/***
		//lambda expression in java 8
		//comparator (x,y) return x.val - y.val
		
		Comparator<ListNode> camparator = new Comparator<>() {
			public int compare(ListNode x, ListNode y) {
				return (x.val - y.val);
		}
		Queue<ListNode> pq = new PriorityQueue<>(comparator);
		***/
 		Queue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val); 
		for (ListNode list : lists) {
			if (list != null) {
				pq.offer(list);
			}
		}
		ListNode dummy = new ListNode(-1), cur = dummy;
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
