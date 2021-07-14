package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide_1697 {

	public static void solve(int N, int K) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		int[] arr = new int[100001];
		arr[N] = 0;

		while(!q.isEmpty()) {
			int x = q.poll();
			if(x==K) {
				System.out.println(arr[x]);
				return;
			}
			if(x > 0 && arr[x-1] == 0) {
				q.add(x-1);
				arr[x-1] = arr[x]+1;
			}

			if(x < 100000 && arr[x+1] == 0) {
				q.add(x+1);
				arr[x+1] = arr[x]+1;
			}
			if(x * 2 <= 100000 && arr[x*2] == 0) {
				q.add(x*2);
				arr[x*2] = arr[x]+1;
			}

		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		solve(N, K);
	}

}
