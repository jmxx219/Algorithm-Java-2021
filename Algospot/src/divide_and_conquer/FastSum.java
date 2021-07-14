package divide_and_conquer;

// 1~N ������ ���� ��

public class FastSum {
	public static int fastSum(int n) {
		if(n==1) return 1;
		if(n%2==1) return fastSum(n-1) + n; // Ȧ��
		return 2*fastSum(n/2) + (n*n/4); // ¦��
	}

	public static void main(String[] args) {
		System.out.println(fastSum(100));
	}

}
