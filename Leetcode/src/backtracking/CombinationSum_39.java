package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
	public static int N;
	public static List<List<Integer>> ret;
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		ret = new ArrayList<>();
		Arrays.sort(candidates);
		N = candidates.length;
		List<Integer> list = new ArrayList<>();
		solve(0,0, list, target, candidates);
		return ret;
	}

	public static void solve(int index, int sum, List<Integer> list, int target, int[] candidates) {
		if(sum <= target) {
			if(sum == target) ret.add(new ArrayList<Integer>(list));
			else {
				for(int next = index; next < N; next++) {
					list.add(candidates[next]);
					solve(next, sum + candidates[next], list, target, candidates);
					list.remove(list.size()-1);
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 8;
		combinationSum(candidates, target);
	}
}