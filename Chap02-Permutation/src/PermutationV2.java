import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * 2021년도 1학기
 * @author 김상진
 * 순열
 */
public class PermutationV2 {
	// [a,b,c]의 순열 계산하기
	// 첫 번쨰 요소로 구성된 리스트 만들어 추가하기 [[a]] // 남은 요소 [b,c]
	// 두 번째 요소를 가져와서 만든 리스트에서 각 리스트를 가져와 순열 되도록 추가하기 
	//		[[b,a], [a,b]] // // 남은 요소 [c]
	// 세 번째 요소를 가져와서 만든 리스트에서 각 리스트를 가져와 순열 되도록 추가하기 
	//		[[c,b,a],[b,c,a],[b,a,c],[c,a,b],[a,c,b],[a,b,c]]
	public static void permutation(int N) {
		List<List<Integer>> permutations = new ArrayList<>();
		permutations.add(new LinkedList<Integer>(Arrays.asList(1)));
		for(int i=1; i<N; i++){
			int next = i+1;
			List<List<Integer>> tmp = new ArrayList<>();
			while(!permutations.isEmpty()) {
				List<Integer> curr_p = permutations.remove(permutations.size()-1);
				for(int k=0; k<=curr_p.size(); k++) {
					List<Integer> next_p = new LinkedList<>(curr_p);
					System.out.println(tmp.toString());
					next_p.add(k, next);
					tmp.add(next_p);
				}
				System.out.println();
			}
			permutations = tmp;
		}
		System.out.println(permutations);
	}
	public static void main(String[] args) {
		permutation(3);
	}
}
