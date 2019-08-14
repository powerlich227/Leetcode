
public class ReverseBits {
	public static void main(String args[]) {
		int n1 = 43261596; // 964176192
		int n2 = -3; // -1073741825
		ReverseBits test = new ReverseBits();
		System.out.println(test.reverseBits(n1));
		System.out.println(test.reverseBits(n2));
	}
	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0)
				res += 1 << 31 - i;
		}
		return res;	
	}
}
