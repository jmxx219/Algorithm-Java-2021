package Divide_and_conquer;

import java.util.Scanner;

public class boj_12846 {
	public static int[] m;

	public static int solve(int start, int end) {
		if(start>=end) return m[start];

		int mid = start + (end-start)/2;
		int ret = Math.max(solve(start, mid), solve(mid+1, end));

		int lo = mid, hi = mid+1;
		int money = Math.min(m[lo], m[hi]);
		ret = Math.max(ret, money*2);
		
		while(start < lo || hi < end) {
			if(start < lo && hi < end) {
				if(m[lo-1]<m[hi+1]) money = Math.min(money, m[++hi]);
				else money = Math.min(money, m[--lo]);
			}
			else if(start < lo) money = Math.min(money, m[--lo]);
			else money = Math.min(money, m[++hi]);
			ret = Math.max(ret, money*(hi-lo+1));
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // 판자의 수
		m = new int[N]; // 판자의 높이를 담는 배열
		for(int j=0; j<N; j++) m[j] = in.nextInt();
		System.out.println(solve(0, m.length-1));
	}

}
