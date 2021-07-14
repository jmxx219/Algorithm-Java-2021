package hw6;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// C: 가중치 그래프에서 최단 경로 길이 구하기 - 다익스트라(우선순위큐)

public class FindShortestDistance {
	public static int N; // 노드
	public static int E; // 간선
	public static int S; // 출발 노드
	public static int K; // 목적 노드의 수
	public static int d[]; // K개 만큼의 목적 노드
	public static int[][] edge; // 간선 여부

	public static class Point implements Comparable<Point>{
		int cost;
		int here;
		public Point(int here, int cost) {
			this.here = here; // 노드
			this.cost = cost; // 거리
		}
		public int getHere(){ return this.here; }
		public int getCost(){ return this.cost; }
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}
	
	public static void findShortestDistance() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S] = 0;
		pq.offer(new Point(S, dist[S]));

		while(!pq.isEmpty()) {
			Point node = pq.poll();
			int cost = node.cost;
			int here = node.here;
			
			if(dist[here] < cost) continue;

			for(int i=0; i<N; i++) {
				if(edge[here][i]!=0) {
					int nextDist = edge[here][i] + cost;
					if(dist[i] > nextDist) {
						dist[i] = nextDist;
						pq.add(new Point(i, nextDist));
					}
				}

			}
		}
		for(int distance : d) {
			if(dist[distance] == Integer.MAX_VALUE) System.out.print(-1+" ");
			else System.out.print(dist[distance]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			N = in.nextInt();
			E = in.nextInt();
			S = in.nextInt();
			K = in.nextInt();
			d = new  int[K];
			edge = new int[N][N];
			for(int j=0; j<K; j++) d[j] = in.nextInt();
			for(int j=0; j<E; j++) {
				int x = in.nextInt();
				int y = in.nextInt();
				int d = in.nextInt(); 
				edge[x][y] = d;
			}
			findShortestDistance();
		}
	}

}
