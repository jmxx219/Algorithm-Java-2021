package dynamic;

// 최대 부분 증가 수열

import java.util.Arrays;
import java.util.Scanner;

public class AlgoSpot_LIS {
	public static int N;
	public static int[] arr;
	
	private static int solve(int start, int[] memo) {
		if(memo[start] != -1) return memo[start];
		memo[start] = 1;
		for(int next=start+1; next<N; next++) {
			if(arr[start] < arr[next]) {
				memo[start] = Math.max(memo[start], solve(next,memo)+1);
			}
		}
		return memo[start];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			arr = new int[N];
			for(int j=0; j<N; j++) arr[j] = sc.nextInt();
			
			int[] memo = new int[N];
			Arrays.fill(memo, -1);
			
			int ret = Integer.MIN_VALUE;
			for(int j=0; j<N; j++) {
				ret = Math.max(ret, solve(j, memo));
			}
			System.out.println(ret);
		}
	}
}