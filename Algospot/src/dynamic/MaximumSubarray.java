package dynamic;

import java.util.Scanner;

public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxEnding = nums[0];
        
        for(int num: nums) {
        	sum = Math.max(sum + num, num);
        	maxEnding = Math.max(maxEnding, sum);
        }
        
        return maxEnding;
    }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i < T; i++) {
			int N = in.nextInt();
			int[] nums = new int[N];
			for(int j=0; j < N; j++) {
				nums[j] = in.nextInt();
			}
			System.out.println(maxSubArray(nums));
		}
	}
}
