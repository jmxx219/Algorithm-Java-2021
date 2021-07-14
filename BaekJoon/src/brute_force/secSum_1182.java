package brute_force;

import java.util.Scanner;

// 전역 변수 사용
public class secSum_1182 {
//	public static int ret; 
//
//	public static void solve1(int sum, int index, int target, int[] arr) {
//		if(index == arr.length) return;
//		if(sum + arr[index] == target) ret++;
//
//		solve1(sum + arr[index], index+1, target, arr);
//		solve1(sum, index+1, target, arr);
//
//	}
//
//	public static void solve2(int sum, int index, int target, int[] arr) {
//		if(index == arr.length) return; // 없어도 잘됨
//
//		for(int i=index; i<arr.length; i++) {
//			if(sum + arr[i] == target) ret++;
//			solve2(arr[i] + sum, i+1, target, arr);
//		}
//	}

	public static int solve(int sum, int index, int target, int[] arr){
		if(index==arr.length) return 0;
		int count = 0;
		for(int i=index; i<arr.length; i++){
			if(sum+arr[i]==target) ++count;
			count += solve(sum+arr[i], i+1, target, arr);

		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();

		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		//ret = 0;
		solve(0,0,S,arr);
		//System.out.println(ret);
	}
}
