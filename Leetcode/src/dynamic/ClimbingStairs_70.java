package dynamic;

import java.util.Arrays;

public class ClimbingStairs_70 {

	public static int solve(int n, int[] memo) {
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(memo[n] != -1) return memo[n];

		memo[n] = solve(n-1, memo) + solve(n-2, memo);

		return memo[n];
	}

	public static int climbStairs(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return solve(n, memo);
	}

	public static int climbStairs2(int n) {
		int[] memo = new int[n+1]; //[0,n]±îÁö
		memo[1] = 1;

		if(n>1) memo[2] = 2;
		for(int i=3; i<=n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}

		return memo[n];
	}
	public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}

}
