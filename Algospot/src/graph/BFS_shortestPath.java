package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS_shortestPath { // 가중치가 없는 최단경로
	public static int V; // 노드
	public static int G; // 간선
	public static int S; // 시작 노드
	public static boolean[][] edge; // 간선 연결하는 정점 번호
	
	//너비 우선 탐색 스패닝 트리를 입력받아 실제 최단 경로를 계산
	public static List<Integer> shortestPath(int v, int[] parent) {
		List<Integer> path = new ArrayList<>(); // 경로 저장
		path.add(v);
		while(parent[v] != v) {
			v = parent[v];
			path.add(v);
		}
		Collections.reverse(path);
		
		return path;
	}
	
	//// 각 정점까지의 최단 거리와 너비 우선 탐색 스패닝 트리를 계산
	public static void bfs(int[] parent, int[] distance) {
		Queue<Integer> queue = new LinkedList<>();
		distance[S] = 0;
		parent[S] = S;
		queue.add(S);
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int i=0; i<V;i++) {
				if(edge[v][i]&&distance[i]==-1) {
					queue.add(i);
					distance[i] = distance[v] + 1;
					parent[i] = v;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		G = in.nextInt();
		S = in.nextInt(); // 출발 노드
		int v = in.nextInt(); // 도착 노드
		edge = new boolean[V][V];
		for(int i=0; i<G;i ++) {
			int x = in.nextInt();
			int y = in.nextInt(); 
			edge[x][y] = true;
			edge[y][x] = true;
		}
		
		int[] distance = new int[V];
		Arrays.fill(distance,-1);
		
		int[] parent = new int[V];
		bfs(parent, distance);
		
		for(int d : distance) System.out.print(d+" ");
		System.out.println();
		
		
		System.out.print(S+"에서 "+v+"까지 최단경로: ");
		List<Integer> path = shortestPath(v, parent);
		path.stream().forEach(s->System.out.print(s+" "));
	}


}
