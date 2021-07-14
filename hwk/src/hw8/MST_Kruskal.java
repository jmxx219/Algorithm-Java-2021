package hw8;

import java.util.Arrays;
import java.util.Scanner;

// ���� A: ����ġ ������ �׷������� �ּҽ���Ʈ�� ���ϱ�(Kruskal)
// union-find�� �̿��Ͽ� ����

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
	public static int find(int[] parent, int x) { // �θ� ã��
		if(parent[x] == x) return x;
		parent[x] = find(parent, parent[x]);
		return parent[x];
	}
	//S,V : ������ ���տ� ���� �θ� ���
	public static void union(int sP, int vP, int[] parent, int[] childSize) { // ����
		int p = sP; // �θ�
		int c = vP; // �ڽ�
		if(childSize[sP] < childSize[vP]) { // �ڽ� ũ�Ⱑ �� ū ���� �θ��
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
			int N = in.nextInt(); // ��� ��
			int E = in.nextInt(); // ���� ��
			Edge[] edge = new Edge[E];
			int[] parent = new int[N];
			int[] childSize = new int[N]; // �����ִ� �ڽ��� ũ��
			for(int j=0; j<N; j++) {
				parent[j] = j; // �θ� �ʱ�ȭ
				childSize[j] = 1;
			}
			for(int j=0; j<E; j++) {
				int a = in.nextInt(); // ������ ���� ���
				int b = in.nextInt(); // ������ �� ���
				int c = in.nextInt(); // ������ ����ġ
				edge[j] = new Edge(a, b, c);
			}
			Arrays.sort(edge);
			mst(edge,parent,childSize,E);
		}
	}

}
