package hw11;

//B: 0-1 배낭 채우기 - 되추적

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack_Backtracking {
	public static int maxProfit = 0;
	public static int W; // 가방 용량
	public static int N; // 뮬건 갯수
	public static Item[] items;

	public static class Item implements Comparable<Item>{
		int weight;
		int profit;
		double score;
		public Item(int p, int w) {
			this.weight = w;
			this.profit = p;
			this.score = (double)profit/weight;
		}
		@Override
		public int compareTo(Item o) {
			return Double.compare(o.score, score); // 내림차순(무게당 이득 기준 정렬)
		}
	}

	public static boolean promising(int currProfit, int currWeight, int index) { // bound 구하는 부분
		if(currWeight >= W) return false;

		int nextIndex = index + 1;
		int bound  = currProfit;
		int totalWeight = currWeight;

		while(nextIndex < N && totalWeight+items[nextIndex].weight <= W) {
			totalWeight += items[nextIndex].weight;
			bound += items[nextIndex].profit;
			nextIndex++;
		}

		if(nextIndex < N) {
			bound += (int)((W-totalWeight) * items[nextIndex].score);
		}
		return bound > maxProfit;
	}

	public static void knapsack(boolean[] include, int currProfit, int currWeight, int index) {
		if(currWeight <= W && currProfit > maxProfit) {
			maxProfit = currProfit;
		}
		if(promising(currProfit, currWeight, index)) {
			include[index+1] = true;
			knapsack(include, currProfit+items[index+1].profit, currWeight+items[index+1].weight, index+1);
			include[index+1] = false;
			knapsack(include, currProfit, currWeight, index+1);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			W = in.nextInt(); // 가방의 용량
			N = in.nextInt(); // 물건의 개수
			items = new Item[N];
			boolean[] include = new boolean[N];
			for(int j=0; j<N; j++) {
				int p = in.nextInt(); // 물건의 이득
				int w = in.nextInt(); // 물건의 무게
				items[j] = new Item(p, w);
			}
			maxProfit = 0;
			Arrays.sort(items); // 무게 당 이득 기준 으로정렬 (이득/무게)
			knapsack(include, 0, 0, -1);
			System.out.println(maxProfit);
		}
	}
}
