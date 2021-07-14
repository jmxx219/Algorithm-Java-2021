package hw2;

import java.util.ArrayList;
import java.util.Scanner;

public class HowSum {
	public static ArrayList<Integer> howSum(int target, int[] nums) {
		if(target < 0) return null;
		if(target == 0) return new ArrayList<>();

		for(int num : nums) {
			ArrayList<Integer> list = howSum(target-num, nums);
			if(list != null) {
				list.add(num);
				return list;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt(); // 목표 정수
			int N = in.nextInt(); // N개 정수
			int[] nums = new int[N];
			for(int j=0; j < N; j++) nums[j] = in.nextInt();
			ArrayList<Integer> list = howSum(M, nums);
			if(list!=null) {
				System.out.print(list.size()+" ");
				for(int n : list) System.out.print(n + " ");
			}
			else System.out.println(-1);
			
		}
	}

}
