package hw5;

import java.util.Random;
import java.util.Scanner;

// C: k��° ��� ã�� - RSelect

public class FindElements {
	public static int choosePivot(int[] nums, int start, int end) { // ���� �Ǻ� ����
		Random random = new Random();
		return random.nextInt(end - start + 1) + start; // start ~ end���� ����
	}
	public static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;        
    }

	private static int partiton(int[] nums, int start, int end, int p) {
		swap(nums, start, p);
		int i = start + 1; // ���� ������
		int j = start+1;
		for(; j<end+1; j++) {
			if(nums[j] < nums[start]) {
				swap(nums, i, j);
				++i;
			}
		}
		swap(nums, start, i-1);

		return i-1;
	}
	public static int RSelect(int[] nums, int start, int end, int k) {
		if(start>=end) return nums[start];
		int p = choosePivot(nums, start, end);
		int pLoc = partiton(nums, start, end, p);
		if(pLoc==k-1) return nums[pLoc];
		else if(pLoc> k-1) return RSelect(nums, start, pLoc-1, k);
		else return RSelect(nums, pLoc+1, end, k);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt();
			int k = in.nextInt();
			int[] nums = new int[N];
			for(int j=0; j<N; j++) nums[j] = in.nextInt();
			System.out.println(RSelect(nums,0, nums.length-1, k));
		}
	}

}
