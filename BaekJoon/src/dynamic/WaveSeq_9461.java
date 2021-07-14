//파도반 수열 
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class WaveSeq_9461 {
	public static long[] memo = new long[101];
	
	private static long solve(int N) {
		if(memo[N] != -1) return memo[N];
		return memo[N] = solve(N-5) + solve(N-1);
	}
	
	public static void main(String[] args) {
		Arrays.fill(memo, -1);
		
		long[] tmp = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
		System.arraycopy(tmp, 0, memo, 0, tmp.length);
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			System.out.println(solve(N));
		}
	}
}
