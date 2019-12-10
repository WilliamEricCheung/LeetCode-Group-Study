package LeetCode.Array;

public class NextPermutation_31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1)   return;
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1])
                i--;
            if (i < 0) {
                inverse(nums, i + 1);
                return;
            }
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
            inverse(nums, i + 1);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void inverse(int[] nums, int i) {
            int j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }
}
