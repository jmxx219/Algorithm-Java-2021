package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class PI {
	public static String N;
	public static final int INF = 987654321;
	public static int[] cache;

	public static int classify(int a, int b) { // 조각의 난이도 결정
		String M = N.substring(a,b);
		
		//case1
		boolean consecutive = true;
		for(int i=0; i<M.length(); i++) {
			if(M.charAt(0) != M.charAt(i)) consecutive = false;
		}
		if(consecutive) return 1;

		//case2
		boolean progressive = true; // 등차수열인지
		int interval = (int)(M.charAt(1)) - (int)(M.charAt(0));
		for(int i=0; i<M.length()-1; i++) {
			if(((int)M.charAt(i+1) - (int)M.charAt(i)) != interval){
				progressive = false;
			}
		}
		if(progressive && Math.abs(interval) == 1) return 2;

		// case3
		boolean alternative = true; // 번갈아 나타나는지
		for(int i=0; i<M.length(); i++) {
			if(M.charAt(i) != M.charAt(i%2)) alternative = false;
		}
		if(alternative) return 4;
		if(progressive) return 5;
		return 10;
	}

	public static int memorize(int begin) {
		if(begin == N.length()) return 0;
		if(cache[begin] != -1) return cache[begin];
		
		int ret = INF;
		for(int L=3; L<=5; L++) {
			if(begin + L <= N.length()) {
				ret = Math.min(ret, memorize(begin+L) + classify(begin, begin+L));
				cache[begin] = ret;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int j=0; j<C; j++) {
			N = sc.next();
			cache = new int[N.length()];
			Arrays.fill(cache, -1);
			System.out.println(memorize(0));
		}
	}
}