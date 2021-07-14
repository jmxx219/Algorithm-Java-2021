import java.util.Arrays;
import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부 알고리즘및실습
 * @copyright 2021년도 1학기
 * @author 김상진
 * 1장 알고리즘 개요
 * Karatsuba
 */
public class Karatsuba {
	public static ArrayInteger add(ArrayInteger X, ArrayInteger Y) {
		if(X.isNegative()!=Y.isNegative()) {
			if(X.isNegative()) {
				X.changeSign();
				return sub(Y,X);
			}
			else {
				Y.changeSign();
				return sub(X,Y);
			}
		}
		
		if(X.size()<Y.size()) {
			ArrayInteger tmp = X;
			X = Y;
			Y = tmp;
		}
		
		int[] ret = new int[X.size()+1];
		int iX = X.size()-1;
		int iY = Y.size()-1;
		
		int carry = 0;
		while(iY>=0) {
			ret[iX+1] = (X.getNumber()[iX]+Y.getNumber()[iY]+carry)%10;
			carry = (X.getNumber()[iX]+Y.getNumber()[iY]+carry)>=10? 1: 0;
			--iY;
			--iX;
		}
		while(iX>=0) {
			ret[iX+1] = (X.getNumber()[iX]+carry)%10;
			carry = (X.getNumber()[iX]+carry)>=10? 1: 0;
			--iX;
		}
		ret[iX+1] = carry;
		if(ret[0]==0) {
			ret = Arrays.copyOfRange(ret,1,ret.length);
		}
		return X.isNegative()? new ArrayInteger(ret, true): new ArrayInteger(ret);
	}
	public static ArrayInteger sub(ArrayInteger X, ArrayInteger Y) {
		if(X.isNegative()!=Y.isNegative()) {
			if(X.isNegative()) {
				Y.changeSign();
				return add(X,Y);
			}
			else {
				Y.changeSign();
				return add(X,Y);
			}
		}
		boolean isNegative = false;
		int comp = X.compareTo(Y);
		if(comp>0) {
			if(X.isNegative()) isNegative = true;
		}
		else if(comp<0) {
			ArrayInteger tmp = X;
			X = Y;
			Y = tmp;
			if(!X.isNegative()) isNegative = true;
		}
		else return new ArrayInteger(new int[] {0});
		
		int iX = X.size()-1;
		int iY = Y.size()-1;
		int[] ret = new int[Math.max(X.size(), Y.size())];
		int i = ret.length-1;
		int borrow = 0;
		while(iY>=0) {
			int k = (iX>=0)? X.getNumber()[iX]: 0;
			ret[i] = k-Y.getNumber()[iY]-borrow;
			if(ret[i]<0) {
				borrow = 1;
				ret[i] += 10;
			}
			--iY;
			--iX;
			--i;
		}
		int start = -1;
		for(int j=0; j<ret.length; j++) {
			if(ret[j]!=0) break;
			start = j;
		}
		if(start!=-1) 
		ret = Arrays.copyOfRange(ret,start+1,ret.length);
		return new ArrayInteger(ret, isNegative);
	}
	
	public static ArrayInteger multiply(ArrayInteger X, ArrayInteger Y) {
		if(X.size()==1) {
			boolean isNegative = X.isNegative()!=Y.isNegative();
			int[] ret = new int[Y.size()+1];
			int carry = 0;
			for(int i=Y.size()-1; i>=0; i--) {
				int tmp = X.getNumber()[0]*Y.getNumber()[i]+carry;
				ret[i+1] = tmp%10;
				carry = tmp/10;
			}
			ret[0] = carry;
			if(ret[0]==0) {
				ret = Arrays.copyOfRange(ret,1,ret.length);
			}
			return new ArrayInteger(ret,isNegative);
		}
		else return multiply(Y, X);
	}
	

	public static ArrayInteger karatsuba(ArrayInteger X, ArrayInteger Y) {
		if(X.size()==1||Y.size()==1) {
			return multiply(X,Y);
		}
		ArrayInteger a = X.getLeftHalf();
		ArrayInteger b = X.getRightHalf();
		int len = b.size();
		ArrayInteger c = Y.getLeftHalf();
		ArrayInteger d = Y.getRightHalf();
		
		//System.out.println(a);
		//System.out.println(b);
		//System.out.println(c);
		//System.out.println(d);
		
		ArrayInteger ac = karatsuba(a, c);
		//System.out.println("ac:"+ac);
		ArrayInteger bd = karatsuba(b, d);
		//System.out.println("bd:"+bd);
		ArrayInteger abcd = karatsuba(add(a,b), add(c,d));
		//System.out.println("(a+b)(c+d):"+abcd);
		ArrayInteger acpbd = add(ac, bd);
		//System.out.println("acpbd:"+acpbd);
		abcd = sub(abcd, acpbd);
		//System.out.println("abcd:"+abcd);
		
		ac.shiftLeft(len*2);
		ArrayInteger ret = add(ac, bd);
		//System.out.println("ac*10^len/2+bd:"+ret);
		abcd.shiftLeft(len);
		ret = add(ret, abcd);
		//System.out.println("ret:"+ret);
		return ret;
	}
}
