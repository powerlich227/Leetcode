/*
 * ListCode 706 Design HashMap
 */
public class DesignHashMap {
	class MyHashMap {
	    ListNode[] data;
	    /** Initialize your data structure here. */
	    public MyHashMap() {
	    	data = new ListNode[10000];
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        int index = Integer.hashCode(key) % data.length;
	        ListNode cur = findElement(index, key);
	        
	        if (cur.next == null)
	            cur.next = new ListNode(key, value);
	        else
	            cur.next.val = value;
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        int index = Integer.hashCode(key) % data.length;
	        ListNode cur = findElement(index, key);
	        return cur.next == null ? -1 : cur.next.val;
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        int index = Integer.hashCode(key) % data.length;
	        ListNode cur = findElement(index, key);
	        
	        if (cur.next != null)
	            cur.next = cur.next.next;
	    }
	    
	    private ListNode findElement(int index, int key) {
	        if (data[index] == null)
	            return new ListNode(-1, -1);
	        ListNode cur = data[index];
	        while (cur.next != null && cur.next.key != key) {
	            cur = cur.next;
	        }
	        return cur;
	    }
	}

	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
}
