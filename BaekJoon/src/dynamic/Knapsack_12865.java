package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Knapsack_12865 { // 메모이로
	public static int N; //물품의 수
	public static int K; //무게
	public static Item[] items;
	public static int[][] memo;

	public static class Item{
		public int profit;
		public int weight;
		public Item(int profit, int weight) {
			this.profit = profit;
			this.weight = weight;
		}
	}

	private static int solve(int num, int capacity) {
		if(num == N) return 0;
		if(memo[num][capacity] != -1) return memo[num][capacity];
		int ret = solve(num+1, capacity);
		if(capacity >= items[num].weight)
			ret = Math.max(ret, solve(num+1, capacity - items[num].weight) + items[num].profit);
		return memo[num][capacity] = ret;
	}

	public static void reconstruct(int num, int capacity, List<Integer> list) {
		if(num == N) return;
		if(solve(num, capacity) == solve(num+1, capacity))
			reconstruct(num+1, capacity, list);
		else {
			list.add(num+1);
			reconstruct(num+1, capacity - items[num].weight, list);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		items = new Item[N];
		memo = new int[N][K+1];
		for(int[] i : memo) Arrays.fill(i, -1);
		for(int i=0; i<N; i++) {
			int W = sc.nextInt(); //무게
			int V = sc.nextInt(); //가치
			items[i] = new Item(V,W);
		}
		System.out.println(solve(0,K));
		List<Integer> list = new ArrayList<>();
		reconstruct(0,K,list);
		list.stream().forEach(s -> System.out.print(s + " "));
	}
}
