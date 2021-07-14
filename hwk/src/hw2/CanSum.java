package hw2;

import java.util.Scanner;

public class CanSum {
	public static boolean canSum(int target, int[] nums) {
		if(target < 0) return false;
		if(target == 0) return true;
		for(int num : nums)
			if(canSum(target-num, nums)) return true;
		
		return false;
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
			System.out.println(canSum(M, nums));
		}
	}

}
