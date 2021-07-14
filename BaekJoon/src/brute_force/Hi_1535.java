package brute_force;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 안녕 - 기쁨 얻기

public class Hi_1535 {
	//health나 happy가 0이하가 되면, 죽음 -> 최대 기쁨 출력
	public static int[] minusHealth;
	public static int[] plusHappy;
	public static final int INF = -987654321;
	public static int N;

	private static int solve1(int health, int happy, int index) {
		if(health <= 0) return INF;
		if(index == N) return happy;

		int ret = INF;
		int band = solve1(health - minusHealth[index], happy + plusHappy[index], index+1);
		int cand = solve1(health, happy, index+1);
		ret = Math.max(band, cand);

		return ret;
	}

	public static int solve3(int health, int happy, int prev, int here) {
		if(health <= 0) return happy - plusHappy[prev];
		if(here == N) return happy;

		int ret = INF;
		for(int i = here; i<N; i++) {
			ret = Math.max(ret, solve3(health - minusHealth[i], happy + plusHappy[i], i, i+1));
		}
		return ret;
	}
	
	public static int solve(int health, int happy, int index, List<Integer> list) {
		if(health <= 0) return happy - plusHappy[list.get(list.size()-1)];
		if(index == N) return happy;

		int ret = INF;
		for(int i = index; i<N; i++) {
			list.add(i);
			ret = Math.max(ret, solve(health - minusHealth[i], happy + plusHappy[i], i+1, list));
			list.remove(list.size()-1);
		}
		return ret;
	}


	public static void main(String[] args) {
		int health = 100;
		int happy = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		minusHealth = new int[N];
		for(int i=0; i<N; i++) minusHealth[i] = sc.nextInt();

		plusHappy = new int[N];
		for(int i=0; i<N; i++) plusHappy[i] = sc.nextInt();

		System.out.println(solve1(health,happy,0));
	}
}

