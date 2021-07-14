import java.util.Arrays;
import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * 2021년도 1학기
 * @author 김상진
 * 순열
 * [1,_,_], [_,1,_], [_,_,1]
 *  -> [1,2,_], [1,_,2] -> [1,2,3],[1,3,2]
 */
public class PermutationV1 {
	public static void permutate(int N, int i, boolean[] set, int[] curr) {
		if(i==N) {
			System.out.println(Arrays.toString(curr));
		}
		for(int j=0; j<N; j++) {
			if(!set[j]) {
				set[j] = true;
				curr[i] = j+1;
				permutate(N, i+1, set, curr);
				set[j] = false;
			}
		}
	}
	public static void permutation(int N) {
		boolean[] flag = new boolean[N];
		int[] curr = new int[N];
		permutate(N, 0, flag, curr);
	}
	public static void main(String[] args) {
		permutation(3);

	}

}
