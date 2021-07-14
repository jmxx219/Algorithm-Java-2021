//정수 삼각형
//맨 위층부터 시작해 아래에 있는 수중 하나 선택하여 내려올 때 선택한 수의 최대가 되는 경로를 구하라.
//아래로는 대각선 왼쪽 또는 대각선 오른쪽만 가능하다.
//삼각형의 크기 : [1,500] 수 : [0,9999]
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle_1932 {
	public static int N;
	public static int[][] triangle;
	public static int[][] memo;
	
	public static int solve(int y, int x) {
		if(y == N) return 0;
		if(memo[y][x] != -1) return memo[y][x];
		return memo[y][x] = Math.max(solve(y+1, x), solve(y+1,x+1)) + triangle[y][x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //삼각형의 크기 : N
		triangle = new int[N][N];
		memo = new int[N][N];
		
		for(int[] k : memo)
			Arrays.fill(k, -1);
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<=y; x++)
				triangle[y][x] = sc.nextInt();
		}
		
		System.out.println(solve(0,0));
//		for(int[] k : memo)
//			System.out.println(Arrays.toString(k));
	}
}
