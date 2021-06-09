/*
 * LeetCode 705 Easy
 * 
 * Design HashSet
 */
public class DesignHashSet {
	boolean[] data;
	public DesignHashSet() {
		data = new boolean[10000];
	}
	public void add(int key) {
		int index = Integer.hashCode(key) % data.length;
		data[index] = true;
		
	}
	public void remove(int key) {
		int index = Integer.hashCode(key) % data.length;
		data[index] = false;
	}
	public boolean contains(int key) {
		int index = Integer.hashCode(key) % data.length;
		return data[index] == true;
	}
}
