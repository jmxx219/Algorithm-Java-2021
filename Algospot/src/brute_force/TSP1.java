package brute_force;

// Traveling Salesman Problem 1 - �����ϴ� ���ǿ�

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TSP1 {
	public static double[][] dist; // �� ���� ���� �Ÿ��� �����ϴ� �迭
	public static int N;
	public static double shortesPath(List<Integer> path, boolean[] visited, double currentLength) {
		if(path.size() == N) return  currentLength;
		//  + dist[path.get(0)][path.get(path.size()-1)]; 
		double ret = Double.MAX_VALUE;
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
	public static double solve() {
		double ret = Double.MAX_VALUE;
		for(int i=0; i<N; i++) {
			boolean[] visited = new boolean[N]; // �� ���� �湮 ����
			List<Integer> path = new ArrayList<>(); // ���ݱ��� ���� ���
			visited[i] = true;
			path.add(i);
			ret = Math.min(ret, shortesPath(path, visited, 0));
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int i=0; i<C; i++) {
			N = sc.nextInt();
			dist = new double[N][N];
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++)
					dist[j][k] = sc.nextDouble();
			}
			System.out.println(solve());
		}
	}
}
