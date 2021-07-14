package dynamic;

//비대칭 타일링

import java.util.Arrays;
import java.util.Scanner;

public class ASYMTILING {
	public static int N;
	public static int[] memo;
	public static int[] tilingMemo;
	public static final int MOD = 1000000007;
	
	public static int solve(int width) {
		if(width <= 2) return 0;
		if(memo[width] != -1 ) return memo[width];
		int ret = solve(width-2) % MOD;
		ret = (ret+solve(width-4)) % MOD;
		ret = (ret+tiling(width-3)) % MOD;
		ret = (ret+tiling(width-3)) % MOD;
		return memo[width] = ret;
	}

	public static int tiling(int width) {
		if(width <= 1) return 1;
		if(tilingMemo[width] != -1) return tilingMemo[width];
		return tilingMemo[width] = (tiling(width-1) + tiling(width-2)) % MOD;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			memo = new int[N+1];
			tilingMemo = new int[N+1];
			Arrays.fill(memo, -1);
			Arrays.fill(tilingMemo, -1);
			
			System.out.println(solve(N));
		}
	}
}