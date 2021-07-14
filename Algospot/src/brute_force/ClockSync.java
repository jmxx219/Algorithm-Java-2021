package brute_force;

// 시계 맞추기

import java.util.Scanner;

public class ClockSync {
	public static final int INF = 99999;
	public static final int SWITCHES = 10;
	public static int[][] switchClock = { // 1이 연결, 0은 연결 x
			{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
			{0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
	};

	public static boolean areAligned(int[] clocks) { // 모든 시계가 12시를 가리키는지 확인
		for(int i=0; i<clocks.length; i++)
			if(clocks[i] != 12) return false;
		return true;
	}

	public static void push(int[] clocks, int swtch) { // swtch번 스위치를 누름
		for(int i=0; i<16; i++) {
			if(switchClock[swtch][i] == 1) { // 해당 스위치와 연결되어 있으면
				clocks[i] += 3;
				if(clocks[i] == 15) clocks[i] = 3;
			}
		}
	}

	public static int solve(int[] clock, int swtch) { // swtch: 이번에 누를 스위치 번호
		if(swtch == SWITCHES) return areAligned(clock) ? 0 : INF;
		
		int ret = INF;
		for(int i=0; i<4; i++) {
			ret = Math.min(ret, i + solve(clock, swtch+1));
			push(clock, swtch); // 4번 호출되면 원래와 같은 상태로
		}
		return ret;
	}
	public static int solve(int[] clock, int swtch, int sum) {
	      if(areAligned(clock)) return sum;
	      if(swtch == 10) return INF;
	      
	      int ret = INF;
	      for(int i=0; i<4; i++) {
	         ret = Math.min(ret, solve(clock, swtch+1, sum+i));
	         push(clock, swtch);
	      }
	      return ret;
	   }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int[] clock = new int[16]; // 현재 시계들의 상태
			for(int j=0; j<16; j++) clock[j] = sc.nextInt();

			int ret = solve(clock,0);
			if(ret >= INF) System.out.println(-1); 
			else System.out.println(ret); 
		}
	}
}