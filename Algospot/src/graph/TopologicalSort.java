package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 위상 정렬

public class TopologicalSort {
	public static int V; // 노드
	public static int G; // 간선
	public static boolean[][] edge; // 간선 연결하는 정점 번호
	
	
	public static void DFS(List<Integer> list, boolean[] visited, int curr) { // 재귀
		visited[curr] = true;
		for(int next=0; next<V; next++) {
			if(curr != next && !visited[next] && edge[curr][next]) {
				DFS(list, visited, next); // 재귀
			}
		}
		list.add(curr);
	}
	
	public static List<Integer> topologicalSort() { // 재귀
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(!visited[i]) DFS(list, visited, i);
		}
		return list;
	}
	
	public static void topologicalSortV2(){ // 비재귀
		int[] label = new int[V];
		boolean[] visited = new boolean[V];
		int currentLabel = V;
		
		for(int i=0; i<V; i++) { // 어떤 노드에서 출발해도 상관 x
			if(!visited[i]) {
				Stack<Integer> stack = new Stack<>();
				Queue<Integer> queue = new LinkedList<>(); // 번호 할당을 위해 사용
				stack.add(i);
				
				while(!stack.isEmpty()) { // DFS
					int x = stack.pop();
					if(x < 0) queue.add(-x-1); // 0 때문에, 모두 양수라면 -x로
					else if(!visited[x]) {
						visited[x] = true;
						stack.add(-x-1);
						for(int j=0; j<V; j++) {
							if(edge[x][j]&&!visited[j]) stack.add(j);
						}
					}
				}
				
				while(!queue.isEmpty()) {
					int x = queue.poll();
					label[x] = currentLabel;
					currentLabel -= 1;
				}
			}
		}
		for(int x : label) System.out.print(x +" ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		V = in.nextInt(); // 노드
		G = in.nextInt();
		edge = new boolean[V][V];
		for(int i=0; i<G;i ++) {
			int x = in.nextInt();
			int y = in.nextInt(); 
			edge[x][y] = true;
		}
		List<Integer> list  = topologicalSort();
		Collections.reverse(list);
		list.stream().forEach(s->System.out.print(s+" "));
		System.out.println();
		topologicalSortV2();
	}
}
