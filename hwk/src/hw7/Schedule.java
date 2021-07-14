package hw7;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// 문제 B: 마감 시간이 있는 최적 스케줄 짜기

public class Schedule {
	public static class Work implements Comparable<Work>{ 
		int d; // 마감 시간
		int p; // 아둑
		int id;
		public Work(int d, int p, int id) {
			this.d = d;
			this.p = p;
			this.id = id;
		}
		public int getP() {
			return p;
		}
		public int getD() {
			return d;
		}
		public int getId() {
			return id;
		}

		@Override
		public int compareTo(Work o) {
			return (p==o.p) ? Integer.compare(id, o.id) : Integer.compare(o.p, p);
		}
	}


	public static void solve(Work[] works, int N, int maxD) {
		boolean[] scheduled = new boolean[maxD+1];
		LinkedList<Integer> res = new LinkedList<Integer>();
		res.add(works[0].id);
		scheduled[works[0].d] = true;
		for(int i=1; i<N; i++) {
			for(int j=works[i].d; j>=1; j--) {
				if(!scheduled[j]) {
					scheduled[j] = true;
					res.add(works[i].id);
					break;
				}
			}
		}

		Collections.sort(res);
		for(Integer id : res) System.out.print(id+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt();
			Work[] works = new Work[N];
			int maxD = Integer.MIN_VALUE;
			for(int j=0; j<N; j++) {
				int D = in.nextInt();
				int P = in.nextInt();
				maxD = Math.max(maxD, D);
				works[j] = new Work(D, P, j+1);
			}
			Arrays.sort(works);
			solve(works, N, maxD);
		}
	}

}
