package dynamic;

// 삼각형 위의 최대 경로

import java.util.Arrays;
import java.util.Scanner;

public class TRIANGLEPATH {
	public static int N;
	public static int[][] triangle;
	
	private static int solve(int y, int x, int[][] memo) {
		if(y == N-1) return triangle[y][x];
		if(memo[y][x] != -1) return memo[y][x];
		return memo[y][x] = triangle[y][x] + 
				Math.max(solve(y+1,x, memo), solve(y+1,x+1,memo));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt(); //삼각형의 크기
			triangle = new int[N][N];
			int[][] memo = new int[N][N];
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<=j; k++) {
					triangle[j][k] = sc.nextInt();
				}
			}
			
			for(int[] x : memo) Arrays.fill(x, -1);
			System.out.println(solve(0,0, memo));
		}
	}
}