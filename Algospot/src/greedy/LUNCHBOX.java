package greedy;

//���ö� �����
import java.util.Arrays;
import java.util.Scanner;


public class LUNCHBOX {
	public static int N;
	public static int[] M;
	public static int[] E;
	public static class Pack implements Comparable<Pack>{
		public int micro;
		public int eat;

		public Pack(int micro, int eat) {
			this.micro = micro;
			this.eat = eat;
		}

		@Override
		public int compareTo(Pack o) { // �Դ� �ð� �������� ����
			return Integer.compare(o.eat, eat);
		}
	}
	public static void solve(Pack[] pack) {
		int ret = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += pack[i].micro;
			ret = Math.max(sum + pack[i].eat, ret);
		}
		System.out.println(ret);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			M = new int[N]; // ����� �ð�
			E = new int[N]; // �Դ� �ð�
			for(int j=0; j<N; j++) M[j] = sc.nextInt();
			for(int j=0; j<N; j++) E[j] = sc.nextInt();

			Pack[] pack = new Pack[N];
			for(int j=0; j<N; j++) pack[j] = new Pack(M[j], E[j]);
			
			Arrays.sort(pack);
			solve(pack);
		}
	}

}
