package hw5;

import java.util.Scanner;

// A: ÃÖ´ñ°ª°ú ÃÖ¼Ú°ªÀ» µ¿½Ã¿¡

public class SametimeMaxMin {
	public static void sametimeMaxMin(int[] nums, int N) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int i=0;
		if(N%2==0) { // Â¦¼ö
			if(nums[0]<nums[1]) {
				max = nums[1];
				min = nums[0];
			}
			else {
				max = nums[0];
				min = nums[1];
			}
			i+=2;
		}
		else {
			max = min = nums[0];
			i++;
		}
		
		while(i<=N-1) {
			if(nums[i]<nums[i+1]) {
				if(nums[i]<min) min = nums[i];
				if(nums[i+1]>max) max = nums[i+1];
			}
			else {
				if(nums[i+1]<min) min = nums[i+1];
				if(nums[i]>max) max = nums[i];
			}
			i+=2;
		}
		
		System.out.println(max+" "+min);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt();
			int[] nums = new int[N];
			for(int j=0; j<N; j++) nums[j] = in.nextInt();
			sametimeMaxMin(nums, N);
		}
	}

}
