//RGB�Ÿ�
//�� : N(��)
//�� N���� RGB���� �̿��ؼ� ��� ���� ĥ�ؾ� �Ѵ�. �ּ� ����� ���غ���.
/*1�� ���� ���� 2�� ���� ���� ���� �ʾƾ� �Ѵ�.
N�� ���� ���� N-1�� ���� ���� ���� �ʾƾ� �Ѵ�.
i(2 �� i �� N-1)�� ���� ���� i-1��, i+1�� ���� ���� ���� �ʾƾ� �Ѵ�.*/

//2���� �迭 -> arr[N][3]
//�Ű����� : ���� : [0,2], N�� �� : [1,N]
// N = 1000 ��� �ִ� : 1000 - > 10^6 
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class RGB_1149 {
	public static int[][] arr;
	public static int[][] memo;
	public static int N;
	
	public static int solve(int start, int colorNum) {
		if(start == N+1) return 0;
		if(memo[start][colorNum] != -1) return memo[start][colorNum];
		int ret = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(colorNum == i) continue;
			ret = Math.min(solve(start+1, i), ret);
		}
		return memo[start][colorNum] = ret + arr[start][colorNum];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ���� ��
		arr = new int[N+1][3]; // ���� ĥ�ϴ� ���(��, ��, ��)
		memo = new int[N+1][3]; //��,����
		for(int[] i : memo) Arrays.fill(i, -1);
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) arr[i][j] = sc.nextInt();
		}
		
		int ret = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) ret = Math.min(ret, solve(1,i));
		System.out.println(ret);
		
//		for(int i[] : memo) System.out.println(Arrays.toString(i));
	}
}
