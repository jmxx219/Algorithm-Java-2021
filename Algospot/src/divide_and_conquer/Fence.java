package divide_and_conquer;

import java.util.Scanner;

// ��Ÿ�� �߶󳻱�

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

		while(left < lo || hi < right){ //������ ����� ������ Ȯ�� 
			if(left < lo && hi < right){ // ������ ���� �ʾҴٸ�, ���̰� ���� ������ Ȯ��
				if(h[lo -1] < h[hi+1])  height = Math.min(height, h[++hi]);
				else  height = Math.min(height, h[--lo]);
			} 
			else if(left < lo) height = Math.min(height, h[--lo]); // �������θ� Ȯ��
			else if(hi < right) height = Math.min(height, h[++hi]); // ���������θ� Ȯ��
			ret = Math.max(ret, height*(hi-lo+1));  // Ȯ���� �� �簢�� ����
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt(); // ������ ��
			h = new int[N]; // ������ ���̸� ��� �迭
			for(int j=0; j<N; j++) h[j] = in.nextInt();
			System.out.println(solve(0, h.length-1));
		}
	}
}
