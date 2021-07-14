package hw1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// A 중복 존재 (집합 자료구조를 이용하여 해결)

public class Main {
	public static boolean solve(int[] cards) {
		Set<Integer> set = new HashSet<>();
		
		for(int card: cards) {
			if(!set.contains(card)) set.add(card);
			else return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt();
			int[] card = new int[N];
			for(int j=0; j < N; j++) {
				card[j] = in.nextInt();
			}
			System.out.println(solve(card));
		}
	}

}
