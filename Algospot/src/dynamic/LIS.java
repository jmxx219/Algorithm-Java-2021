package dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 최대증가부분수열

public class LIS {
	public static int solve(int pos, int[] nums, int[] memo) {
		if(memo[pos] != -1) return memo[pos];
		int ret = 1;
		for(int next = pos+1; next<nums.length; next++) {
			if(nums[pos] < nums[next]) ret = Math.max(ret, solve(next, nums, memo)+1);
		}
		memo[pos] = ret;
		return ret;
	}
	
	public static int solve(int[] nums) {
		int[] memo = new int[nums.length];
		Arrays.fill(memo, -1);
		int ret = 0;
		for(int pos = 0; pos < nums.length; pos++) {
			ret = Math.max(ret, solve(pos, nums, memo));
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt(); // 수열 크기
		int[] nums = new int[A];
		for(int i=0; i<A; i++) nums[i] = in.nextInt();
		System.out.println(solve(nums));
	}
}

class Solution { // dp
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int dp[] = new int[N+1];
        Arrays.fill(dp,-1);
        int res = 0;
        for(int i = 0; i < N; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[i]>nums[j])  max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}


class Solution3 { // dp
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int ret = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    ret = Math.max(ret, dp[i]);
                }
            }
        }
        
        return ret;
    }
}
