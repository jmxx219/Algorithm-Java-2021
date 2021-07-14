//1로 만들기2
package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MakOne2_12852 {
	public static final int INF = 987654321;
	public static int N;
	public static int[] memo;
	public static int[] find;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new int[N+1];
		find = new int[N+1];
		
		Arrays.fill(memo, -1);
		System.out.println(solve(N));
		print(N);
	}

	private static void print(int N) {
		if(N == 0) return;
		System.out.print(N + " ");
		
		if(N%3 == 0 && memo[N] == memo[N/3]+1)
			print(N/3);
		else if(N%2 == 0 && memo[N] == memo[N/2]+1)
			print(N/2);
		else if(N-1 >= 0 && memo[N] == memo[N-1]+1)
			print(N-1);
	}

	private static int solve(int x) {
		if(x < 1) return INF;
		if(x == 1) {
			return memo[1] = 0;
		}
		if(memo[x] != -1) return memo[x];
		int a = INF, b = INF, c = INF;
		if(x % 3 == 0) {
			a = solve(x/3)+1;
		}
		if(x % 2 == 0) {
			b = solve(x/2)+1;
		}
		c = solve(x-1)+1;
		return memo[x] = Math.min(Math.min(a, b), c);
	}
}
