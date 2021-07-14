//계단 오르기
/*1. 계단은 1,2칸 가능.
 *2. 연속된 세 개의 계단 불가능.
 *3. 마지막 도착 계단은 반드시 밟아야 된다.*/

//총 점수의 최댓값을 구하시오.
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Stairs_2579 {
	public static int[] stairs = new int[301];
	public static int[] memo = new int[301];
	public static int N;
	
	private static int solve() {
		memo[0] = stairs[0];
		memo[1] = stairs[0] + stairs[1];
		memo[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
		
		for(int i=3; i<N; i++) {
			memo[i] = Math.max(memo[i-2] + stairs[i],  memo[i-3] + stairs[i-1] + stairs[i]);
		}
		return memo[N-1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) stairs[i] = sc.nextInt();
		
		Arrays.fill(memo, -1);
		System.out.println(solve());
	}
}
