package divide_and_conquer;

// 쿼드 트리 뒤집기

import java.util.Scanner;

public class QuadTree {
	public static int pointer;

	private static String recursive(String s) {
		pointer += 1;
		char get = s.charAt(pointer); 
		if(get == 'b' || get == 'w') return String.valueOf(get);
		
		String upperLeft = recursive(s);
		String upperRight = recursive(s);
		String lowerLeft = recursive(s);
		String lowerRight = recursive(s);
		return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<T; i++) {
			pointer = -1;
			String s = sc.nextLine();
			System.out.println(recursive(s));

		}
	}


}
