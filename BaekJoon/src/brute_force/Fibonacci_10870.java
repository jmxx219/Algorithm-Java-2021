package brute_force;

import java.util.Scanner;

// 피보나치 수 5

public class Fibonacci_10870 {
	public static int solve(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return solve(n-1) + solve(n-2);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(solve(n));
	}
}
