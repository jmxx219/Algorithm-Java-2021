package greedy;

import java.util.Scanner;

public class Coin0_11047 {
	public static int[] coins;
	public static int N;
	public static int solve(int K) {
		int cnt = 0;
		for(int i = N - 1; i >= 0; i--) {
			if(coins[i] <= K) {
				cnt += (K / coins[i]);
				K = K % coins[i];
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt(); // 동전 종류
		int K = in.nextInt(); // 가치의 합(목표)
		coins = new int[N];
		for(int i=0; i<N; i++) coins[i] = in.nextInt();
		System.out.println(solve(K));
	}
}
