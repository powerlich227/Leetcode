
public class Sqrt {
	public static void main(String[] args) {
		System.out.println();
	}
	public int mySqrt(int x) {
		long res = x;
		while (res * res > x) // to prevent over the limit of int type
			res = (res + x / res) / 2;
		return (int) res;
	}
	public int mySqrt2(int x) {
		if (x == 0)
			return 0;
		double pre = 0;
		double res = 1;
		while (res != pre) {
			pre = res;
			res = (res + x / res) / 2;
		}
		return (int) res;
	}
}
