//01 타일
//00, 1을 이용하여 만들 수 있는 경우의 수를 출력하시오.
package dynamic;
import java.util.Arrays;
import java.util.Scanner;

//start이용
public class Tile_1904 {
	public static final int MOD = 15746;
	public static int N; 
	public static int[] memo;
	
	public static int solve(int start) {
		if(start > N) return 0;
		if(start == N) return 1;
		if(memo[start] != -1) return memo[start];
		return memo[start] = (solve(start+1) + solve(start+2)) % MOD;
	}
	public static int solve2(int start) {
		if(start == 0) return 1;
		if(start<0) return 0;
		if(memo[start] != -1) return memo[start];
		return memo[start] = (solve2(start-1) + solve2(start-2)) % MOD;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new int[N+1];
		Arrays.fill(memo, -1);
//		System.out.println(solve(0));
		System.out.println(solve2(N));
		System.out.print(Arrays.toString(memo));
	}
}
