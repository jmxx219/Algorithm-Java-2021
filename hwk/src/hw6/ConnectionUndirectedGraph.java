package hw6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// A: 무방향 그래프의 연결 여부

public class ConnectionUndirectedGraph { // 연결그래프 노드
	public static List<Integer> bfs(boolean[] visited, int s, int N, boolean[][] edge) {
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			list.add(v);
			for(int i=0; i<N; i++) {
				if(edge[v][i]&&!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		list.stream().forEach(x->System.out.print(x+" "));
		System.out.println();
		return list;
	}
	public static void connection(int N, boolean[][] edge) {
		List<List<Integer>> components = new ArrayList<>();
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++) {
			if(!visited[i]) components.add(bfs(visited, i, N, edge));
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // 노드
			int E = in.nextInt(); // 간선
	 		boolean[][] edge = new boolean[N][N];
			for(int j=0; j<E; j++) {
				int x = in.nextInt();
				int y = in.nextInt(); 
				edge[x][y] = true;
				edge[y][x] = true;
			}
			connection(N, edge);
		}
		
	}
}


class ConnectionUndirectedGraphV2 { // 연결 그래프 갯수
	public static int bfs(boolean[] visited, int s, int N, boolean[][] edge) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			cnt++;
			for(int i=0; i<N; i++) {
				if(edge[v][i]&&!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		return cnt;
	}
	public static void connection(int N, boolean[][] edge) {
		boolean[] visited = new boolean[N];
		int max = 0;
		int cntGraph = 0;
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				max = Math.max(max, bfs(visited, i, N, edge));
				cntGraph++;
			}
		}
		System.out.println(cntGraph+" "+max);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // 노드
			int E = in.nextInt(); // 간선
	 		boolean[][] edge = new boolean[N][N];
			for(int j=0; j<E; j++) {
				int x = in.nextInt();
				int y = in.nextInt(); 
				edge[x][y] = true;
				edge[y][x] = true;
			}
			connection(N, edge);
		}
		
	}
}


