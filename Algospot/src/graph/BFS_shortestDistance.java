package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS_shortestDistance {
	public static int V; // 노드
	public static int G; // 간선
	public static int S; // 시작 노드
	public static int[] distance;
	public static boolean[][] edge; // 간선 연결하는 정점 번호
	
	public static void shortestDistance() {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[S] = true;
		distance[S] = 0;
		queue.add(S);
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int i=0; i<V;i++) {
				if(edge[v][i]&&!visited[i]) {
					visited[i] = true;
					distance[i] = distance[v] + 1;
					queue.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		G = in.nextInt();
		S = in.nextInt()-1;
		edge = new boolean[V][V];
		for(int i=0; i<G;i ++) {
			int x = in.nextInt();
			int y = in.nextInt(); 
			edge[x][y] = true;
			edge[y][x] = true;
		}
		distance = new int[V];
		shortestDistance();
		for(int d : distance) System.out.print(d+" ");
	}

}
