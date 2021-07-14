package brute_force;

// ∫Ì∑¢¿Ë

import java.util.Scanner;

public class BlackJack_2798 {
	public static int N;
	public static int M;
	public static int[] arr;

	private static int solve(int index, int i, int result) {
		if(index==3) {
			if(result <= M) return result;
			else return 0;
		}
		if(i>=N) return 0;
		int a = solve(index+1, i+1, result+arr[i]);
		int b = solve(index, i+1, result);
		
		return Math.max(a, b);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = in.nextInt();
		System.out.println(solve(0, 0, 0));
	}

}
