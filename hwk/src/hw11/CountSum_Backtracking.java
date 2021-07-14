package hw11;

import java.util.Arrays;
import java.util.Scanner;

// C: CountSum 변형 - small - 되추적

public class CountSum_Backtracking {
	public static int M;
	public static int[] nums;
	
	public static boolean promising(int currTotal, int leftTotal, int index) {
		return (currTotal + leftTotal >= M) && (currTotal==M || currTotal+nums[index] <= M);
	}
	
	public static int subsetSum(boolean[] included, int currTotal, int leftTotal, int index) {
		int cnt = 0;
		if(promising(currTotal, leftTotal, index)) {
			if(currTotal == M) return 1;
			else {
				leftTotal -= nums[index];
				
				included[index] = true;
				cnt += subsetSum(included, currTotal+nums[index], leftTotal, index+1); // 포함
				
				included[index] = false;
				cnt += subsetSum(included, currTotal, leftTotal, index+1); // 포함 x
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            M = in.nextInt(); // 목표 정수
            int N = in.nextInt(); // N개 정수
            nums = new int[N];
            boolean[] included = new boolean[N];
            int leftTotal = 0;
            
            for(int j=0; j < N; j++)  {
            	nums[j] = in.nextInt();
            	leftTotal += nums[j];
            }
            Arrays.sort(nums);
            
            System.out.println(subsetSum(included, 0, leftTotal, 0));
        }
    }
}
