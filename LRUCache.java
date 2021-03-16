import java.util.*;
public class LRUCache {
	int cap = 0;
	LRUNode head = new LRUNode(0, 0);
	LRUNode tail = new LRUNode(0, 0);
	Map<Integer, LRUNode> map = new HashMap<>();
	
	public LRUCache(int capacity) {
		cap = capacity;
		head.next = tail;
		tail.pre = head;
	}
	
	// O(1)
	public int get(int key) {
		if (map.containsKey(key)) {
			LRUNode node = map.get(key);
			remove(node);
			addFirst(node);
			return node.val;
		}
		return -1;	
	}
	
	// O(1)
	public void put(int key, int value) {
		if (map.containsKey(key))
			remove(map.get(key));
		if (map.size() == cap)
			remove(tail.pre);
		addFirst(new LRUNode(key, value));
	}
	
	public void remove(LRUNode cur) {
		map.remove(cur.key);
		cur.pre.next = cur.next;
		cur.next.pre = cur.pre;
	}
	
	public void addFirst(LRUNode cur) {
		map.put(cur.key, cur);
		LRUNode temp = head.next;
		head.next = cur;
		cur.pre = head;
		cur.next = temp;
		temp.pre = cur;
	}
	
	// Double Linked List
	class LRUNode {
		int key, val;
		LRUNode pre, next;
		LRUNode(int _key, int _val) {
			key = _key;
			val = _val;
		}
	}
}
