
/**
 * 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * @copyright 2021년도 1학기
 * @author 김상진
 * 1장 알고리즘 개요
 * 합병 정렬을 제외한 3종류의 정렬 알고리즘: 선택, 삽입, 버블
 */
public class Sort {
	public static void swap(int[] N, int i, int j) {
		int tmp = N[i];
		N[i] = N[j];
		N[j] = tmp;
	}
	public static void selectionSort(int[] N) {
		for(int i=0; i<N.length; i++) {
			int minLoc = i;
			for(int j=i+1; j<N.length; j++) {
				if(N[minLoc]>N[j]) minLoc = j;
			}
			if(minLoc!=i) swap(N, minLoc, i);
		}
	}
	public static void insertionSort(int[] N) {
		for(int i=1; i<N.length; i++) {
			int temp = N[i];
			int j = i-1;
			while(j>=0 && temp<N[j]) {
				N[j+1] = N[j];
				--j;
			}
			N[j+1] = temp;
		}
	}
	public static void bubbleSort(int[] N) {
		for(int i=0; i<N.length; i++) {
			boolean flag = false;
			for(int j=N.length-1; j>=i+1; j--) {
				if(N[j-1]>N[j]) {
					flag = true;
					swap(N, j-1, j);
				}
			}
			if(!flag) break;
		}
	}
}
