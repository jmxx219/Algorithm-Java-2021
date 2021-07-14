//���� ���
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

//���� N(kg)���. ���� : 3(kg), 5(kg) �ִ��� ���� ����
//N(kg) ��� ��, ���� �� �� �ʿ�?
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
		if(width < 0) return INF; // 1,2,4�� �� �Ұ���.
		
		if(memo[width] != -1) return memo[width];
		return memo[width] = Math.min(solve(width-3), solve(width-5))+1;
	}
}
