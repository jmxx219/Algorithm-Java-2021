package hw1;

import java.util.Arrays;
import java.util.Scanner;

// B: ���� ���� ������ �� ã��(���ǳ�Ʈ�� ���õ� 2���� ��� ��ſ� �ٸ� ����� ����Ͽ� �ذ�)

public class Main2 {
	public static int solve(int[] arr) {
		Arrays.sort(arr);

		int max = 0;
		int index = 0;
		int cnt = 1;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] != arr[i+1] || (i == arr.length-2 && arr[i] == arr[arr.length-1])){
				if(i == arr.length-2 && arr[i] == arr[arr.length-1]) cnt++;
				if(max < cnt) {
					max = cnt;
					index = i;
				}
				cnt = 1;
			}
			else cnt++;
		}
		
		return arr[index];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for(int j=0; j < N; j++) {
				arr[j] = in.nextInt();
			}
			System.out.println(solve(arr));
		}
	}
}
