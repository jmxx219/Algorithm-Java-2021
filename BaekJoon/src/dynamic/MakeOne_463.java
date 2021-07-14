//1로 만들기

/* 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
   2. X가 2로 나누어 떨어지면, 2로 나눈다.
   3. 1을 뺀다.
       정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.*/

package dynamic;
import java.util.Arrays;
import java.util.Scanner;

public class MakeOne_463 {
	public static int INF = 987654321;
	public static int[] memo;

	public static int solve(int N) {
		if(N < 1) return INF;
		if(N == 1) return 0;

		int a = INF, b = INF, c = INF;
		if(N%3 == 0) {
			if(memo[N/3] != -1) a = memo[N/3];
			else a = solve(N/3);
		}
		if(N%2 == 0) {
			if(memo[N/2] != -1) b = memo[N/2];
			else b = solve(N/2);
		}
		if(memo[N-1] != -1) c = memo[N-1];
		c = solve(N-1);

		return memo[N] = Math.min(Math.min(a,b), c) + 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new int[N+1]; //[0,N]
		Arrays.fill(memo, -1);
		System.out.println(solve(N));
	}
}
