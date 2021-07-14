package hw9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// A - CanSum:large
//- �޸������̼�: HashMap<Integer, Boolean> memo = new HashMap<>();
//==> Map<Integer, Boolean> memo = new HashMap<>((int)(M*1.3));
//- HashMap���� ���������� �װ��� Ÿ���� Map���� 

public class CanSum { // �޸��� - hashmap
	public static boolean canSum(int m, int[] nums, Map<Integer, Boolean> memo) {
		if(m < 0) return false;
		if(m == 0) return true;
		if(memo.containsKey(m)) return memo.get(m); // �߰� ����
		for(int num : nums)
			if(canSum(m-num, nums, memo)) {
				memo.put(m, true);
				return true;
			}
		memo.put(m, false);
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt(); // ��ǥ ����
			int N = in.nextInt(); // N�� ����
			Map<Integer, Boolean> memo = new HashMap<>((int)(M*1.3));
			int[] nums = new int[N];
			for(int j=0; j < N; j++) nums[j] = in.nextInt();
			System.out.println(canSum(M, nums, memo));
		}
	}

}

class CanSum2 { // �޸��� - �迭
	public static int[] nums;
	public static boolean canSum(int M, boolean[] memo, boolean[] memoFlag) {
		if(M < 0) return false;
		if(M == 0) return true;
		if(memoFlag[M]) return memo[M];
		for(int num : nums) {
			if(canSum(M-num, memo, memoFlag)) {
				memo[M] = true;
				return true;
			}
		}
		memo[M] = false;
		memoFlag[M] = true;
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			nums = new int[N];
			boolean[] memo = new boolean[M+1];
			boolean[] memoFlag = new boolean[M+1];
			for(int j=0; j<N; j++) nums[j] = sc.nextInt();
			System.out.println(canSum(M, memo, memoFlag));
		}
	}
}

class CanSumT { // �׺淹�̼�
	private static boolean solve(int m, int[] arr) {
		boolean[] table = new boolean[m+1];
		table[0] = true;
		for(int i=0; i<m; i++) {
			if(table[i]) {
				for(var x : arr) {
					if(i+x <= m) table[i+x] = true;
				}
			}
		}
		return table[m];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int j=0; j<N; j++) arr[j] = sc.nextInt();
			System.out.println(solve(M, arr));
		}
	}
}
