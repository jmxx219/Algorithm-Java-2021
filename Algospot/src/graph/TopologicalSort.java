package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// ���� ����

public class TopologicalSort {
	public static int V; // ���
	public static int G; // ����
	public static boolean[][] edge; // ���� �����ϴ� ���� ��ȣ
	
	
	public static void DFS(List<Integer> list, boolean[] visited, int curr) { // ���
		visited[curr] = true;
		for(int next=0; next<V; next++) {
			if(curr != next && !visited[next] && edge[curr][next]) {
				DFS(list, visited, next); // ���
			}
		}
		list.add(curr);
	}
	
	public static List<Integer> topologicalSort() { // ���
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(!visited[i]) DFS(list, visited, i);
		}
		return list;
	}
	
	public static void topologicalSortV2(){ // �����
		int[] label = new int[V];
		boolean[] visited = new boolean[V];
		int currentLabel = V;
		
		for(int i=0; i<V; i++) { // � ��忡�� ����ص� ��� x
			if(!visited[i]) {
				Stack<Integer> stack = new Stack<>();
				Queue<Integer> queue = new LinkedList<>(); // ��ȣ �Ҵ��� ���� ���
				stack.add(i);
				
				while(!stack.isEmpty()) { // DFS
					int x = stack.pop();
					if(x < 0) queue.add(-x-1); // 0 ������, ��� ������ -x��
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
		V = in.nextInt(); // ���
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
