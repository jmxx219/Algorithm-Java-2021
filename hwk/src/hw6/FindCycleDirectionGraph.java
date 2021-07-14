package hw6;

import java.util.Scanner;

// B: ���� �׷������� �ֱ� ã��

public class FindCycleDirectionGraph {
	public static int N; // ���
	public static int E; // ����
	public static boolean[][] edge; // ���� ����
	
	public static boolean findCycle(int here, boolean[] visited, boolean[] finished) {
		visited[here] = true;

	      for(int next=0; next<N; next++) {
	         if(edge[here][next]) {
	            if(!visited[next]) {
	            	if(findCycle(next, visited, finished)) return true; 
	            }
	            else if(!finished[next]) return true;
	         }
	      }
	      finished[here] = true; 
	      
	      return false;
	}
	public static boolean solve() {
		boolean[] visited = new boolean[N];
		boolean[] finished = new boolean[N];

		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				if(findCycle(i, visited, finished)) return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			N = in.nextInt(); // ���
			E = in.nextInt(); // ����
	 		edge = new boolean[N][N];
			for(int j=0; j<E; j++) {
				int x = in.nextInt();
				int y = in.nextInt(); 
				edge[x][y] = true;
			}
			System.out.println(solve());
		}
	}

}
