package graph;

// 나이트 움직이기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Knight_7562 {
	public static int I;
	public static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
	public static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static class Point{
		int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void solve(Point start, Point end, int[][] map) {
		if(start.y == end.y && start.x == end.x) {
			System.out.println(0);
			return ;
		}
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(start.y, start.x));
		map[start.y][start.x] = 0;

		while(!q.isEmpty()) {
			Point here = q.poll();
			for(int i=0; i<8; i++) {
				int y = here.y + dy[i];
				int x = here.x + dx[i];

				if(y >= 0 && y < I && x >=0 && x < I) {
					if(map[y][x] == 0) {
						q.add(new Point(y, x));
						map[y][x] = map[here.y][here.x] + 1;
						if(y == end.y && x == end.x) {
							System.out.println(map[y][x]);
							return;
						}
					}
				}
				
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			I = in.nextInt();
			int[][] map = new int[I][I];

			Point start;
			int y = in.nextInt();
			int x = in.nextInt();
			start = new Point(y, x);

			Point end;
			y = in.nextInt();
			x = in.nextInt();
			end = new Point(y, x);

			solve(start, end, map);
		}
	}

}
