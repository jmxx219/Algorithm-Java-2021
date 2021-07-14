package hw10;

import java.util.Scanner;

// C: ���� �׷������� �ִ� ��� ã��
// Floyd-Warshall

public class ShortestPath {
	public static final int INF = 987654321;
	public static void print(int N, int[][] edge) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(edge[i][j]==INF) System.out.print("INF"+ " ");
				else System.out.print(edge[i][j]+ "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void init(int N, int[][] edge) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i!=j) edge[i][j] = INF;
			}
		}
	}
	public static void path(int N, int[][] D) {
		int maxD = 0;
		int s = 0;
		int d = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(D[i][j] != INF) {
					if(D[i][j] > maxD) {
						maxD = D[i][j];
						s = i;
						d = j;
					}
				}
			}
		};
		System.out.println(s +" "+ d +" "+ maxD); // ���۳��, �����, ��� ����
	}
	public static void floydWarshall(int N, int[][] D) {
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(D[i][k] == INF || D[k][j] == INF) continue;
					D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(D[i][i]<0) {
				System.out.println(-1); // ���� �׷����� ���� �ֱⰡ �����ϸ� -1�� ���
				return;
			}
		}
		
		path(N,D); // ���� �ֱⰡ ���� ���, �� ��尣 �ִ� ��ΰ� ���� �� ����� ������ ���
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // ��� ��
			int E = in.nextInt(); // ���� ��
			int[][] edge = new int[N][N];
			init(N, edge);
			for(int j=0; j<E; j++) {
				int S = in.nextInt(); // ���۳��
				int D = in.nextInt(); // �����
				int W = in.nextInt(); // ����ġ
				edge[S][D] = W;
			}
			floydWarshall(N, edge);
		}
	}

}
