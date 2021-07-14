package hw2;

import java.util.Scanner;

public class CountSum {
	public static int countSum(int target, int[] nums) {
		if(target < 0) return 0;
		if(target == 0) return 1;
		int count = 0;
		for(int num : nums)
			count += countSum(target-num, nums);
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt(); // 목표 정수
			int N = in.nextInt(); // N개 정수
			int[] nums = new int[N];
			for(int j=0; j < N; j++)
				nums[j] = in.nextInt();
			System.out.println(countSum(M, nums));
		}
	}

}
