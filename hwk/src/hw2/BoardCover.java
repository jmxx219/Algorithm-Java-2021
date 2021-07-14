package hw2;

import java.util.Scanner;

public class BoardCover {
	public static int[][] board ; // 친구 정보를 담는 배열
	public static final int[][][] coverType = { // L자 덮는 4가지 방법
		{{0,0},{1,0},{0,1}}, // ┌
		{{0,0},{0,1},{1,1}}, //  ┐
		{{0,0},{1,0},{1,1}}, // └
		{{0,0},{1,0},{1,-1}} //  ┘
	};
	// delta가 1이면 블록 덮기, -1이면  치우기
	public static boolean canCover(int y, int x, int type, int delta) {
		boolean flag = true;
		
		for(int i=0; i<3; i++) {
			int ny = y + coverType[type][i][0];
			int nx = x + coverType[type][i][1];
			if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) flag = false;
			else if((board[ny][nx] += delta) > 1) flag = false;
		}
		
		return flag; 
	}
	public static int cover() {
		int y = -1, x = -1;
		
		for(int i = 0; i <  board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if(y != -1) break; // 공백 찾았으면 탈출!
		}
		
		if(y == -1) return 1;
		
		int ret = 0;
		for(int type = 0; type < 4; type++) {
			if(canCover(y, x, type, 1)) ret += cover(); // 덮기
			canCover(y, x, type, -1); // 치우기
		}

		return ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int H = in.nextInt(); // 행
			int W = in.nextInt(); // 열
			in.nextLine();
			board = new int[H][W];
			for(int j=0; j < H; j++) {
				String temp = in.nextLine();
				for(int k=0; k < W; k++) {
					if(temp.charAt(k)=='#') board[j][k] = 1;
					else board[j][k] = 0;
				}
			}
			System.out.println(cover());
		}
	}
}
