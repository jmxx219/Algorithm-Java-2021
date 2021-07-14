package greedy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 출전 순서 정하기

public class MATCHORDER {
	public static int N;
	
	public static int solve(int[] russian, int[] korean) {
	
		int wins = 0;
		List<Integer> k = Arrays.stream(korean)
				.boxed()
				.sorted((a,b) -> Integer.compare(b, a))
				.collect(Collectors.toList());

		for(int i=0; i<N; i++) {
			if(russian[i] > k.get(0)) k.remove(k.size()-1);
			else {
				int index = 0;
				while(index+1 < k.size()) {
					if(k.get(index+1) < russian[i]) break;
					index++;
				}
				k.remove(index);
				++wins;
			}
		}
		return wins;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			int[] russian = new int[N];
			int[] korean = new int[N];
			for(int j=0; j<N; j++) russian[j] = sc.nextInt();
			for(int j=0; j<N; j++) korean[j] = sc.nextInt();
			System.out.println(solve(russian, korean));
		}
	}
}
