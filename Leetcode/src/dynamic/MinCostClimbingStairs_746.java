package dynamic;

import java.util.Arrays;

public class MinCostClimbingStairs_746 {
	public static int solve(int[] cost) { // Å×ºæ 1
		int memo[] = new int[cost.length + 1];
        
        for (int i = 2; i < memo.length; i++) {
            int takeOneStep = memo[i - 1] + cost[i - 1];
            int takeTwoSteps = memo[i - 2] + cost[i - 2];
            memo[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        
        return memo[memo.length - 1];
	}
	
	public static int minCostClimbingStairs2(int[] cost) { // Å×ºæ 2
	      int N = cost.length;
	      int[] memo = new int[N+2];
	      memo[1] = cost[0];
	      
	      for(int i=2; i<=N; i++) {
	         memo[i] = Math.min(memo[i-1], memo[i-2]) + cost[i-1];
	      }
	      memo[N+1] = Math.min(memo[N], memo[N-1]);
	      return memo[N+1];
	   }

	
    private static int minimumCost(int index, int[] cost, int[] memo) { // ¸Þ¸ðÀÌ
        if (index <= 1) return 0;
        
        if (memo[index] != -1) return memo[index];
        
        int a = cost[index-1] + minimumCost(index-1, cost, memo);
        int b = cost[index-2] + minimumCost(index-2, cost, memo);
        
        memo[index]  = Math.min(a, b);
        return memo[index];
    }
    
	public static int minCostClimbingStairs(int[] cost) {
		int[] memo = new int[cost.length+1];
		Arrays.fill(memo, -1);
        return minimumCost(cost.length, cost, memo);
    }    
	
	public static void main(String[] args) {
		int[] cost = {10, 15, 20};
		System.out.println(minCostClimbingStairs(cost));
	}

}
