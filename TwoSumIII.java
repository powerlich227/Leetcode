import java.util.*;

public class TwoSumIII {
	public static void main(String[] args) {
		System.out.println();
	}
	private HashMap<Integer, Integer> e = new HashMap<Integer, Integer>();
	public void add(int number) {
		if (e.containsKey(number)) {
			e.put(number, e.get(number) + 1);
		}
		else
			e.put(number, 1);
//		e.put(number, e.getOrDefault(number, 0) + 1);
		
	}
	public boolean find(int value) {
		for (Integer key : e.keySet()) {
			int target = value - key;
			if (e.containsKey(target) && e.get(target) > 1) {
//				if (target == key && e.get(target) < 2)
//					continue;
				return true;
			}
		}
		return false;
	}
}
