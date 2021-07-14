import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CombinationV4 {
	private static void pick(List<List<Integer>> result, int N, int M, int index, int i, List<Integer> picked) {
		if(M == index) {
			List<Integer> tmpList = new ArrayList<>(M);
			tmpList.addAll(picked);
			result.add(tmpList);
			return;
		}
		if(i >= N) return;
		picked.set(index, i);
		pick(result, N, M, index+1, i+1, picked);
		pick(result, N, M, index, i+1, picked);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("N과 M을 입력하시오 : ");
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<List<Integer>> totalCombination = new ArrayList<>();
		List<Integer> picked = new ArrayList<>(Collections.nCopies(M, 0));
		pick(totalCombination, N, M, 0,0, picked);
		for(int i=0; i<totalCombination.size(); i++) {
			totalCombination.get(i).stream().forEach(s -> System.out.print(s + " "));
			System.out.println();
		}
	}
}