package hw11;

import java.util.Scanner;

// ������
// A: ���ո�

public class NQueens {
	public static void printMap(int[] cols){
		for(int i=0; i<cols.length; i++) {
			for(int j=0; j<cols.length; j++) {
				if(cols[i] == j) System.out.print("Q");
				else System.out.print("X");
			}
			System.out.println();
		}
	}

	public static boolean promising(int[] cols, int row) { // �⺻������ �ٸ� �࿡ ��ġ, ������ x
		boolean flag = true;
		int r = 0;
		while(r<row && flag) {
			if(cols[r]==cols[row] || Math.abs(cols[r]-cols[row]) == (row-r)) {
				flag =  false;
			}
			++r;
		}
		return flag;
	}

	public static int nQueens(int[] cols, int row) { // ���� ���θ� ���ǰ� ���ȣ��
		int cnt = 0;
		for(int c =0; c < cols.length; c++) {
			cols[row] = c;
			if(promising(cols, row)) {
				if(row+1 == cols.length) {
					printMap(cols);
					return 1;
				}
				else cnt += nQueens(cols, row+1);
			}
		}
		return cnt;
	}
	
	public static int nQueens2(int[] cols, int row) { // ���ȣ���� �� ������ ���� ���� ����
		int cnt = 0;
		if(promising(cols, row)) {
			if(row+1 == cols.length) {
				printMap(cols);
				return 1;
			}
			else {
				for(int c = 0; c < cols.length; c++) {
					cols[row+1] = c;
					cnt += nQueens2(cols, row+1);
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt();
			int[] cols = new int[N];
			int cnt = 0;
//			cnt += nQueens(cols, 0);
			 cnt += nQueens2(cols, -1);
			if(cnt == 0) System.out.println();
		}
	}
}
