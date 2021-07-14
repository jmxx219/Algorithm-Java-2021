package dynamic;

import java.util.Arrays;

public class CoinChange_322 {
	public static int INF = 987654321;
	public static int coinChange(int amount, int[] memo, int[] coins) {
        if(amount < 0) return INF;
        if(amount == 0) return 0;
        if(memo[amount]!= -1) return memo[amount];
        
        int ret = INF;
        for(int x : coins) {
        	ret = Math.min(ret, coinChange(amount - x, memo, coins)+1);
        }
        memo[amount] = ret;
		return ret;
    }
	public static int coinChange(int[] coins, int amount) {
		int[] memo = new int[amount+1];
		Arrays.fill(memo, -1);
		int ret = coinChange(amount, memo, coins);
		if(ret == INF) return -1;
		return ret;
    }
}
