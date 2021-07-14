package hw9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

// D - BestSum: large
// howsum, bestsum�� �׺淹�̼����� �ذ��� �� �� ���ͷ� �ʱ�ȭ�� �� ������ 
// �׷��� �Ͻ� ���� nullptr�� �ʱ�ȭ�Ͽ� �ذ��ϴ� ������ε� ������ ���ñ� ������

public class BestSum { // �޸��� - hashmap
	public static List<Integer> bestSum(int m, int[] nums, Map<Integer, List<Integer>> memo) {
		if(m < 0) return null;
		if(m == 0) return new ArrayList<Integer>();
		if(memo.containsKey(m)) return memo.get(m);
		
		List<Integer> best = null;
		for(int num : nums) {
			List<Integer> list = bestSum(m-num, nums, memo);
			if(list != null) {
				if(best==null || best.size()>list.size()+1) {
					List<Integer> next = new ArrayList<>(list);
					next.add(num);
					best = next;
				}
			}
		}
		memo.put(m, best);
		return best;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int M = in.nextInt(); // ��ǥ ����
			int N = in.nextInt(); // N�� ����
			int[] nums = new int[N];
			for(int j=0; j < N; j++) nums[j] = in.nextInt();
			Map<Integer, List<Integer>> memo = new HashMap<>((int)(M*1.3));
			List<Integer> list = bestSum(M, nums, memo);
			if(list!=null) {
				System.out.print(list.size()+" ");
				for(int n : list) System.out.print(n + " ");
			}
			else System.out.println(-1);
		}
	}

}

class BestSum2 { // �޸��� - �迭
	public static List<Integer> bestSum(int m, int[] nums, boolean[] memoflag, Vector<List<Integer>> memo) {
		if(m<0) return null;
		if(m==0) return new ArrayList<Integer>();
		if(memoflag[m]) return memo.get(m);
		
		List<Integer> best = null;
		for(var x: nums) {
			List<Integer> curr = bestSum(m-x, nums, memoflag, memo);
			if(curr!=null) {
				if(best==null||(best.size()>curr.size()+1)) {
					List<Integer> next = new ArrayList<>(curr);
					next.add(x);
					best = next;
				}
				
			}
		}
		memoflag[m] = true;
		memo.set(m, best);
		return best;
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
			
			List<Integer> best = bestSum(M, nums, memoflag, memo);
			if(best==null) System.out.println(-1);
			else {
				System.out.print(best.size());
				for(var n: best) System.out.print(" "+n);
				System.out.println();
			}
		}
	}
}

class BestSumT { // �׺淹�̼�
	public static int[] nums;
	@SuppressWarnings("unchecked")
	private static List<Integer> solve(int M) {
		List<Integer>[] table = new List[M+1];
		table[0] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			if(table[i] != null) {
				for(var x : nums) {
					if(i+x <= M) {
						if(table[i+x] == null || table[i+x].size() > table[i].size()+1) {
							List<Integer> next = new ArrayList<>();
							next.addAll(table[i]);
							next.add(x);
							table[i+x] = next;
						}
					}
				}
			}
		}
		return table[M];
	}
	
	public static List<Integer> solve2(int m) { // ���� ���
		Vector<List<Integer>> table = new Vector<>(m+1);
		table.setSize(m+1);
		table.set(0, new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			List<Integer> prev = table.get(i);
			if(prev!=null) {
				for(var x: nums) {					
					if(i+x<=m) {
						List<Integer> curr = table.get(i+x);
						if(curr==null || prev.size()+1<curr.size()) {
							List<Integer> list = new ArrayList<Integer>(prev);
							list.add(x);
							table.set(i+x, list);
						}
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

			List<Integer> ret = solve(M);
			if(ret == null) System.out.println("-1");
			else {
				System.out.print(ret.size() + " ");
				for(var x : ret) System.out.println(x + " ");
			}
		}
	}
}


