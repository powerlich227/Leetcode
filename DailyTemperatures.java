import java.util.Arrays;
import java.util.Stack;

/*
 * LeetCode 739 Medium
 * 
 * Daily Temperatures
 * 
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 
Constraints:

1 <= temperatures.length <= 10^5
30 <= temperatures[i] <= 100 
 */
public class DailyTemperatures {
	// Stack
    public int[] dailyTemperatures(int[] temperatures) {
    	int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
        	while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
        		st.pop();
        	res[i] = st.isEmpty() ? 0 : st.peek() - i;
        	st.push(i);
        }
        return res;
    }
	public static void main(String[] args) {
		DailyTemperatures test = new DailyTemperatures();
		System.out.println(Arrays.toString(test.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
		System.out.println(Arrays.toString(test.dailyTemperatures(new int[] {30,40,50,60})));
		System.out.println(Arrays.toString(test.dailyTemperatures(new int[] {30,60,90})));
	}
}
