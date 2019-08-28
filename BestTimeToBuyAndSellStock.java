
public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		System.out.println();
	}
	public int maxProfit(int[] prices) {
		int res = 0;
		int minBuy = Integer.MAX_VALUE;
		for (int price : prices) {
			minBuy = Math.min(minBuy, price);
			res = Math.max(res, price - minBuy);
		}
		return res;
	}

}
