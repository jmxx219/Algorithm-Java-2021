package backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII_40 {
	public static int M;
	public static int[] nums;
	public static List<List<Integer>> res;
	public static boolean promising(int currTotal, int leftTotal, int index) {
		return (currTotal + leftTotal >= M) && (currTotal==M || currTotal+nums[index] <= M);
	}
	
	public static void subsetSum(boolean[] included, int currTotal, int leftTotal, int index, List<Integer> list) {
		if(promising(currTotal, leftTotal, index)) {
			if(currTotal == M) {
				//list.stream().forEach(s->System.out.print(s+" "));
				//System.out.println();
				List<Integer> tmpList = new ArrayList<>();
	            tmpList.addAll(list);
	            res.add(tmpList);
			}
			else {
				leftTotal -= nums[index];
				
				if(!(index > 0 && nums[index]==nums[index-1] && !included[index-1])) {
					included[index] = true;
					list.add(nums[index]);
					subsetSum(included, currTotal+nums[index], leftTotal, index+1, list);
					
					included[index] = false;
					list.remove(list.size()-1);
				}
				subsetSum(included, currTotal, leftTotal, index+1, list);
			}
		}
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            M = in.nextInt(); // 목표 정수
            int N = in.nextInt(); // N개 정수
            nums = new int[N];
            int leftTotal = 0;
            boolean[] included = new boolean[N];
            res = new ArrayList<List<Integer>>();
            for(int j=0; j < N; j++)  {
            	nums[j] = in.nextInt();
            	leftTotal += nums[j];
            }
            Arrays.sort(nums);
            List<Integer> list = new ArrayList<>();
            subsetSum(included, 0, leftTotal, 0, list);
            
            for(int j=0; j<res.size(); j++) {
                res.get(j).stream().forEach(s-> System.out.print(s + " "));
                System.out.println();
             }
        }
    }
}
