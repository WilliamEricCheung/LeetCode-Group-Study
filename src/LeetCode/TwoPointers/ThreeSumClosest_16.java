package LeetCode.TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return 0;

            Arrays.sort(nums);
            int minDiff = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                    int left = i + 1, right = nums.length - 1;
                    while (left < right) {
                        int diff = target - (nums[i] + nums[left] + nums[right]);
                        if (Math.abs(diff) < minDiff) {
                            ans = nums[i] + nums[left] + nums[right];
                            minDiff = Math.abs(diff);
                        }
                        if (diff == 0)
                            return target;
                        else if (diff > 0) {
                            left++;
                        }
                        else right--;
                    }
                }
            }

            return ans;
        }
    }
}
