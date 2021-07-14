import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * @version 2021년도 1학기
 * @author 김상진 
 * 0부터 N-1까지 수 중에 M개를 뽑는 모든 경우의 수: 조합
 */
public class CombinationV3 {
	public static void pick(int N, int M, int index, int i, int[] curr, List<List<Integer>> totalCombination){
		if(index==M) {
			totalCombination.add(Arrays.stream(curr).boxed().collect(Collectors.toList()));
			return;
		}
		if(i>=N) return;
		curr[index] = i;
		pick(N, M, index+1, i+1, curr, totalCombination);
		pick(N, M, index, i+1, curr, totalCombination);
	}
	// N개에서 M개를 선택하는 모든 조합
	public static void pickMFromN(int N, int M){
		List<List<Integer>> totalCombination = new ArrayList<>();
		int[] curr = new int[M];
 		pick(N, M, 0, 0, curr, totalCombination);
 		for(var list: totalCombination)
 			System.out.println(list);
	}
	public static void main(String[] args) {
		pickMFromN(5,2);
	}
}
