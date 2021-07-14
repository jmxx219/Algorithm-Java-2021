package brute_force;

import java.util.Scanner;

// 유기농 배추

public class Cabbage_1012 {
	public static int calumn;
	public static int row;
	public static int K;
	public static int[][] ground;
	public static int[][] UDLR = {{-1, 0},{0, -1},{1, 0},{0, 1}};
	
	public static void print() {
		for(int i=0; i<row; i++) {
			for(int j=0; j<calumn; j++) {
				System.out.print(ground[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean inRange(int y, int x) {
		 return x >= 0 && x < ground[0].length && y >=0 && y < ground.length;
	  }
	public static void protect(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + UDLR[i][0];
			int nc = c + UDLR[i][1];
			if(!inRange(nr, nc)) continue;
			if(ground[nr][nc]==1) {
				ground[nr][nc] = 0;
				protect(nr, nc);
			}
		}
	}
	private static int solve(int startR, int startC) {
		int ret = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<calumn; j++) {
				if(ground[i][j]==1) {
					ground[i][j] = 0;
					ret++;
					protect(i, j);
				}
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			calumn = in.nextInt(); // 배추밭 가로길이 - 열
			row = in.nextInt(); // 배추밭 세로길이 - 행 
			K = in.nextInt(); // 배추의 위치 개수
			ground = new int[row][calumn];
			for(int j=0; j<K; j++) {
				int c = in.nextInt();
				int r = in.nextInt();
				ground[r][c]++;
			}
			System.out.println(solve(0, 0));
		}
	}
}
