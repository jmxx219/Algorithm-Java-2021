package dynamic;

// 타일링 방법의 수 세기

import java.util.Arrays;
import java.util.Scanner;

public class TILING2 {
	public static final int MOD = 1000000007;
	
	public static int solve(int width, int[] memo) {
		if(width <= 1) return 1;
		if(memo[width] != -1) return memo[width];
		return memo[width] = (solve(width-1, memo) + solve(width-2, memo)) % MOD;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt(); //정수값
			int[] memo = new int[N+1];
			Arrays.fill(memo, -1);
			System.out.println(solve(N, memo));
		}
	}
}