package dynamic;

import java.util.Arrays;
import java.util.Scanner;

// BOJ_11050 이항계수

public class Bino { // 메모이제이션
	public static int bin(int n, int r, int[][] memo) {
		if(r==0 || n==r) return 1;
		if(memo[n][r]!= -1) return memo[n][r];
		
		memo[n][r] = bin(n-1, r-1, memo) + bin(n-1, r, memo);
		
		return memo[n][r];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[][] memo = new int[N+1][K+1];
		
		for(int i[] : memo) Arrays.fill(i, -1);
		
		System.out.println(bin(N, K, memo));
	}
}

class BinoT { // 테뷸레이션
	public static int bin(int n, int r) {
		int[][] B = new int[n+1][r+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=Math.min(i, r); j++) {
				if(j==0 || j==i) B[i][j] = 1;
				else B[i][j] = B[i-1][j-1] + B[i-1][j];
			}
		}
		return B[n][r];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		System.out.println(bin(N, K));
	}
}
