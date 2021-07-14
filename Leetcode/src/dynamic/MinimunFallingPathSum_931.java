package dynamic;

import java.util.Arrays;

public class MinimunFallingPathSum_931 {
   public static void main(String[] args) {
      int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
      System.out.println(minFallingPathSum(matrix));

   }

   public static int minFallingPathSum(int[][] matrix) {
      int N = matrix.length;
      int[][] dp = new int[N+1][N+2];
      
      for(int i = N-1; i>=0; i--) {
         for(int j=1; j<=N; j++) {
            if(j == 1) dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + matrix[i][j-1];
            else if(j == N) dp[i][j] = Math.min(dp[i+1][j-1], dp[i+1][j]) + matrix[i][j-1];
            else dp[i][j] = Math.min(Math.min(dp[i+1][j-1], dp[i+1][j]), dp[i+1][j+1]) + matrix[i][j-1];
            
         }
      }
      
      int ret = Integer.MAX_VALUE;
      for(int i=1; i<=N; i++)
         ret = Math.min(ret, dp[0][i]);
      
      for(int[] i : dp)
         System.out.println(Arrays.toString(i));
      
      return ret;
   }
}