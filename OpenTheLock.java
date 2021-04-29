import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * LeetCode 752 Medium
 * 
 * Open the Lock
 * 
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. 
The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock,
return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".

Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".

Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.

Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
 */
public class OpenTheLock {
	// BFS
	public int openLock(String[] deadends, String target) {
		HashSet<String> visit = new HashSet<>();
		for (String deadend : deadends)
			visit.add(deadend);
		if (visit.contains("0000"))
			return -1;
		visit.add("0000");
		Queue<String> q = new LinkedList<>();
		q.offer("0000");
		
		int res = 0;
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				String cur = q.poll();

				if (cur.equals(target))
					return res;
//				visit.add(cur);
				for (int j = 0; j < cur.length(); j++) {
					String up = plus(cur, j);
					if (!visit.contains(up)) {
						q.offer(up);
						visit.add(up);
					}
					String down = minus(cur, j);
					if (!visit.contains(down)) {
						q.offer(down);
						visit.add(down);
					}
				}
			}
			res++;
		}
		return -1;
	}
	// optimized BFS with double hashset
	public int openLock2(String[] deadends, String target) {
		HashSet<String> visit = new HashSet<>();
		for (String deadend : deadends)
			visit.add(deadend);
		if (visit.contains("0000"))
			return -1;
		visit.add("0000");
		
		HashSet<String> q1 = new HashSet<>();
		HashSet<String> q2 = new HashSet<>();
		q1.add("0000");
		q2.add(target);
		
		int res = 0;
		while (!q1.isEmpty() && !q2.isEmpty()) {
			HashSet<String> temp = new HashSet<>();
			if (q1.size() > q2.size()) {
				HashSet<String> temp2 = q1;
				q1 = q2;
				q2 = temp2;
			}
			
			for (String cur : q1) {
				if (q2.contains(cur))
					return res;
				
				visit.add(cur);
				for (int j = 0; j < cur.length(); j++) {
					String up = plus(cur, j);
					if (!visit.contains(up)) {
						temp.add(up);
					}
					String down = minus(cur, j);
					if (!visit.contains(down)) {
						temp.add(down);
					}
				}
			}
			res++;
			q1 = q2;
			q2 = temp;
		}
		return -1;
	}
	public String plus(String s, int i) {
		char[] c = s.toCharArray();
		if (c[i] == '9')
			c[i] = '0';
		else
			c[i]++;
		return new String(c);
	}
	public String minus(String s, int i) {
		char[] c = s.toCharArray();
		if (c[i] == '0')
			c[i] = '9';
		else
			c[i]--;
		return new String(c);
	}
	public static void main(String[] args) {
		String[] deadends = {"0201","0101","0102","1212","2002"}, deadends2 = {"8888"};
		String[] deadends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		String[] deadends4 = {"0000"};
		String target = "0202", target2 = "0009", target3 = "8888", target4 = "8888";
		
		OpenTheLock test = new OpenTheLock();
		System.out.println(test.openLock2(deadends, target));
		System.out.println(test.openLock2(deadends2, target2));
		System.out.println(test.openLock2(deadends3, target3));
		System.out.println(test.openLock2(deadends4, target4));
	}

}
