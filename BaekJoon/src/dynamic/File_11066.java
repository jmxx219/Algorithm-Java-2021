//파일합치기

package dynamic;
import java.util.Arrays;
import java.util.Scanner;

//A[i,j] = Math.min(A[i,k] + A[k,j])
public class File_11066 {
	// N : [3,500]  arr[i] : [0,10000] 
	public static int N;
	public static int[][] memo;
	public static int INF = 987654321;

	//[i,j] => [i,k]와 [k+1,j]
	public static int solve(int i, int j) {
		//기저사건
		if(i == j) return 0;
		if(i+1 == j) return memo[i][j] = memo[i][i] + memo[j][j]; 
		if(memo[i][j] < INF) return memo[i][j];

		for(int k=i; k<j; k++) 
			memo[i][j] = Math.min(solve(i,k) + solve(k+1,j), memo[i][j]);
		
		for(int k=i; k<=j; k++) memo[i][j] += memo[k][k];

		return memo[i][j];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			memo = new int[N][N];
			for(int[] k : memo) Arrays.fill(k, INF);
			for(int j=0; j<N; j++) memo[j][j] = sc.nextInt();

			System.out.println(solve(0,N-1));
			
			for(int j=0; j<N; j++) {
				for(int K=0; K<N; K++) {
					if(memo[j][K] == INF) System.out.print("INF ");
					else System.out.print(memo[j][K]+" ");
				}
				System.out.println();
			}
			
			//for(int[] j : memo) System.out.println(Arrays.toString(j));
		}
	}
}
