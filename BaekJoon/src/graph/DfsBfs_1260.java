package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// DFS, BFS

public class DfsBfs_1260 {
	public static int V; // 노드
	public static int G; // 간선
	public static int S; // 시작 노드
	public static boolean[][] edge; // 간선 연결하는 정점 번호
	
	public static void dfs1() { // v1: 스택
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		visited[S] = true;
		stack.add(S);
		while(!stack.empty()) {
			int s = stack.pop();
			System.out.print((s+1)+" ");
			for(int i=0; i<V; i++) {
				if(edge[s][i]&&!visited[i]) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}
	}
	private static void dfs2(int s, boolean[] visited) { // v2: 재귀
		visited[s] = true;
		System.out.print((s+1) + " ");
		for(int i=0; i<V; i++) {
			if(edge[s][i] && !visited[i])
				dfs2(i, visited);
		}
	}
	
	public static void bfs() { // 큐 이용
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[S] = true;
		queue.add(S);
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print((v+1)+" ");
			for(int i=0; i<V; i++) {
				if(edge[v][i]&&!visited[i]) {
					visited[i] = true;
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
			edge[x-1][y-1] = true;
			edge[y-1][x-1] = true;
		}
//		System.out.print("스택: ");
//		dfs1();
//		System.out.println();
//		
//		System.out.print("재귀: ");
		boolean[] visited = new boolean[V];
 		dfs2(S, visited);
 		System.out.println();
 		
 		bfs();
	}

}

