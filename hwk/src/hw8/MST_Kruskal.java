package hw8;

import java.util.Arrays;
import java.util.Scanner;

// 문제 A: 가중치 무방향 그래프에서 최소신장트리 구하기(Kruskal)
// union-find을 이용하여 구현

public class MST_Kruskal {
	public static class Edge implements Comparable<Edge>{
        public int S;
        public int V;
        public int cost;
        Edge(int S, int V, int cost){
            this.S = S;
            this.V = V;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
	public static int find(int[] parent, int x) { // 부모 찾기
		if(parent[x] == x) return x;
		parent[x] = find(parent, parent[x]);
		return parent[x];
	}
	//S,V : 각각의 집합에 대한 부모 노드
	public static void union(int sP, int vP, int[] parent, int[] childSize) { // 결합
		int p = sP; // 부모
		int c = vP; // 자식
		if(childSize[sP] < childSize[vP]) { // 자식 크기가 더 큰 쪽이 부모로
			p = vP;
			c = sP;
		}
		parent[c] = p;
		childSize[p] += childSize[c];
		childSize[c] = 0;
	}
	public static void mst(Edge[] edge, int[] parent, int[] childSize, int E) {
		int res = 0;
		for(int i=0; i<E; i++) {
			int sP = find(parent, edge[i].S);
			int vP = find(parent, edge[i].V);
			if(sP != vP) {
				res += edge[i].cost;
				union(sP, vP, parent, childSize);
			}
		}
	
		System.out.println(res);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // 노드 수
			int E = in.nextInt(); // 간선 수
			Edge[] edge = new Edge[E];
			int[] parent = new int[N];
			int[] childSize = new int[N]; // 갖고있는 자식의 크기
			for(int j=0; j<N; j++) {
				parent[j] = j; // 부모 초기화
				childSize[j] = 1;
			}
			for(int j=0; j<E; j++) {
				int a = in.nextInt(); // 간선의 시작 노드
				int b = in.nextInt(); // 간선의 끝 노드
				int c = in.nextInt(); // 간선의 가중치
				edge[j] = new Edge(a, b, c);
			}
			Arrays.sort(edge);
			mst(edge,parent,childSize,E);
		}
	}

}
