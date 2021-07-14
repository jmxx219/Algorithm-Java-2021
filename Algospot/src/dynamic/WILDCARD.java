package dynamic;

// ���ϵ�ī��

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
		
		if(w == W.length()) { // ���� ������ ������ ���(���ڿ��� ������ ��)
			if(s == S.length()) return cache[w][s] = 1;
			else return cache[w][s] = 0;
		}
		
		if(W.charAt(w) == '*') { // *�� ������ ���� ��� -> �� ���ڸ� ������ �� ���ȣ��
			if(solve(w+1,s) == 1 || (s < S.length() && (solve(w,s+1) == 1)))
				return cache[w][s] = 1;
		}
		
		return cache[w][s] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //�׽�Ʈ ũ��
		for(int i=0; i<T; i++) {
			W = sc.next();
			N = sc.nextInt(); //���� ��
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