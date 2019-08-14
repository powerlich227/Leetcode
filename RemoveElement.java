
public class RemoveElement {
	public static void main() {
		int[] num1 = {3,2,2,3}; //2
		int[] num2 = {0,1,2,2,3,0,4,2}; //5
		int val1 = 3; 
		int val2 = 2;
		RemoveElement test = new RemoveElement();
		System.out.println(test.removeElement(num1, val1));
		System.out.println(test.removeElement(num2, val2));
	}
    public int removeElement(int[] nums, int val) {
    	int res = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != val) {
    			nums[res] = nums[i];
    			res++;
    		}
    	}	
		return res;   
    }
}
