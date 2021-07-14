import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * @version 2021년도 1학기
 * @author 김상진 
 * 0부터 N-1까지 수 중에 M개를 뽑는 모든 경우의 수: 조합
 */
public class CombinationV1 {
	public static void pick(int N, int M, List<Integer> picked, List<List<Integer>> result) {
		if(M==0) {
			result.add(picked.stream().collect(Collectors.toList()));
			return;
		}
		int smallest = picked.isEmpty()? 0: picked.get(picked.size()-1)+1;
		for(int next = smallest; next<N; next++) {
			picked.add(next);
			pick(N, M-1, picked, result);
			picked.remove(picked.size()-1);
		}
	}
	public static void pickMFromN(int N, int M) {
		List<List<Integer>> totalCombination = new ArrayList<>();
		List<Integer> picked = new ArrayList<>();
		pick(N, M, picked, totalCombination);
		System.out.println(totalCombination);
	}
	public static void main(String[] args) {
		pickMFromN(5,2);
		//pickMFromN(10,10);
	}

}
