package brute_force;

import java.util.Scanner;

// 가장 큰 금민수

public class GuemMinsoo_1526 {
	private static int solve(int x, int N, int ret) {
		if(x <= N) ret = Math.max(ret, x);
		if(x>N) return ret;
		
		int a = solve(x*10+4, N, ret);
		int b = solve(x*10+7, N, ret);

		return Math.max(a, b);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int ret = Integer.MIN_VALUE;
		System.out.println(solve(0, N, ret));
	}


}
