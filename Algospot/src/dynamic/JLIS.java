package dynamic;

// 합친 LIS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JLIS {
	public static int N; //A의 길이
	public static int M; //B의 길이
	public static int[] A;
	public static int[] B;
	public static final long MIN = Long.MIN_VALUE;
	
	private static int solve(int indexA, int indexB, int[][] memo) {
		if(memo[indexA+1][indexB+1] != -1) return memo[indexA+1][indexB+1];
		memo[indexA+1][indexB+1] = 2; // A[indexA], B[indexB]가 이미 존재하므로 하상 2개
		
		long a = indexA == -1 ? MIN : A[indexA];
		long b = indexB == -1 ? MIN : B[indexB];
		long maxElement = Math.max(a, b);

		for(int nextA = indexA+1; nextA < N; nextA++) {
			if(maxElement < A[nextA])
				memo[indexA+1][indexB+1] = Math.max(memo[indexA+1][indexB+1], solve(nextA, indexB, memo)+1);
		}
		for(int nextB = indexB+1; nextB < M; nextB++) {
			if(maxElement < B[nextB])
				memo[indexA+1][indexB+1] = Math.max(memo[indexA+1][indexB+1], solve(indexA, nextB, memo)+1);
		}
		return memo[indexA+1][indexB+1];
	}

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //테스트케이스 수
		for(int i=0; i<T; i++) {
			String[] st = br.readLine().split(" ");
			N = Integer.parseInt(st[0]);
			M = Integer.parseInt(st[1]);
			A = new int[N];
			B = new int[M];
			int[][] memo = new int[N+1][M+1];
			for(int[] k : memo) Arrays.fill(k, -1);
			
			st = br.readLine().split(" ");
			for(int j =0; j<A.length; j++) A[j] = Integer.parseInt(st[j]);
			
			st = br.readLine().split(" ");
			for(int j =0; j<B.length; j++) B[j] = Integer.parseInt(st[j]);
			
			System.out.println(solve(-1,-1, memo)-2);
		}
	}
}