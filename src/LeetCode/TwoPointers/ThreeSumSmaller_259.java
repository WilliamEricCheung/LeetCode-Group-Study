package LeetCode.TwoPointers;

import java.util.Arrays;

public class ThreeSumSmaller_259 {
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if (nums == null || nums.length < 3)
                return 0;

            Arrays.sort(nums);
            int count = 0;
            for (int i = 0; i <= nums.length - 3; i++) {
                if (3 * nums[i] > target)
                    return count;
                int complement = target - nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] < complement) {
                        count += (right - left);
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }

            return count;
        }
    }
}
