package hw10;

import java.util.Scanner;

// A: ������ ���⼭�� ���缺 ����

public class SequenceAlignment {
	public static void print(int[][] A) {
		for(int i=0; i < A.length; i++) {
			for(int j=0; j < A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int sequenceAlignment(int missMatch, int gap, char[] X, char[] Y) {
		int[][] A = new int[X.length + 1][Y.length + 1];
		
		for(int i=0; i <= X.length; i++) A[i][0] = i * gap; // ��� ���� ��ġ
		for(int j=0; j <= Y.length; j++) A[0][j] = j * gap; // ��� ���� ��ġ

		for(int i=1; i <= X.length; i++) {
			for(int j=1; j <= Y.length; j++) {
				int a = (X[i-1] == Y[j-1]) ? 0 : missMatch; // �� ���ڰ� ������ �г�Ƽ 0
				A[i][j] = Math.min(A[i-1][j-1] + a, Math.min(A[i-1][j] + gap, A[i][j-1] + gap));
//				print(A);
			}
		}
		return A[X.length][Y.length];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int G = in.nextInt(); // ���� �г�Ƽ
			int M = in.nextInt(); // ����ġ �г�Ƽ
			String x = in.next();
			String y = in.next();
			char[] X = x.toCharArray();
			char[] Y = y.toCharArray();
			System.out.println(sequenceAlignment(M, G, X, Y));
		}
	}

}
