//���� �ﰢ��
//�� �������� ������ �Ʒ��� �ִ� ���� �ϳ� �����Ͽ� ������ �� ������ ���� �ִ밡 �Ǵ� ��θ� ���϶�.
//�Ʒ��δ� �밢�� ���� �Ǵ� �밢�� �����ʸ� �����ϴ�.
//�ﰢ���� ũ�� : [1,500] �� : [0,9999]
package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle_1932 {
	public static int N;
	public static int[][] triangle;
	public static int[][] memo;
	
	public static int solve(int y, int x) {
		if(y == N) return 0;
		if(memo[y][x] != -1) return memo[y][x];
		return memo[y][x] = Math.max(solve(y+1, x), solve(y+1,x+1)) + triangle[y][x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //�ﰢ���� ũ�� : N
		triangle = new int[N][N];
		memo = new int[N][N];
		
		for(int[] k : memo)
			Arrays.fill(k, -1);
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<=y; x++)
				triangle[y][x] = sc.nextInt();
		}
		
		System.out.println(solve(0,0));
//		for(int[] k : memo)
//			System.out.println(Arrays.toString(k));
	}
}
