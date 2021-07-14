package dynamic;

// ������

import java.util.Arrays;
import java.util.Scanner;

public class SNAIL {
	public static int N;
	public static int M;
	public static double[][] memo;
	
	private static double solve(int days, int climbed) {
		if(days == M) return climbed >= N ? 1 : 0;
		if(memo[days][climbed] != -1) return memo[days][climbed];
		return memo[days][climbed] = 0.75 * solve(days+1, climbed+2) + 0.25 * solve(days+1, climbed+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt(); //�칰�� ����
			M = sc.nextInt(); //�帶 �Ⱓ�� ����
			memo = new double[M][2*M]; //�׻�  0�̻��� �Ǽ�
			for(double[] k : memo)
				Arrays.fill(k, -1);
			
			System.out.println(solve(0, 0));
		}
	}
}