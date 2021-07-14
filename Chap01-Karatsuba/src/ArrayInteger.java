import java.util.Arrays;

/**
 * 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * @copyright 2020년도 1학기
 * @author 김상진
 * @file ArrayInteger.java
 * 1장 알고리즘 개요: Karatsuba 알고리즘
 * 정수의 각 자릿수를 배열로 유지함
 * 정수의 부호는 별도 boolean 변수 사용: isNegative 
 */
public class ArrayInteger implements Comparable<ArrayInteger>{
	private int[] number;
	private boolean isNegative = false;
	public ArrayInteger(int[] number) {
		this.number = number;
	}
	public ArrayInteger(int[] number, boolean isNegative) {
		this.number = number;
		this.isNegative = isNegative;
	}
	public boolean isNegative() {
		return isNegative;
	}
	public int[] getNumber() {
		return number;
	}
	public int size() {
		return number.length;
	}
	public void changeSign() {
		isNegative = !isNegative;
	}
	// 원래 수에 10^N 곱하기
	public void shiftLeft(int N) {
		number = Arrays.copyOf(number, number.length+N);
	}
	
	public ArrayInteger getLeftHalf() {
		int mid = ((number.length&1)==1)? number.length/2+1: number.length/2;
		return new ArrayInteger(Arrays.copyOf(number, mid));
	}
	public ArrayInteger getRightHalf() {
		int mid = ((number.length&1)==1)? number.length/2+1: number.length/2;
		return new ArrayInteger(Arrays.copyOfRange(number, mid, number.length));
	}
	
	@Override
	public int compareTo(ArrayInteger other) {
		if(size()>other.size()) return 1;
		else if(size()<other.size()) return -1;
		else {
			for(int i=0; i<number.length; --i) {
				if(number[i]>other.number[i]) return 1;
				else if(number[i]<other.number[i]) return -1;
			}
			return 0;
		}
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		ArrayInteger n = (ArrayInteger)other;
		return Arrays.equals(number, n.number)&&isNegative==n.isNegative;
	}
	@Override public String toString() {
		String output = (isNegative)? "-": "";
		return output+Arrays.toString(number);
	}
}
