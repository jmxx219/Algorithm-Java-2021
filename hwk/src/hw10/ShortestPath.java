package hw10;

import java.util.Scanner;

// C: 방향 그래프에서 최단 경로 찾기
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
		System.out.println(s +" "+ d +" "+ maxD); // 시작노드, 끝노드, 경로 길이
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
				System.out.println(-1); // 방향 그래프의 음의 주기가 존재하면 -1을 출력
				return;
			}
		}
		
		path(N,D); // 음의 주기가 없을 경우, 두 노드간 최단 경로가 가장 먼 경로의 정보를 출력
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // 노드 수
			int E = in.nextInt(); // 간선 수
			int[][] edge = new int[N][N];
			init(N, edge);
			for(int j=0; j<E; j++) {
				int S = in.nextInt(); // 시작노드
				int D = in.nextInt(); // 끝노드
				int W = in.nextInt(); // 가중치
				edge[S][D] = W;
			}
			floydWarshall(N, edge);
		}
	}

}
