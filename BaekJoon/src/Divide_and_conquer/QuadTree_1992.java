package Divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ - 1992 ÄõµåÆ®¸®

public class QuadTree_1992 {
	public static int[][] paper;
	public static boolean compression(int[][] paper, int startRow, int startColumn, int N) {
		for(int i=startRow; i<N+startRow; i++) {
			for(int j=startColumn; j<N+startColumn; j++) {
				if(paper[startRow][startColumn]!=paper[i][j]) return false;
			}
		}
		return true;
	}
	public static void quadTree(int[][] paper, int startRow, int startColumn, int N) {
		if(compression(paper,startRow,startColumn,N)) System.out.print(paper[startRow][startColumn]);
		else {
			System.out.print("(");
			int M = N/2;
			quadTree(paper, startRow, startColumn, M); // 0,0
			quadTree(paper, startRow, startColumn+M, M); // 0,1
			quadTree(paper, startRow+M, startColumn, M); // 1,0
			quadTree(paper, startRow+M, startColumn+M, M); // 1,1
			System.out.print(")");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		paper = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.valueOf(str.substring(j, j+1));
			}
		}
		quadTree(paper,0,0,N);
	}

}