package LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length < 4)
                return ans;

            Arrays.sort(nums);
            int max = nums[nums.length - 1];
            if (4 * max < target)
                return ans;

            for (int i = 0; i < nums.length - 3; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                    while ((i < nums.length - 3) && (nums[i] + 3 * max < target))
                        i++;
                    if (i < nums.length - 3) {
                        if (4 * nums[i] == target
                                && i < nums.length - 3) {
                            if (nums[i + 3] == nums[i]) {
                                ans.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                            }
                        }
                        else if (4 * nums[i] > target)
                            break;
                        else threeSum(nums, i + 1, nums.length - 1, target - nums[i], ans);
                    }
                }
            }

            return ans;
        }

        private void threeSum(int[] nums, int start, int end,
                              int target, List<List<Integer>> ans) {
            if (end - start < 2)
                return;

            for (int i = start; i < nums.length - 2; i++) {
                if (i == start || (i > start && nums[i] != nums[i - 1])) {
                    int left = i + 1, right = nums.length - 1;
                    int complement = target - nums[i];
                    while (left < right) {
                        int sum = nums[left] + nums[right];
                        if (sum == complement) {
                            ans.add(Arrays.asList(nums[start - 1], nums[i], nums[left], nums[right]));
                            left++;
                            right--;
                            while (left < right && nums[left] == nums[left - 1])
                                left++;
                            while (left < right && nums[right] == nums[right + 1])
                                right--;
                        }
                        else if (sum < complement)
                            left++;
                        else
                            right--;
                    }
                }
            }
        }
    }
}
