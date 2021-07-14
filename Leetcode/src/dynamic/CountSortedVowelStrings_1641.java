package dynamic;

import java.util.Arrays;

public class CountSortedVowelStrings_1641 {
   public static int[][] memo;
     
   public static int solve(int here, int n) {
      if(n == 0) return 1;
      if(memo[here][n] != -1) return memo[here][n];
      memo[here][n] = 0;
      
      for(int next = here; next < 5; next++) {
         memo[here][n] += solve(next, n-1);
      }
      return memo[here][n];
   }
   
   public static int countVowelStrings(int n) {
      memo = new int[5][n+1];
      for(int[] i : memo) Arrays.fill(i, -1);
         
      return solve(0, n);
   }
   
   public static void main(String[] args) {
	   System.out.println(countVowelStrings(3));
   }
}