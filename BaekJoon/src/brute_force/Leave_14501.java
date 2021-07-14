package brute_force;

import java.util.Scanner;

// Επ»η

public class Leave_14501 {
	public static int N;
	public static int[][] arr;

	private static int solve(int prevday, int sum) {
		
		int res = 0;
		for(int i=prevday; i<N; i++) {
			int nextday = prevday+arr[i][0];
			if(nextday > N) res = Math.max(res, sum);
			else res = Math.max(res, solve(prevday+arr[i][0], sum+arr[i][1]));
			System.out.println("res: " + res);
			System.out.println();
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		System.out.println(solve(0, 0));
	}
}
