package hw1;

import java.util.Arrays;
import java.util.Scanner;

// C: 합병 정렬

public class MergeSort {
	public static void print(int[] arr) {
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start, j = mid + 1;
		
		int tmp[] = new int[arr.length];
		int tmpIndex = start;

		while(i <= mid && j <= end) {
			if(arr[i]<arr[j]) tmp[tmpIndex++] = arr[i++];
			else tmp[tmpIndex++] = arr[j++];
		}
		
		while (i <= mid) tmp[tmpIndex++] = arr[i++];
		while (j <= end) tmp[tmpIndex++] = arr[j++];
	
		for (int index = start; index <= end; index++) {
			arr[index] = tmp[index];
		}
	}
	
	public static void merge2(int[] arr, int start, int mid, int end) { // 안됨!!!!!!!!
		int i=start, j=mid+1;
		int[] tmp = Arrays.copyOf(arr, arr.length);
		int index = start;
		
		while(i <= mid && j <= end) {
			if(tmp[i]<tmp[j]) arr[index++] = tmp[i++];
			else arr[index++] = tmp[j++];
		}
		while(i<=mid) arr[index++] = tmp[i++];
		while(j<=end) arr[index++] = tmp[j++];
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if(start<end) {
			int mid = start+(end-start) / 2; //(start+end) / 2
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
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
			mergeSort(arr, 0, arr.length-1);
			print(arr);
		}
	}
}
