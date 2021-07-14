import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MovingAverageTest {

	@Test
	void test() {
		int[] nums = {1,5,4,3,2};
		assertArrayEquals(Solution.movingAverage01(nums, 2), Solution.movingAverage02(nums, 2));
		assertArrayEquals(Solution.movingAverage01(nums, 3), Solution.movingAverage02(nums, 3));
	}

}
