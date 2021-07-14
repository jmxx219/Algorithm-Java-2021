package hw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

// B - HowSum: large
// - �޸������̼�: HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
// ==> M*1.3��� ���� Ȯ��
// - ������ ���� ArrayList<Integer>�� ��������� �װ��� Ÿ���� List<Integer>�� ó���ϼ���. 

public class HowSum { // �޸��� - hashmap
	public static List<Integer> howSum(int m, int[] nums, Map<Integer, List<Integer>> memo) {
		if(m < 0) return null;
		if(m == 0) return new ArrayList<Integer>();
		if(memo.containsKey(m)) return memo.get(m);
		for(int num : nums) {
			List<Integer> list = howSum(m-num, nums, memo);
			if(list != null) {
				list.add(num);
				memo.put(m, list);
				return list;
			}
		}
		memo.put(m, null);
		return null;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt(); // ��ǥ ����
			int N = in.nextInt(); // N�� ����
			Map<Integer, List<Integer>> memo = new HashMap<>((int)(M*1.3));
			int[] nums = new int[N];
			for(int j=0; j < N; j++) nums[j] = in.nextInt();
			List<Integer> list = howSum(M, nums,memo);
			if(list!=null) {
				System.out.print(list.size()+" ");
				for(int n : list) System.out.print(n + " ");
			}
			else System.out.println(-1);

		}
	}
}

class HowSum2 { // �޸��� - �迭
	public static List<Integer> howSum(int m, int[] nums, boolean[] memoflag, Vector<List<Integer>> memo) {
		if(m<0) return null;
		if(m==0) return new ArrayList<Integer>();
		if(memoflag[m]) return memo.get(m);

		for(var x: nums) {
			List<Integer> list = howSum(m-x, nums, memoflag, memo);
			if(list!=null) {
				list.add(x);
				memo.set(m, list);
				return list;
			}
		}
		memoflag[m] = true;
		memo.set(m, null);
		return null;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt();
			int N = in.nextInt();
			int[] nums = new int[N];
			for(int j=0; j<N; j++) nums[j] = in.nextInt();

			boolean[] memoflag = new boolean[M+1];
			Vector<List<Integer>> memo = new Vector<>(M+1);
			memo.setSize(M+1);

			List<Integer> list = howSum(M, nums, memoflag, memo);
			if(list==null) System.out.println(-1);
			else {
				System.out.print(list.size());
				for(var n: list) System.out.print(" "+n);
				System.out.println();
			}
		}
	}
}

class HowSumT { // �׺淹�̼�
	public static int[] nums;
	@SuppressWarnings("unchecked")
	private static List<Integer> howSum(int m) {
		List<Integer>[] table = new ArrayList[m+1];
		Arrays.fill(table, null);
		table[0] = new ArrayList<>();
		for(int i=0; i<m-1; i++) {
			if(table[i] != null) {
				for(var x : nums) {
					if(i+x <= m && table[i+x] == null) {
						List<Integer> list = new ArrayList<>(table[i]);
						list.add(x);
						table[i+x] = list;
					}
				}
			}
		}
		return table[m];
	}

	private static List<Integer> howSum2(int m) {
		Vector<List<Integer>> table = new Vector<>(m+1);
		table.setSize(m+1);
		table.set(0, new ArrayList<Integer>());

		for(int i=0; i<m-1; i++) {
			if(table.get(i) != null) {
				for(var x : nums) {
					// �ϳ��� �丸 ã���� �ǹǷ� table.get(i+x)�� null�� ���� ����
					if(i+x <= m && table.get(i+x) == null) {
						List<Integer> list = new ArrayList<>(table.get(i));
						list.add(x);
						table.set(i+x, list);
					}
				}
			}
		}
		return table.get(m);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			nums = new int[N];
			for(int j=0; j<N; j++) nums[j] = sc.nextInt();
			List<Integer> ret = howSum2(M);
			if(ret != null) {
				System.out.print(ret.size() + " ");
				for(var x : ret) System.out.print(x + " ");
			}
			else System.out.println("-1");
		}
	}
}
