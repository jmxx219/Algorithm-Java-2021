//���� ��
package dynamic;

import java.util.Scanner;

public class Sum_1912 {
	public static int N; // N : [1,100000]
	public static int[] arr; // arr[i] : (-1000, 1000]
	public static final int INF = 987654321;
	//�ִ� : (10^6) * (10^3) -> 10*9
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		solve();
	}

	//i��°�� �����Ͽ��� ���� �������� �ʾ��� ���� �ִ��� ������
	public static void solve() {
		int[] memo = new int[N];
		memo[0] = arr[0];
		int ret = memo[0];
		
		for(int i=1; i<N; i++) {
			memo[i] = Math.max(memo[i-1] + arr[i], arr[i]);
			ret = Math.max(ret, memo[i]);
		}
		
		System.out.println(ret);
	}
}
