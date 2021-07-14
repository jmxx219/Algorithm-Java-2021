package brute_force;

import java.util.Scanner;

// 연구소

public class Research_14502 {
	public static int N;
	public static int M;
	public static int[] dy = {-1, 0, 0, 1};
	public static int[] dx = {0, -1, 1, 0};

	// 0:빈칸, 1:벽, 2:바이러스
	// 새로운 벽의 개수는 3개
	public static void print(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int[][] copy(int [][] arr) {
		int[][] copyWall = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyWall[i][j] = arr[i][j];
			}
		}
		return copyWall;
	}


	public static void check(int[][] map, int y, int x) {
		map[y][x] = 3;
		
		for(int i=0; i<4; i++) {
	         int nextY = y + dy[i];
	         int nextX = x + dx[i];
	         if(nextY >= 0 && nextY < N && nextX >=0 && nextX <M && (map[nextY][nextX] == 0 || map[nextY][nextX] == 2))
	            check(map, nextY,nextX);
	      }
	}
	public static int solve(int[][] map) {
		int[][] copyMap = copy(map);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					check(copyMap, i, j);
				}
			}
		}

		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
	
	public static int brute(int[][] map, int wall) {
		if(wall==3) return solve(map);
		
		int ret = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					ret = Math.max(ret, brute(map, wall+1));
					map[i][j] = 0;
				}
			}
		}
		
		return ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = in.nextInt();
			}
		}
		System.out.println(brute(map, 0));
	}

}
