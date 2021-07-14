package dynamic;

// 외발뛰기

import java.util.Arrays;
import java.util.Scanner;

public class JUMPGAME {
	public static int[][] arr;
	public static int[][] cache;
	public static int N;
	public static int solve(int y, int x) {
		if(x >= N || y >= N) return 0;
		if(y == N-1 && x == N-1) return 1;

		if(cache[y][x] != -1) return cache[y][x];

		int jump = arr[y][x];
		cache[y][x] = solve(y+jump,x) | solve(y,x+jump);
		return cache[y][x];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 크기
		for(int i=0; i<T; i++) {
			N = sc.nextInt(); //격자 크기
			arr = new int[N][N];
			cache = new int[N][N];
			for(int a[] : cache) Arrays.fill(a, -1);
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					arr[y][x] = sc.nextInt();
				}
			}
			System.out.println(solve(0,0) == 1 ? "YES" : "NO");
		}
	}
}