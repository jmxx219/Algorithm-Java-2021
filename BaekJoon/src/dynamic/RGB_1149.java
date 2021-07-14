//RGB거리
//집 : N(개)
//집 N개를 RGB색을 이용해서 모든 집을 칠해야 한다. 최소 비용을 구해보자.
/*1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.*/

//2차원 배열 -> arr[N][3]
//매개변수 : 색깔 : [0,2], N번 집 : [1,N]
// N = 1000 비용 최댓값 : 1000 - > 10^6 
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class RGB_1149 {
	public static int[][] arr;
	public static int[][] memo;
	public static int N;
	
	public static int solve(int start, int colorNum) {
		if(start == N+1) return 0;
		if(memo[start][colorNum] != -1) return memo[start][colorNum];
		int ret = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(colorNum == i) continue;
			ret = Math.min(solve(start+1, i), ret);
		}
		return memo[start][colorNum] = ret + arr[start][colorNum];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 집의 수
		arr = new int[N+1][3]; // 집을 칠하는 비용(빨, 초, 파)
		memo = new int[N+1][3]; //집,색깔
		for(int[] i : memo) Arrays.fill(i, -1);
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) arr[i][j] = sc.nextInt();
		}
		
		int ret = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) ret = Math.min(ret, solve(1,i));
		System.out.println(ret);
		
//		for(int i[] : memo) System.out.println(Arrays.toString(i));
	}
}
