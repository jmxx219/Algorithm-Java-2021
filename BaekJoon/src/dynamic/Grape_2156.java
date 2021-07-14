package dynamic;

import java.util.Scanner;

//������ �ý�

/* 1.������ ���� �����ϸ� �� �ܿ� ����ִ� �����ִ� ��� ���ž� �ϰ�, ���� �Ŀ��� ���� ��ġ�� �ٽ� ���ƾ� �Ѵ�.
 * 2.�������� ���� �ִ� 3���� ��� ���� ���� ����.*/

// ���� ���� ���� �����ָ� ���� �� �ֵ��� �ϴ� ���α׷��� �ۼ��Ͻÿ�. 
public class Grape_2156 {
	public static int N;
	public static int[] arr;
	
	public static int solve() {
		int[] memo = new int[N+1]; //[0,N]
		memo[1] = arr[1];
		if(N > 1) {
			memo[2] = Math.max(arr[2], arr[2] + arr[1]);
			for(int i=3; i<=N; i++) {
				memo[i] = Math.max(memo[i-3] + arr[i-1] + arr[i], memo[i-2] + arr[i]);
				memo[i] = Math.max(memo[i], memo[i-1]);
			}
		}
		return memo[N];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		for(int i=1; i<=N; i++) arr[i] = sc.nextInt();
		System.out.println(solve());
	}
}
