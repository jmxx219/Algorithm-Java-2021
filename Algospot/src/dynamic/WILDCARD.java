package dynamic;

// 와일드카드

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WILDCARD {
	public static int[] arr;
	public static int N;
	public static String W;
	public static String S;
	public static int[][] cache = new int[101][101];
	
	public static void init() {
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j<101; j++) {
				cache[i][j] = -1;
			}
		}
	}
	
	public static int solve(int w, int s) {
		if(cache[w][s] != -1) return cache[w][s];
		
		if(w < W.length() && s < S.length()) {
			if(W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))
				return cache[w][s] = solve(w+1,s+1);
		}
		
		if(w == W.length()) { // 패턴 끝에서 끝났을 경우(문자열로 끝나야 참)
			if(s == S.length()) return cache[w][s] = 1;
			else return cache[w][s] = 0;
		}
		
		if(W.charAt(w) == '*') { // *를 만나서 끝난 경우 -> 몇 글자를 대응할 지 재귀호출
			if(solve(w+1,s) == 1 || (s < S.length() && (solve(w,s+1) == 1)))
				return cache[w][s] = 1;
		}
		
		return cache[w][s] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 크기
		for(int i=0; i<T; i++) {
			W = sc.next();
			N = sc.nextInt(); //파일 수
			List<String> ans = new ArrayList<String>();

			for(int j=0; j<N; j++) {
				S = sc.next();
				init();
				if(solve(0,0) == 1) ans.add(S);
			}
			Collections.sort(ans);
			for(int k =0; k<ans.size(); k++) {
				System.out.println(ans.get(k));
			}
		}
	}
}