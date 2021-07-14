//설탕 배달
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

//설탕 N(kg)배달. 봉지 : 3(kg), 5(kg) 최대한 적은 봉지
//N(kg) 배달 시, 봉지 몇 개 필요?
public class Sugar_2839 {
	public static int N;
	public static int[] memo;
	public static final int INF = 987654321;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		int ret = solve(N);
		System.out.println(ret < INF ? ret : -1);
	}

	public static int solve(int width) {
		if(width == 0) return 0;
		if(width < 0) return INF; // 1,2,4일 때 불가능.
		
		if(memo[width] != -1) return memo[width];
		return memo[width] = Math.min(solve(width-3), solve(width-5))+1;
	}
}
