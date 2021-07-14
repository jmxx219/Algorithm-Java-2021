import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortingTest {

	@Test
	void selectionSortTest() {
		int[] sorted = {1,2,3,4,5,6,7,8};
		int[] nums = {5,4,1,8,7,2,6,3};
		Sort.selectionSort(nums);
		assertArrayEquals(sorted,nums);
		nums = new int[] {8,7,6,5,4,3,2,1};
		Sort.selectionSort(nums);
		assertArrayEquals(sorted,nums);
		nums = new int[] {1,2,3,4,5,6,7,8};
		Sort.selectionSort(nums);
		assertArrayEquals(sorted,nums);
	}
	@Test
	void insertionSortTest() {
		int[] sorted = {1,2,3,4,5,6,7,8};
		int[] nums = {5,4,1,8,7,2,6,3};
		Sort.insertionSort(nums);
		assertArrayEquals(sorted,nums);
		nums = new int[] {8,7,6,5,4,3,2,1};
		Sort.insertionSort(nums);
		assertArrayEquals(sorted,nums);
		nums = new int[] {1,2,3,4,5,6,7,8};
		Sort.insertionSort(nums);
		assertArrayEquals(sorted,nums);
	}
	@Test
	void bubbleSortTest() {
		int[] sorted = {1,2,3,4,5,6,7,8};
		int[] nums = {5,4,1,8,7,2,6,3};
		Sort.bubbleSort(nums);
		assertArrayEquals(sorted,nums);
		nums = new int[] {8,7,6,5,4,3,2,1};
		Sort.bubbleSort(nums);
		assertArrayEquals(sorted,nums);
		nums = new int[] {1,2,3,4,5,6,7,8};
		Sort.insertionSort(nums);
		assertArrayEquals(sorted,nums);
	}
}
