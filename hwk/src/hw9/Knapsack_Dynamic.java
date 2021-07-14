package hw9;

import java.util.Scanner;

// E: 0-1 배낭 채우기

public class Knapsack_Dynamic {
	public static Item[] items;
	public static class Item{
		public int profit;
		public int weight;
		public Item(int profit, int weight) {
			this.profit = profit;
			this.weight = weight;
		}
	}
	public static void print(int[][] A) {
		for(int i=A[0].length-1; i>=0; i--) {
			for(int x=0; x<A.length; x++) {
				System.out.print(A[x][i]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int solve(int N, int W) {
		int[][] A = new int[N+1][W+1];
		
		for(int i=1; i<=N; i++) {
			for(int x=0; x<=W; x++) {
				if(items[i].weight > x) A[i][x] = A[i-1][x];
				else A[i][x] = Math.max(A[i-1][x], A[i-1][x-items[i].weight]+items[i].profit);
			}
		}
		return A[N][W];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int W = in.nextInt(); // 가방의 용량
			int N = in.nextInt(); // 물건의 개수
			items = new Item[N+1];
			for(int j=1; j<=N; j++) {
				int p = in.nextInt(); // 이득
				int w = in.nextInt(); // 무게
				items[j] = new Item(p,w);
			}
			System.out.println(solve(N, W));
		}
	}
}
