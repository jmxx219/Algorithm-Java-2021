package dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 피보나치

public class Fibonacci {
	public static int fibM(int n, int[] memo) { // 메모이제이션
		if(n <= 2) return 1;
		if(memo[n] != -1) return memo[n];
		memo[n] = fibM(n-1, memo) + fibM(n-2, memo);
		return memo[n];
	}
	
	public static int fibT(int n) { // 테뷸레이션
		int[] table = new int[n+1];
		table[0] = 0;
		table[1] = 1;
		for(int i=2; i<=n; i++) {
			table[i] = table[i-1] + table[i-2];
		}
		return table[n];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		
		System.out.println("M: "+fibM(n, memo));
		System.out.println("T: "+fibT(n));
	}

}


