package brute_force;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 외판원 순회2

public class TSP2_10971 {
	public static int[][] dist;
	public static int N;

	private static int shortesPath(List<Integer> path, boolean[] visited, int currentLength) {
		if(path.size() == N) {
			int end = dist[path.get(path.size()-1)][path.get(0)];
			if(end==0) return Integer.MAX_VALUE;
			else return end + currentLength;
		}
		int ret = Integer.MAX_VALUE;
		for(int next=0; next<N; next++) {
			int here = path.get(path.size()-1);
			if(visited[next] || dist[here][next]==0) continue;
			path.add(next);
			visited[next] = true;
			
			ret = Math.min(ret, shortesPath(path, visited, currentLength + dist[here][next]));
			
			path.remove(path.size()-1);
			visited[next] = false;
		}
		return ret;
	}
	
	public static void solve() {
		int ret = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			boolean[]visited = new boolean[N];
			List<Integer> path = new ArrayList<>();
			visited[i] = true;
			path.add(i);
			ret = Math.min(ret, shortesPath(path, visited, 0));
		}
		System.out.print(ret);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dist = new int[N][N];
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				dist[i][j] = in.nextInt();
			}
		}
		solve();
	}
}
