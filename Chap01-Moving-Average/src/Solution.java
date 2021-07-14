/**
 * 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * @copyright 2021년도 1학기
 * @author 김상진
 * 1장 알고리즘 개요
 * 이동 평균
 */
public class Solution {
	// O(n^2)
	public static double[] movingAverage01(int[] N, int M) {
		double[] result = new double[N.length-M+1];
		int k = 0;
		for(int i=M-1; i<N.length; i++) {
			int sum = 0;
			for(int j=0; j<M; j++)
				sum += N[i-j];
			result[k++] = (double)sum/M;
		}
		return result;
	}
	// O(n)
	public static double[] movingAverage02(int[] N, int M) {
		double[] result = new double[N.length-M+1];
		int k = 0;
		int sum = 0;
		for(int i=0; i<M-1; i++) {
			sum += N[i];
		}
		for(int i=M-1; i<N.length; i++) {
			sum += N[i];
			result[k++] = (double)sum/M;
			sum -= N[i-M+1];
		}
		return result;
	}
}
