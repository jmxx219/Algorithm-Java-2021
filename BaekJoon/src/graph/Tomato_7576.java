package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토 익히기

public class Tomato_7576 {
	public static int M; // 가로 칸의 수
	public static int N; // 세로 칸의 수
	public static int[] dy = {-1, 0, 0, 1};
	public static int[] dx = {0, -1, 1, 0};
	public static class Point{
		int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public int getY() { return this.y; }
		public int getX() { return this.x; }
	}
	public static void print(int[][] tomato) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(tomato[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
	public static boolean isAll(int[][] tomato) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomato[i][j]!=0) return false;
			}
		}
		return true;
	}
	public static int solve(int[][] tomato) {
		Queue<Point> queue = new LinkedList<>();

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomato[i][j]==1) {
					queue.add(new Point(i, j));
				}
			}
		}

		while(!queue.isEmpty()) {
			Point here = queue.poll();
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				if(ny >= 0 && ny <tomato.length && nx >= 0 && nx <tomato[0].length) {
					if(tomato[ny][nx] == 0) {
						tomato[ny][nx] = tomato[here.y][here.x] + 1;
						queue.add(new Point(ny, nx));
					}
				}
			}
		}
		
		int res = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomato[i][j]==0) return -1;
				res = Math.max(res, tomato[i][j]);
			}
		}
		
		return res-1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		M = in.nextInt();
		N = in.nextInt();
		int[][] tomato = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tomato[i][j] = in.nextInt();
			}
		}
		System.out.println(solve(tomato));
	}

}
