package hw9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// C - CountSum: large
// CountSum 문제의 경우 최종 결괏값이 32비트 int 범위를 벗어날 수 있습니다. 주의.

public class CountSum { // 메모이제이션- hashmap
	public static long countSum(int m, int[] nums, Map<Integer, Long> memo) {
		if(m < 0) return 0;
		if(m == 0) return 1;
		if(memo.containsKey(m)) return memo.get(m); // 추가 조건
		long count = 0;
		for(int num : nums)
			count += countSum(m-num, nums, memo);
		memo.put(m, count);
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt(); // 목표 정수
			int N = in.nextInt(); // N개 정수
			int[] nums = new int[N];
			Map<Integer, Long> memo = new HashMap<>((int)(M*1.3));
			for(int j=0; j < N; j++) nums[j] = in.nextInt();
			System.out.println(countSum(M, nums, memo));
		}
	}
}

class CountSum2 { // 메모이제이션 - 배열
	public static long countSum(int m, int[] nums, long[] memo) {
        if(m < 0) return 0;
        if(m == 0) return 1;
        if(memo[m] != -1) return memo[m]; // 추가 조건
        long count = 0;
        for(int num : nums)
            count += countSum(m-num, nums, memo);
        memo[m] = count;
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int M = in.nextInt(); // 목표 정수
            int N = in.nextInt(); // N개 정수
            int[] nums = new int[N];
            long[] memo = new long[M+1];
            Arrays.fill(memo, -1);
            for(int j=0; j < N; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(countSum(M, nums, memo));
        }
    }
}

class CountSumT { // 테뷸레이션
	public static int[] arr; //N개의 정수 저장 배열
	public static long countSum(int M) {
		long[] table = new long[M+1];
		table[0] = 1;

		for(int i=0; i<M; i++) {
			if(table[i] != 0) {
				for(var x : arr) {
					if(i+x <= M) table[i+x] += table[i];
				}
			}
		}
		return table[M];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt(); // 목표 정수
			int N = in.nextInt(); // N개 정수
			arr = new int[N];
			for(int j=0; j < N; j++) arr[j] = in.nextInt();
			System.out.println(countSum(M));
		}
	}
}