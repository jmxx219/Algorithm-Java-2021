package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// �ζ�

public class Lotto_6603 {
	public static void pick(int N, int index, int[] arr, List<Integer> picked) {
		if(picked.size()==6) {
			picked.stream().forEach(s -> System.out.print(s + " "));
			System.out.println();
			return;
		}
		for(int next = index; next<N; next++) {
			picked.add(arr[next]);
			pick(N, next+1, arr, picked);
			picked.remove(picked.size()-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt( st.nextToken());
			if(N==0) break;
			List<Integer> picked = new ArrayList<>();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
			pick(N, 0, arr, picked);
			System.out.println();
		}
	}

}

class BeakJoon6603 {
	   public static int[] lotto;
	   public final static int maxSize = 6;
	   public static int lottoSize;

	   public static void printList(int[] pick) {
	      for(var x : pick) System.out.print(x + " ");
	      System.out.println();
	   }

	   public static void pick(int[] pick, int pickIndex, int lottoIndex) {
	      if(pickIndex == maxSize) {
	         printList(pick);
	         return;
	      }
	      if(lottoIndex >= lottoSize) return;

	      pick[pickIndex] = lotto[lottoIndex]; //�ζ� ��ȣ�� ���� pick�迭�� �־������ν� �� ������ ������ �ȴ�.
	      
	      pick(pick, pickIndex+1, lottoIndex+1); //pickIndex�������� �� �ڴ� ���ȣ��� ���� �ζǹ�ȣ�� �ϼ��ȴ�.
	      pick(pick, pickIndex, lottoIndex+1); //pickedIndex�� ���� lottoIndex�����ɷ� ���ָ� �ζǹ�ȣ�� �ϼ��ȴ�.
	   }

	   public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      while(true) {
	         lottoSize =sc.nextInt();
	         if(lottoSize == 0) break;
	         lotto = new int[lottoSize];
	         int[] pick = new int[6];
	         for(int i=0; i<lottoSize; i++) lotto[i] = sc.nextInt();
	         pick(pick,0, 0);
	         System.out.println();
	      }
	   }
	}
