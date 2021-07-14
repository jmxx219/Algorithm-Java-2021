package divide_and_conquer;

public class PowerOfNumber {
	public static int power(int n, int m) {
		if(m==0) return 1;
		else if(m==1) return n;
		System.out.println(n+" "+m);
		
		if(m%2==1) return power(n, m-1)*n;
		
		return power(n, m/2) * power(n, m/2);
	}

	public static void main(String[] args) {
		//System.out.println(power(3,3));
		System.out.println(power(2,6));
	}

}


