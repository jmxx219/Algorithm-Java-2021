package hw2;

import java.util.ArrayList;
import java.util.Scanner;

public class BestSum {
	public static ArrayList<Integer> bestSum(int target, int[] nums) {
		if(target < 0) return null;
		if(target == 0) return new ArrayList<>();
		ArrayList<Integer> best = null;
		for(int num : nums) {
			ArrayList<Integer> list = bestSum(target-num, nums);
			if(list != null) {
				if(best==null || best.size()>list.size()+1) {
					list.add(num);
					best = list;
				}
			}
		}
		return best;
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
			ArrayList<Integer> list = bestSum(M, nums);
			if(list!=null) {
				System.out.print(list.size()+" ");
				for(int n : list) System.out.print(n + " ");
			}
			else System.out.println(-1);
		}
	}
}
