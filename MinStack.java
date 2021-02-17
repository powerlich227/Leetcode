import java.util.Stack;

public class MinStack {
	public static void main(String[] args) {
		System.out.println();
	}

    /** initialize your data structure here. */
	private Stack<Integer> s1 = new Stack<> ();
	private Stack<Integer> s2 = new Stack<> ();
	private int minVal = Integer.MAX_VALUE;
	
	public MinStack() {
		
	}
	public void push(int x) {
		s1.push(x);
		if (s2.isEmpty() || s2.peek() >= x)
			s2.push(x);
	}
	public void push2(int x) {
		if (x <= minVal) {
			s1.push(minVal);
			minVal = x;
		}
		s1.push(x);
	}
	public void pop() {
		if (s2.peek().equals(s1.peek()))
			s2.pop();
		s1.pop();
	}
	public void pop2() {
		if (s1.pop() == minVal)
			minVal = s1.pop();
	}
	public int top() {
		return s1.peek();
	}
	public int getMin() {
		return minVal;
	}
}
