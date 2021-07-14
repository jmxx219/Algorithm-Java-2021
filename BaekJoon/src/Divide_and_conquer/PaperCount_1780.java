package Divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
// import java.util.Scanner;
import java.util.StringTokenizer;

// BOJ - 1780 종이의 개수

public class PaperCount_1780 {
	public static int[][] paper;
	public static int[] result;
	public static boolean isSame(int row, int column, int N) {
		for(int i=row; i<N+row; i++) {
			for(int j=column; j<N+column; j++) {
				if(paper[row][column]!=paper[i][j]) return false;
			}
		}
		return true;
	}
	public static void paperCount(int row, int column, int N) {
		if(isSame(row, column, N)) {
			result[paper[row][column]+1]++;
		}
		else {
			int len = N/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					paperCount(row+len*i, column+len*j, len);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		paper = new int[N][N];
		result = new int[3]; // 0: 하얀색, 1: 파란색
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j] = in.nextInt();
			}
		}
		paperCount(0,0,N);
		for(int n: result) System.out.println(n);
	}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine().trim());
//		paper = new int[N][N];
//		result = new int[3]; // 0: 하얀색, 1: 파란색
//		
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for(int j=0; j<N; j++) {
//				paper[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		paperCount(0,0,N);
//		for(int n: result) System.out.println(n);
//	}
}
