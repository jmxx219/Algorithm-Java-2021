package dynamic;

public class BestTimetoBuyandSellStock_121 {

	public static  int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;

        int min = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

}
