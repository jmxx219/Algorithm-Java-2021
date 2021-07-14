import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;


class KaratsubaTest {
	@Ignore 
	void addTest() {
		ArrayInteger X = new ArrayInteger(new int[] {3});
		ArrayInteger Y = new ArrayInteger(new int[] {8});
		ArrayInteger ret = Karatsuba.add(X, Y);
		ArrayInteger exp = new ArrayInteger(new int[] {1,1});
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3}, true);
		Y = new ArrayInteger(new int[] {8}, true);
		ret = Karatsuba.add(X, Y);
		exp = new ArrayInteger(new int[] {1,1}, true);
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3});
		Y = new ArrayInteger(new int[] {8}, true);
		ret = Karatsuba.add(X, Y);
		exp = new ArrayInteger(new int[] {5}, true);
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3}, true);
		Y = new ArrayInteger(new int[] {8});
		ret = Karatsuba.add(X, Y);
		exp = new ArrayInteger(new int[] {5});
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {6,7,2,2,6,5,2});
		Y = new ArrayInteger(new int[] {2,8,4,0,0,0});
		ret = Karatsuba.add(X, Y);
		exp = new ArrayInteger(new int[] {7,0,0,6,6,5,2});
		assertEquals(ret, exp);
	}
	
	@Ignore 
	void subTest() {
		ArrayInteger X = new ArrayInteger(new int[] {3});
		ArrayInteger Y = new ArrayInteger(new int[] {8});
		ArrayInteger ret = Karatsuba.sub(X, Y);
		ArrayInteger exp = new ArrayInteger(new int[] {5}, true);
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3}, true);
		Y = new ArrayInteger(new int[] {8}, true);
		ret = Karatsuba.sub(X, Y);
		exp = new ArrayInteger(new int[] {5});
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3});
		Y = new ArrayInteger(new int[] {8}, true);
		ret = Karatsuba.sub(X, Y);
		exp = new ArrayInteger(new int[] {1,1});
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3}, true);
		Y = new ArrayInteger(new int[] {8});
		ret = Karatsuba.sub(X, Y);
		exp = new ArrayInteger(new int[] {1,1}, true);
		assertEquals(ret, exp);
	}

	@Ignore 
	void multiplyTest() {
		ArrayInteger X = new ArrayInteger(new int[] {3});
		ArrayInteger Y = new ArrayInteger(new int[] {8});
		ArrayInteger ret = Karatsuba.multiply(X, Y);
		ArrayInteger exp = new ArrayInteger(new int[] {2,4});
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3}, true);
		Y = new ArrayInteger(new int[] {8}, true);
		ret = Karatsuba.multiply(X, Y);
		exp = new ArrayInteger(new int[] {2,4});
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3});
		Y = new ArrayInteger(new int[] {8}, true);
		ret = Karatsuba.multiply(X, Y);
		exp = new ArrayInteger(new int[] {2,4}, true);
		assertEquals(ret, exp);
		
		X = new ArrayInteger(new int[] {3}, true);
		Y = new ArrayInteger(new int[] {8});
		ret = Karatsuba.multiply(X, Y);
		exp = new ArrayInteger(new int[] {2,4}, true);
		assertEquals(ret, exp);
	}
	@Test
	void test() {
		
		ArrayInteger X = new ArrayInteger(new int[] {7,8});
		ArrayInteger Y = new ArrayInteger(new int[] {3,4});
		ArrayInteger ret = Karatsuba.karatsuba(X, Y);
		ArrayInteger exp = new ArrayInteger(new int[] {2,6,5,2});
		assertEquals(ret, exp);
		
		
		X = new ArrayInteger(new int[] {5,6,7,8});
		Y = new ArrayInteger(new int[] {1,2,3,4});
		ret = Karatsuba.karatsuba(X, Y);
		exp = new ArrayInteger(new int[] {7,0,0,6,6,5,2});
		assertEquals(ret, exp);

	}

}
