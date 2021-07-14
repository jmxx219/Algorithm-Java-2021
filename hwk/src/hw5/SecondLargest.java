package hw5;

import java.util.Scanner;

// B: 두 번째로 큰 값

public class SecondLargest {
	public static int secondLargest(int[] nums, int N) {
		int smax = Integer.MIN_VALUE;
		
		int j=N-2;
		int i=2*N-2;
		while(i>1) {
			nums[j] = Math.max(nums[i], nums[i-1]);
			j--;
			i-=2;
		}
		
		i = i*2+1;
		while(i < 2*N-1) {
			if(nums[i]==nums[0]) {
				if(smax < nums[i+1]) smax = nums[i+1];
			}
			else if(nums[i+1]==nums[0]) {
				if(smax < nums[i]) smax = nums[i];
				i+=1;
			}
			i = i*2+1;
		}
		return smax;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt();
			int[] nums = new int[2*N-1];
			for(int j=N-1; j<2*N-1; j++) nums[j] = in.nextInt();
			System.out.println(secondLargest(nums, N));
		}
	}

}
