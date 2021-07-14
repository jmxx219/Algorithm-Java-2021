package dynamic;

import java.util.Scanner;

//포도주 시식

/* 1.포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 * 2.연속으로 놓여 있는 3잔을 모두 마실 수는 없다.*/

// 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오. 
public class Grape_2156 {
	public static int N;
	public static int[] arr;
	
	public static int solve() {
		int[] memo = new int[N+1]; //[0,N]
		memo[1] = arr[1];
		if(N > 1) {
			memo[2] = Math.max(arr[2], arr[2] + arr[1]);
			for(int i=3; i<=N; i++) {
				memo[i] = Math.max(memo[i-3] + arr[i-1] + arr[i], memo[i-2] + arr[i]);
				memo[i] = Math.max(memo[i], memo[i-1]);
			}
		}
		return memo[N];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		for(int i=1; i<=N; i++) arr[i] = sc.nextInt();
		System.out.println(solve());
	}
}
