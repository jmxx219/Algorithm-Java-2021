package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
	public static int N;
	public static int[] P;
	
	public static int solve() {
		int time = 0;
		int res = 0;
		for(int t : P) {
			time += t;
			res += time;
		}
		
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt(); // 사람의 수
		P = new int[N];
		for(int i=0; i<N; i++) P[i] = in.nextInt();
		Arrays.sort(P);
		System.out.println(solve());
	}
}