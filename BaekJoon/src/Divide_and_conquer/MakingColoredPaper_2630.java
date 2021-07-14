package Divide_and_conquer;

import java.util.Scanner;

// BOJ - 2630 색종이 만들기

public class MakingColoredPaper_2630 {
	public static boolean sameColor(int[][] paper, int startRow, int startColumn, int N, int[] result) {
		int firstColor = paper[startRow][startColumn];
		boolean flag = true;
		for(int i=startRow; i<N+startRow; i++) {
			for(int j=startColumn; j<N+startColumn; j++) {
				if(paper[i][j]!=firstColor) {
					flag = false;
					break;
				}
			}
			if(!flag) break;
		}
		if(flag) {
			if(firstColor==0) result[0]++;
			else result[1]++;
		}
		return flag;
	}
	public static void making(int[][] paper, int startRow, int startColumn, int N, int[] result) {
		if(N<1) return ;
		if(sameColor(paper,startRow,startColumn,N,result)) return;
		
		int mid = N/2;
		making(paper,startRow,startColumn,N/2,result); // 0,0
		making(paper,startRow,startColumn+mid,N/2,result); // 0,1
		making(paper,startRow+mid,startColumn,N/2,result); // 1,0
		making(paper,startRow+mid,startColumn+mid,N/2,result); // 1,1
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] paper = new int[N][N];
		int[] result = new int[2]; // 0: 하얀색, 1: 파란색
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j] = in.nextInt();
			}
		}
		making(paper,0,0,N,result);
		for(int n: result) System.out.println(n);
	}
}
