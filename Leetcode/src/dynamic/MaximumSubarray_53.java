package dynamic;

public class MaximumSubarray_53 {
	public static int maxSubArray(int[] nums) {
        
        int sum = 0;
        int maxEnding = nums[0];
		for(int i=0; i<nums.length; i++) {
			sum = Math.max(nums[i], nums[i]+sum);
			maxEnding= Math.max(maxEnding, sum);
		}
		
		return maxEnding;
    }

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

}
