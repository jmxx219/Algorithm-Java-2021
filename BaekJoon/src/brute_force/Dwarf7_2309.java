package brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// ¿œ∞ˆ ≥≠¿Ô¿Ã

public class Dwarf7_2309 {
	public static int maxSize = 9;
	public static int n = 7;
	public static int[] arr = new int[maxSize];

	public static boolean solve1(int target, int index, int[] arr, List<Integer> list) {
		if(list.size()==7) {
			if(target==0) {
				list.stream().forEach(s->System.out.println(s));
				return true;
			}
			else return false;
		}
		if(index>=9) return false;
		
		for(int i=index; i<9; i++) {
			list.add(arr[i]);
			if(solve1(target-arr[i], i+1, arr, list)) return true;
			list.remove(list.size()-1);
		}
		return false;
	}
	
	private static boolean solve(List<Integer> list, int index) {
		if(list.size() == n) {
			int sum = 0;
			for(var x : list) sum += x;
			if(sum == 100) {
				for(var h : list) System.out.println(h);
				return true;
			}
		}

		for(int i = index; i < maxSize; i++) {
			list.add(arr[i]);
			if(solve(list, i+1)) return true;
			list.remove(list.size()-1);
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<maxSize; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		solve(list, 0);
	}

}

class BaekJoon2309 {
	public static int maxSize = 9;
	public static int n = 7;
	public static int[] arr = new int[maxSize];

	private static List<Integer> solve(int sum, int idx, int count) {
		if(count == n) {
			if(sum < 0) return null;
			else if(sum == 0) return new ArrayList<>();
		}

		List<Integer> list = null;
		for(int i = idx; i < maxSize; i++) {
			list = solve(sum - arr[i], i+1, count+1);
			if(list != null) {
				list.add(arr[i]);
				return list;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<maxSize; i++) arr[i] = sc.nextInt();
		
		List<Integer> list = solve(100,0,0);
		list.stream().sorted().forEach(s -> System.out.println(s));
	}
}
