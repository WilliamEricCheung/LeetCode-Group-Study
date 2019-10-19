package LeetCode.DynamicProgramming;

public class MaximumSubarray_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int maxElement = Integer.MIN_VALUE;
            int curr = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > maxElement)   maxElement  = nums[i];
                curr = Math.max(0, curr + nums[i]);
                if (curr > max) max = curr;
            }
            if(maxElement < 0) return maxElement;
            return max;
        }
    }
}
