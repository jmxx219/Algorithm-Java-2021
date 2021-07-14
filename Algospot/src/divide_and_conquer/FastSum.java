package divide_and_conquer;

// 1~N ±îÁöÀÇ ºü¸¥ ÇÕ

public class FastSum {
	public static int fastSum(int n) {
		if(n==1) return 1;
		if(n%2==1) return fastSum(n-1) + n; // È¦¼ö
		return 2*fastSum(n/2) + (n*n/4); // Â¦¼ö
	}

	public static void main(String[] args) {
		System.out.println(fastSum(100));
	}

}
