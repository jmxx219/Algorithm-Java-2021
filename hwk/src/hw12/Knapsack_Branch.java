package hw12;

// B: 0-1배낭 - 분기한정

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Knapsack_Branch {
	public static int W;
	public static int N;
	public static Item[] items;

	public static class Node implements Comparable<Node> {
		public int level;
		public int currProfit;
		public int currWeight;
		public int bound;

		public Node(int level, int currProfit, int currWeight, int bound) {
			this.level = level;
			this.currProfit = currProfit;
			this.currWeight = currWeight;
			this.bound = bound;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.bound, bound);
		}
	}

	public static class Item implements Comparable<Item>{ // 물건
		public int profit;
		public int weight;
		public double score;
		public Item(int profit, int weight) {
			this.profit = profit;
			this.weight = weight;
			this.score = (double) profit / weight;
		}
		@Override
		public int compareTo(Item o) {
			return Double.compare(o.score, score);
		}
	}
	
	public static int computeBound(int currProfit, int currWeight, int index) {
		if(currWeight >= W) return 0;
		
		int nextIndex = index + 1;
		int bound = currProfit;
		int totalWeight = currWeight;
		
		while(nextIndex < N && totalWeight+items[nextIndex].weight <= W) {
			totalWeight += items[nextIndex].weight;
			bound += items[nextIndex].profit;
			nextIndex++;
		}
		
		if(nextIndex < N) {
			bound += (int)((W-totalWeight) * items[nextIndex].score);
		}
		return bound;
	}

	public static void knapsack() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node root = new Node(-1,0,0, computeBound(0,0,-1)); //  level, currProfit, currWeight, bound
		pq.offer(root);
		int maxProfit = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int level = node.level+1;
			int currWeight = node.currWeight + items[level].weight;
			int currProfit = node.currProfit + items[level].profit;
			
			if(currWeight <= W && currProfit > maxProfit) maxProfit = currProfit; // solution
			
			int bound = computeBound(currProfit, currWeight, level);
			if(bound > maxProfit) pq.offer(new Node(level, currProfit, currWeight, bound));
			
			currWeight -= items[level].weight; // 해당 노드 안넣을 때
			currProfit -= items[level].profit;
			bound = computeBound(currProfit,currWeight, level);
			if(bound > maxProfit) pq.offer(new Node(level, currProfit, currWeight, bound));
		}
		System.out.println(maxProfit);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			W = in.nextInt();
			N = in.nextInt();
			items = new Item[N];
			for(int j=0; j<N; j++) {
				int v = in.nextInt(); // 이득
				int w = in.nextInt(); // 무게
				items[j] = new Item(v, w); 
			}
			Arrays.sort(items);
			knapsack();
		}
	}

}
