package dynamic;

// 삼각형 위의 최대 경로 수 세기

//삼각형 위의 최대 경로수 세기
import java.util.Arrays;
import java.util.Scanner;

public class TRIPATHCNT {
	public static int[][] countCache;
	public static int[][] sumCache;
	public static int[][] triangle;
	public static int N;
	
	private static int path(int y, int x) {
		if(y == N-1) return triangle[y][x];
		if(sumCache[y][x] != -1) return sumCache[y][x];
		return sumCache[y][x] = Math.max(path(y+1,x), path(y+1,x+1)) + triangle[y][x];
	}
	
	public static int solve(int y, int x) {
		if(y == N-1) return 1;
		if(countCache[y][x] != -1) return countCache[y][x];
		int ret = 0;
		if(path(y+1,x+1) >= path(y+1,x)) ret += solve(y+1,x+1);
		if(path(y+1,x+1) <= path(y+1,x)) ret += solve(y+1,x);
		return countCache[y][x] = ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			triangle = new int[N][N];
			sumCache = new int[N][N];
			countCache = new int[N][N];
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<=y; x++)
					triangle[y][x] = sc.nextInt();
			}
			for(int[] k : countCache)
				Arrays.fill(k, -1);
			for(int[] k : sumCache)
				Arrays.fill(k, -1);
			System.out.println(solve(0,0));
		}
	}
}