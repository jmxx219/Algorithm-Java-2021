package hw12;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TSP_Branch {
	public static int N;
	public static int[][] G;
	public static int[] minBound;
	public static final int INF = 987654321;
	
	public static class Node implements Comparable<Node>, Cloneable{
		public int level; // 레벨
		public int bound; // 가능한 최솟값
		public int currSum;
		public List<Integer> tour;
		public boolean[] visited;

		public Node(int level, int bound, int currSum, List<Integer> tour, boolean[] visited) {
			this.level = level;
			this.bound = bound;
			this.currSum = currSum;
			this.tour = tour;
			this.visited = visited;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(bound, o.bound);
		}

		@Override
		public Node clone() throws CloneNotSupportedException {
			Node cloned = (Node) super.clone();
			cloned.tour = new ArrayList<>(this.tour);
			cloned.visited = this.visited.clone();
			return cloned; 
		}
	}
	
	public static int computeBound(Node node) {
		int sum = node.currSum;
		
		int curr = node.tour.get(node.tour.size()-1);
	
		for(int y=0; y<N; y++) { // 방문하지 않는 노드 들 중에서 갈 수 있는 가장 작은 값
			if(node.visited[y] && y != curr ) continue; 
			int min = INF;
			for(int x=0; x<N; x++) {
				if(y == node.tour.get(node.tour.size()-1) && x == 0) continue;
				if(y == x || G[y][x] == -1 || (x!= 0 && node.visited[x])) continue;
				min = Math.min(G[y][x], min);
			}
			sum += min;
		}
		return sum;
	}
	
	public static int tsp() throws CloneNotSupportedException {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		boolean[] visited = new boolean[N];
		visited[0] = true;
		List<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		
		Node root = new Node(0,0,0,tmp,visited);
		root.bound = computeBound(root);
		
		pq.offer(root);
		int minLength = INF;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(node.bound < minLength) {
				for(int i=0; i<N; i++) {
					// 방문했거나  경로없거나, 대각선일 때 
					if(node.visited[i] || G[node.tour.get(node.level)][i] == -1 || G[node.tour.get(node.level)][i] == 0) continue;
					
					Node next = node.clone();
					next.level += 1;
					next.tour.add(i);
					next.currSum += G[node.tour.get(node.tour.size()-1)][i];
					next.visited[i] = true;
					
					if(next.level == N-2) { // 투어가 끝나면				
						next.bound = computeBound(next);
						if(next.bound < minLength) {
							minLength = next.bound; 
						}
					}
					else {
						next.bound = computeBound(next);
						if(next.bound < minLength) pq.offer(next);
					}
				}
			}
		}
		return minLength;
	}


	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			N = in.nextInt();
			G = new int[N][N];
			minBound = new int[N];
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					G[y][x] = in.nextInt();
				}
			}
			System.out.println(tsp());
		}
	}
}

