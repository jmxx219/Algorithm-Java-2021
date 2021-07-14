package hw8;

import java.util.PriorityQueue;
import java.util.Scanner;

// 문제 A: 가중치 무방향 그래프에서 최소신장트리 구하기
// heap을 이용하여 구현, 인접 행렬로 그래프를 처리해야 효과적으로 구현
// 가중치 무방향 그래프의 최소신장트리를 구하고, 그 트리의 모든 간선의 합을 출력하여 주세요.

public class MST_Prim {
	public static final int INF = Integer.MAX_VALUE;
	public static class Node implements Comparable<Node>{
        public int node;
        public int cost;
        Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
	public static void mst(int[][] edge, int N, int S) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] key = new int[N];
		boolean[] visited = new boolean[N];
		
		visited[S] = true;
		for(int v=0; v<N; v++) {
			if(v != S) {
				if(edge[S][v]!=0) key[v] = edge[S][v];
				else key[v] = INF;
				pq.add(new Node(v, key[v]));
			}
		}

		while(!pq.isEmpty()) {
			Node w = pq.poll();
			visited[w.node] = true;
			for(int y=0; y<N; y++) {
				if(!visited[y]&&edge[w.node][y]!=0) {
					if(edge[w.node][y] < key[y]) {
						key[y] = edge[w.node][y];
						pq.add(new Node(y, key[y]));
					}
				}
			}
		}
		
		int res = 0;
		for(int i: key) res += i;
		System.out.println(res);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // 노드 수
			int E = in.nextInt(); // 간선 수
			int[][] edge = new int[N][N];
			for(int j=0; j<E; j++) {
				int a = in.nextInt(); // 간선의 시작 노드
				int b = in.nextInt(); // 간선의 끝 노드
				int c = in.nextInt(); // 간선의 가중치
				edge[a][b] = c;
				edge[b][a] = c;
			}
			mst(edge,N, 0);
		}
	}

}
