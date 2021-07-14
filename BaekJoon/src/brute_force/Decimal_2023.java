package brute_force;

import java.util.Scanner;

// 신기한 소수

public class Decimal_2023 {
	public static boolean isDec(int x) {
		if(x==1) return false;
		if(x==2) return true;
		for(int i=2; i*i<=x; i++) {
			if(x%i == 0) return false;
		}
		return true;
	}
	public static void solve(int x, int index, int N) {
		if(!isDec(x)) return;
		if(index==N) {
			System.out.println(x);
			return;
		}	
		for(int i=1; i<10; i++) {
			solve(x*10+i, index+1, N);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		solve(0, 0, N);
	}

}
