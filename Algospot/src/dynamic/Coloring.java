package dynamic;
import java.util.Scanner;

// �׷��� ��ĥ�ϱ�
// ������ �׷����� ��带 �ִ��� m���� ������ ��ĥ�ϴ� ����

public class Coloring {
	public static boolean promising(boolean[][] graph, int[] colors, int m, int index) {
		boolean flag = true;
		int v = 0;
		while(v<index && flag) {
			if(graph[index][v] && colors[index] == colors[v]) return false;
			v++;
		}
		return flag;
	}
	public static void mColoring(boolean[][] graph, int[] colors, int m, int index) {
		if(promising(graph, colors, m, index)) {
			if(index + 1 == colors.length) {
				for(int i=0; i<colors.length; i++) System.out.print(colors[i] +" ");
				System.out.println();
			}
			else {
				for(int c = 1; c <= m; c++) {
					colors[index + 1] = c;
					mColoring(graph, colors, m, index+1);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // ��� ����
		int G = in.nextInt(); // ���� ����
		int m = in.nextInt(); // ĥ�� �� �ִ� �� ��
		boolean[][] graph = new boolean[N][N];
		int[] colors = new int[N];
		for(int i = 0; i<G; i++) {
			int s = in.nextInt();
			int v = in.nextInt();
			graph[s][v] = true;
			graph[v][s] = true;
		}
		mColoring(graph, colors, m, -1);
	}

}
