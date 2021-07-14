package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS_shortestPath { // ����ġ�� ���� �ִܰ��
	public static int V; // ���
	public static int G; // ����
	public static int S; // ���� ���
	public static boolean[][] edge; // ���� �����ϴ� ���� ��ȣ
	
	//�ʺ� �켱 Ž�� ���д� Ʈ���� �Է¹޾� ���� �ִ� ��θ� ���
	public static List<Integer> shortestPath(int v, int[] parent) {
		List<Integer> path = new ArrayList<>(); // ��� ����
		path.add(v);
		while(parent[v] != v) {
			v = parent[v];
			path.add(v);
		}
		Collections.reverse(path);
		
		return path;
	}
	
	//// �� ���������� �ִ� �Ÿ��� �ʺ� �켱 Ž�� ���д� Ʈ���� ���
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
		S = in.nextInt(); // ��� ���
		int v = in.nextInt(); // ���� ���
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
		
		
		System.out.print(S+"���� "+v+"���� �ִܰ��: ");
		List<Integer> path = shortestPath(v, parent);
		path.stream().forEach(s->System.out.print(s+" "));
	}


}
