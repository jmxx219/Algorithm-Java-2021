package greedy;

import java.util.Scanner;

public class GasStation_13305 {
	public static int N;
	public static int[] roads;
	public static int[] cities;
	
	public static void solve() {
		long min = cities[0];
		long sum = 0;
		for(int i=0; i<N-1; i++) {
			if(min > cities[i]) min = cities[i];
			sum += (roads[i] * min);
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		roads = new int[N-1];
		for(int i=0; i<N-1; i++) roads[i] = in.nextInt();
		
		cities = new int[N];
		for(int i=0; i<N; i++) cities[i] = in.nextInt();
		solve();
	}

}
