package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 영역 구하기

public class Domain_2583 {
	public static int height; //오른쪽 위가 (N,M)이다.
	public static int width;
	public static int K; //좌표 수 (왼쪽아래 x,y) (오른쪽 위 x,y)가 주어진다. 
	public static int[][] arr;
	public static int[] dx = {-1,0,0,1};
	public static int[] dy = {0,1,-1,0};


	private static int solve(int y, int x) {
		if(y < 0 || y >= height || x < 0 || x >= width) return 0;
		if(arr[y][x] != 0) return 0;

		arr[y][x] = 1;
		int ret = 1;

		for(int i=0; i<4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			ret += solve(nextY,nextX);
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		K = sc.nextInt();
		arr = new int[height][width];
		for(int i=0; i<K; i++) {
			int leftX = sc.nextInt();
			int leftY = sc.nextInt();
			int rightX = sc.nextInt();
			int rightY = sc.nextInt();
			for(int j = leftY; j < rightY; j++) {
				for(int k = leftX; k < rightX; k++) 
					arr[j][k] = 1;
			}
		}
		 
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++)
				if(arr[i][j] == 0) {
					count++;
					list.add(solve(i,j));
				}
		}
		System.out.println(count);
		Collections.sort(list);
		for(var x : list) System.out.print(x + " ");
	}
}
