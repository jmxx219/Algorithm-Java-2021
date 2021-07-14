package hw3;

import java.util.Scanner;

// 연속 부분 구간의 최댓값 구하기

public class MaximumSubarray {
	public static int maxSplitSubArray(int[] nums, int start, int mid, int end) {
		int Lmax = Integer.MIN_VALUE, Rmax=Integer.MIN_VALUE, sum = 0;
		
		for(int i=mid; i>=start; i--) {
			sum += nums[i];
			Lmax = Math.max(sum, Lmax);
		}
		
		sum = 0;
		for(int j=mid+1; j<=end; j++) {
			sum += nums[j];
			Rmax = Math.max(sum, Rmax);
		}
		
		return Lmax+Rmax;
	}
	public static int maxSubArray(int[] nums, int start, int end) {
		if(start==end) return nums[start];
		else if(start>end) return 0;
		
		int mid = (start+end) / 2;
		int L = maxSubArray(nums, start, mid);
		int R = maxSubArray(nums, mid+1, end);
		int S = maxSplitSubArray(nums, start, mid, end);

		return Math.max(L, Math.max(R, S));
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
			System.out.println(maxSubArray(nums, 0, nums.length-1));
		}
	}

}
