package LeetCode.BinarySearch;

public class FindMinimuminRotatedSortedArray_153 {
    class Solution {
        public int findMin(int[] nums) {
            int start = 0, end = nums.length - 1;
            if (nums[start] <= nums[end])    return nums[start];
            while (start + 1 < end) {
                int median = (end - start) / 2 + start;
                if(nums[median] < nums[end])    end = median;
                else start = median;
            }

            if (nums[start] < nums[end])    return nums[start];
            else    return nums[end];
        }
    }
}
