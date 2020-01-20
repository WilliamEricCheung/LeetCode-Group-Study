package LeetCode.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    class SolutionTwoPointer {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0)
                return ans;

            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i != 0) {
                    if (nums[i] == nums[i - 1])
                        continue;
                }

                twoSum(nums, i + 1, nums.length - 1, 0 - nums[i], ans);
            }

            return ans;
        }

        private void twoSum(int[] nums, int start, int end,
                            int target, List<List<Integer>> ans) {
            int left = start, right = end;

            while (left < right) {
                while (left < right && left != start) {
                    if (nums[left] == nums[left - 1])
                        left++;
                    else
                        break;
                }

                while (left < right && right != end) {
                    if (nums[right] == nums[right + 1])
                        right--;
                    else
                        break;
                }

                if (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[start - 1]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        left++;
                        right--;
                    }
                    else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
    }

    class SolutionBetterRuntime {
        public List<List<Integer>> threeSum(int[] num) {
            Arrays.sort(num);

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < num.length; i++) {
                if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                    int left = i + 1, right = num.length - 1;
                    int target = 0 - num[i];
                    while (left < right) {
                        int sum = num[left] + num[right];
                        if (sum == target) {
                            ans.add(Arrays.asList(num[i], num[left], num[right]));
                            left++;
                            right--;
                            while(left < right && num[left] == num[left - 1])
                                left++;
                            while(left < right && num[right] == num[right + 1])
                                right--;
                        }
                        else if (sum < target)
                            left++;
                        else
                            right--;
                    }
                }
            }
            return ans;
        }
    }


}
