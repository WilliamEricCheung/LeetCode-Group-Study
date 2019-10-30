package LeetCode.BinarySearch;

public class FindPeakElement_162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int start = 0, end = nums.length - 1;
            while(start + 1 < end) {
                int mid = (end - start) / 2 + start;
                if (nums[mid] > nums[mid - 1]) {
                    if (nums[mid+1] < nums[mid])    return mid;
                    else start = mid;
                }
                else end = mid;
            }

            if (nums[start] < nums[end])    return end;
            else return start;

        }
    }
}
