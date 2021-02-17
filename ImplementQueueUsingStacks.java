import java.util.Stack;

class MyQueue {
	private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();
    
    public void stackShift() {
        if (!st2.empty())
            return;
        while (!st1.empty()) 
            st2.push(st1.pop());
    }

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	stackShift();
//        if (st2.empty()) {
//        	while (st1.empty())
//        		st2.push(st1.pop());
//        }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	stackShift();
//        if (st2.empty()) {
//        	while (st1.empty())
//        		st2.push(st1.pop());
//        }
        return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

public class ImplementQueueUsingStacks {
	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);		
		int param_2 = obj.peek();
		int param_3 = obj.pop();
		boolean param_4 = obj.empty();
		System.out.println(param_2);
		System.out.println(param_3);
		System.out.println(param_4);
	}

}
