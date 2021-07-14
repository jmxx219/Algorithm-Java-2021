package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// DFS, BFS

public class DfsBfs_1260 {
	public static int V; // ���
	public static int G; // ����
	public static int S; // ���� ���
	public static boolean[][] edge; // ���� �����ϴ� ���� ��ȣ
	
	public static void dfs1() { // v1: ����
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
	private static void dfs2(int s, boolean[] visited) { // v2: ���
		visited[s] = true;
		System.out.print((s+1) + " ");
		for(int i=0; i<V; i++) {
			if(edge[s][i] && !visited[i])
				dfs2(i, visited);
		}
	}
	
	public static void bfs() { // ť �̿�
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
//		System.out.print("����: ");
//		dfs1();
//		System.out.println();
//		
//		System.out.print("���: ");
		boolean[] visited = new boolean[V];
 		dfs2(S, visited);
 		System.out.println();
 		
 		bfs();
	}

}

