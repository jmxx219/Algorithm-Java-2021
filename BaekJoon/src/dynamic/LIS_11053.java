//가장 긴 증가하는 부분 수열

package dynamic;
import java.util.Arrays;
import java.util.Scanner;

public class LIS_11053 {
	public static int N; //[1,1000]
	public static int[] arr; //arr[i] : [1,1000]
	public static int[] memo;
	public static final int INF = 987654321;
	
	private static int solve(int start) {
		if(memo[start] != -1) return memo[start];
		int ret = 1;
		
		for(int next = start+1; next < N; next++) {
			if(arr[next] > arr[start]) ret = Math.max(ret, solve(next) + 1);
		}
		return memo[start] = ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		memo = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		Arrays.fill(memo, -1);
		
		int len = 0;
		for(int start=0; start<N; start++)
			len = Math.max(solve(start), len);
		
		System.out.println(len);
		System.out.println(Arrays.toString(memo));
	}
}
