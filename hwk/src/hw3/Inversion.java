package hw3;

import java.util.Scanner;

// ¿ª½Ö±¸ÇÏ±â 

public class Inversion {
	public static int countSplitInversion(int[] nums, int start, int mid, int end) {
		int i = start, j = mid + 1;
		int res = 0;

		int tmp[] = new int[nums.length];
		int tmpIndex = start;

		while(i <= mid && j <= end) {
			if(nums[i]<nums[j]) tmp[tmpIndex++] = nums[i++];
			else {
				tmp[tmpIndex++] = nums[j++];
				res += mid - i + 1;
			}
		}

		while (i <= mid) tmp[tmpIndex++] = nums[i++];
		while (j <= end) tmp[tmpIndex++] = nums[j++];

		for (int index = start; index < tmpIndex; index++) {
			nums[index] = tmp[index];
		}
		return res;
	}

	public static int countInversions(int[] nums, int start, int end) {
		if(start>=end) return 0;
		
		int mid = start + (end - start) / 2;
		int L = countInversions(nums, start, mid);
		int R = countInversions(nums, mid+1, end);
		int S = countSplitInversion(nums, start, mid, end);

		return L+R+S;
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
			System.out.println(countInversions(nums, 0, nums.length-1));
		}
	}

}
