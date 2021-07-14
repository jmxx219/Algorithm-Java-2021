package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibo_1003 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] arr = new int[T];

		for(int i=0; i<T; i++) arr[i] = Integer.parseInt(br.readLine());

		int[] zero = new int[41];
		int[] one = new int[41];
		zero[0] = 1;
		one[0] = 0;
		zero[1] = 0;
		one[1] = 1;

		for(int j=2; j<41; j++) {
			zero[j] = zero[j-1] + zero[j-2];
			one[j] = one[j-1] + one[j-2];
		}

		for(int k=0; k<T; k++) {
			System.out.println(zero[arr[k]] + " " + one[arr[k]]); // 입력한 값에 맞춰 담긴 배열에서 
		}
	}
}
