package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//  최대 사용할 수 있는 회의의 최대 개수

public class MeetingRoom_1931 {
	public static int N;
	public static int[][] meeting;
	
	public static int solve() {
		int cnt = 0;
		
		int starTime = 0;
		for(int i=0; i<N; i++) {
			if(starTime <= meeting[i][0]) {
				starTime = meeting[i][1];
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt(); // 회의의 수
		meeting = new int[N][2];
		for(int i=0; i<N; i++) {
			meeting[i][0] = in.nextInt(); // 시작시간
			meeting[i][1] = in.nextInt(); // 종료시간
		}
	
		Arrays.sort(meeting, new Comparator<int[]>() { // 종료시간 기준으로 정렬    
		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
		    	return o1[1] - o2[1];
		    }
		});
		System.out.println(solve());
	}
}
