package hw4;

import java.util.Random;
import java.util.Scanner;

// A 빠른 정렬(퀵정렬)

public class QuickSort {
	public static int choosePivot(int[] arr, int start, int end) {
		Random random = new Random();
		return random.nextInt(end - start + 1) + start; // start ~ end까지 랜덤
	}
	public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;        
    }
	public static int partition(int[] arr, int p, int start, int end) {
		// 피봇 요소를 첫 번째 요소와 swap
		swap(arr, start, p);
		int i = start + 1; // 작은 포인터
		int j = start + 1;
		for(; j<end+1; j++) {
			if(arr[j] < arr[start]) {
				swap(arr, i, j);
				++i;
			}
		}
		swap(arr, start, i-1);

		return i-1;
	}
	public static void quickSort(int[] arr, int start, int end) {
		if(start>=end) return;
		int p = choosePivot(arr, start, end);
		int mid = partition(arr, p, start, end);
		quickSort(arr, start, mid-1);
		quickSort(arr, mid+1, end);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T;i++) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for(int j=0; j<N; j++) {
				arr[j] = in.nextInt();
			}
			quickSort(arr, 0, arr.length-1);
			for(int n: arr) System.out.print(n+" ");
		}
	}

}
