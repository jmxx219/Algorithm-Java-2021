package hw10;

import java.util.Scanner;

// B: 최적의 이진 검색 트리

public class OptimalBST {
	
	private static int optimalBST(int N, int[] F) {
		int[][] C = new int[N+2][N+2];
		
		for(int s=0; s<=N-1; s++) {
			for(int i=1; i<= N-s; i++) {
				int p = 0;
				int cs = Integer.MAX_VALUE;
				for(int r=i; r<=i+s; r++) {
					p += F[r];
					cs = Math.min(cs, C[i][r-1]+C[r+1][i+s]);
				}
				C[i][i+s] = p + cs;
			}
		}
		return C[1][N];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // 키의 개수
			int[] F = new int[N+1]; // 각 키에 대한 검색 빈도
			for(int j=1; j<=N; j++) F[j] = in.nextInt();
			System.out.println(optimalBST(N, F));
		}
	} 
//	public static void main(String[] args) throws IOException {
//		StringBuilder sb = new StringBuilder();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int T = Integer.parseInt(br.readLine());
//		for(int i=0; i<T; i++) {
//			int N = Integer.parseInt(br.readLine()); // 키의 개수
//			int[] F = new int[N+1]; // 각 키에 대한 검색 빈도
//			String[] st = br.readLine().split(" ");
//			for(int j=1; j<=N; j++) F[j] = Integer.parseInt(st[j-1]);
//			System.out.println(optimalBST(N, F));
//		}
//	} 	
}