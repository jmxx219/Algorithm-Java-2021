package brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// // 암호만들기

public class Password_1759 {
	public static int L;
	public static int C;
	public static char[] arr;
	
	private static void solve(List<Character> result, int index) {
		if(result.size()==L) {
			int a = 0, b = 0; //모음(1이상), 자음(2이상)
			for(var x : result) {
				if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') a++;
				else b++;
			}
			if(a >= 1 && b >= 2) { 
				result.stream().forEach(s -> System.out.print(s));
				System.out.println();
				return;
			}

		}
		
		for(int i= index; i<C; i++) {
			result.add(arr[i]);
			solve(result, i+1);
			result.remove(result.size()-1);
		}

	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		L = in.nextInt();
		C = in.nextInt();
		in.nextLine();
		String line = in.nextLine();
		arr = new char[C];
		
		for(int i=0; i<C; i++) arr[i] = line.split(" ")[i].charAt(0);
		Arrays.sort(arr);
		List<Character> list = new ArrayList<>();
		solve(list,0);
	}

}
