package divide_and_conquer;

import java.util.Scanner;

// 울타리 잘라내기

public class Fence {
	public static int[] h;

	public static int solve(int left, int right) {
		if(left == right) return h[left];

		int mid = (left + right) / 2;
		int ret = Math.max(solve(left, mid), solve(mid+1, right));

		int lo = mid;
		int hi = mid+1;
		int height = Math.min(h[lo], h[hi]);
		ret = Math.max(ret, height*2);

		while(left < lo || hi < right){ //범위를 벗어나기 전까지 확장 
			if(left < lo && hi < right){ // 범위를 넘지 않았다면, 높이가 높은 쪽으로 확장
				if(h[lo -1] < h[hi+1])  height = Math.min(height, h[++hi]);
				else  height = Math.min(height, h[--lo]);
			} 
			else if(left < lo) height = Math.min(height, h[--lo]); // 왼쪽으로만 확장
			else if(hi < right) height = Math.min(height, h[++hi]); // 오른쪽으로만 확장
			ret = Math.max(ret, height*(hi-lo+1));  // 확장한 후 사각형 넓이
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // 판자의 수
			h = new int[N]; // 판자의 높이를 담는 배열
			for(int j=0; j<N; j++) h[j] = in.nextInt();
			System.out.println(solve(0, h.length-1));
		}
	}
}
