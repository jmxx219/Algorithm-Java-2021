package dynamic;

public class MinimumCostTreFromLeafValues_1130 {
	public static void print(int[][] memo) {
		for(int i=0; i<memo.length; i++) {
			for(int j=0; j<memo.length; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int findMax(int low, int high, int[] arr) {
		int ret = -1;
		for(int i=low; i<=high; i++) ret = Math.max(ret, arr[i]);
		return ret;
	}
	public static int mctFromLeafValues(int[] arr) {
		int N = arr.length;
		int[][] memo = new int[N][N]; //[0,N]

		for(int j=0; j<N; j++) {
			for(int i=j; i>=0; i--) {
				for(int k=i; k<j; k++) {
					int tmp = memo[i][k] + memo[k+1][j] + findMax(i,k,arr) * findMax(k+1,j,arr);
					if(memo[i][j] == 0) memo[i][j] = tmp;
					else memo[i][j] = Math.min(memo[i][j], tmp);
					print(memo);
				}
			}
		}
		return memo[0][N-1];
	}
	public static void main(String[] args) {
		int[] arr = {6, 2, 4};
		System.out.println(mctFromLeafValues(arr));
	}
}

//public class MinimumCostTreFromLeafValues_1130 {
//	public static int mctFromLeafValues(int[] arr) {
//		int N = arr.length;
//		int[][] dp = new int[N][N]; //[0,N]
//		int[][] maxi = new int[N][N];
//
//		for(int i=0; i<N; i++) maxi[i][i] = arr[i];
//
//		for(int size = 1; size < N; size++) {
//			for(int i=0; i<N-size; i++) {
//				int j = i + size;
//				maxi[i][j] = Math.max(maxi[i][j-1], maxi[i+1][j]);
//			}
//		}
//
//		for(int j=0; j<N; j++) {
//			for(int i=j; i>=0; i--) {
//				for(int k=i; k<j; k++) {
//					int tmp = dp[i][k] + dp[k+1][j] + maxi[i][k] * maxi[k+1][j];
//					if(dp[i][j] == 0) dp[i][j] = tmp;
//					else dp[i][j] = Math.min(dp[i][j], tmp);
//				}
//			}
//		}
//		return dp[0][N-1];
//	}
//
//	public static void main(String[] args) {
//		int[] arr = {6, 2, 4};
//		System.out.println(mctFromLeafValues(arr));
//	}
//
//}




