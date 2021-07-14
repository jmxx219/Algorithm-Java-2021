package hw2;

import java.util.Scanner;

public class Picnic {
	public static int N;
	public static boolean[][] student; // 친구 정보를 담는 배열
	
	public static int picnic(boolean[] match) {
		int firstIndex = -1;
		
		for(int i=0; i<N; i++) {
			if(!match[i]) {
				firstIndex = i;
				break;
			}
		}
		if(firstIndex==-1) return 1;
		
		int count = 0;
		for(int i=firstIndex; i<N; i++) {
			if(!match[i] && student[firstIndex][i]) {
				match[firstIndex] = match[i] = true;
				count += picnic(match);
				match[firstIndex] = match[i] = false;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			N = in.nextInt(); // 학생 수(짝수)
			int M = in.nextInt(); // 친구 정보 수
			student = new boolean[N][N]; 
			boolean[] match = new boolean[N]; // 짝 여부
			for(int j=0; j < M; j++) {
				int x = in.nextInt();
				int y = in.nextInt();
				student[x][y] = true;
				student[y][x] = true;
			}
			System.out.println(picnic(match));
		}
	}
}
