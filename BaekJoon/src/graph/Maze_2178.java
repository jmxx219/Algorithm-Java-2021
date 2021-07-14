package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ¹Ì·ÎÅ½»ö

public class Maze_2178 {
	public static int M; // °¡·Î Ä­ÀÇ ¼ö
	public static int N; // ¼¼·Î Ä­ÀÇ ¼ö
	public static int[] dy = {-1, 0, 0, 1};
	public static int[] dx = {0, -1, 1, 0};
	public static class Point{
		int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
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
	public static void solve(int[][] maze) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		boolean[][] visited = new boolean[N][M];
		
		while(!queue.isEmpty()) {
			Point here = queue.poll();
			visited[here.y][here.x] = true;
			for(int i=0; i<4; i++) {
				int y = here.y + dy[i];
				int x = here.x + dx[i];
				if(y >= 0 && y < N && x >= 0 && x < M) {
					if(maze[y][x] == 1 && !visited[y][x]) {
						maze[y][x] = maze[here.y][here.x] + 1;
						if(y==N-1&&x==M-1) return ;
						queue.add(new Point(y, x));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		int[][] maze = new int[N][M];
		in.nextLine();
		for(int i=0; i<N; i++) {
			String s = in.nextLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		solve(maze);
		System.out.println(maze[N-1][M-1]);
	}

}
