import java.util.Random;

/*
 * LeetCode 382 Medium
 * 
 * Linked List Random Node
 * 
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:
Solution(ListNode head) Initializes the object with the integer array nums.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.
 
Example 1:
Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 
Constraints:
The number of nodes in the linked list will be in the range [1, 10^4].
-10^4 <= Node.val <= 10^4
At most 104 calls will be made to getRandom.
 
Follow up:
What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?
 */
public class LinkedListRandomNode {
	ListNode head;
	Random r;
	
	// Reservoir Sampling
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
		r = new Random();
	}
	public int getRandom() {
		int cnt = 0, res = Integer.MIN_VALUE;
		ListNode cur = head;
		while (cur != null) {
			cnt++;
			if (r.nextInt(cnt) == 0)
				res = cur.val;
			cur = cur.next;
		}
		return res;
	}
}
