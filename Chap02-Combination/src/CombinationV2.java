import java.util.Arrays;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * @version 2021년도 1학기
 * @author 김상진 
 * 0부터 N-1까지 수 중에 M개를 뽑는 모든 경우의 수: 조합
 */
public class CombinationV2 {
	public static void pick(int N, int M, int[] A, int i) {
		if(M==i) {
			System.out.println(Arrays.toString(A));
			return;
		}
		int smallest = i==0? 0: A[i-1]+1;
		for(int next = smallest; next<N; next++) {
			A[i] = next;
			pick(N, M, A, i+1);
		}
	}
	public static void pickMFromN(int N, int M) {
		int[] A = new int[M];
		pick(N, M, A, 0);
	}
	public static void main(String[] args) {
		pickMFromN(5,2);
	}

}
