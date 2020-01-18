package LeetCode.Array;

import java.util.Arrays;

public class RotateArray_189 {
    class Solution1 {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            rotateInRange(nums, 0, nums.length - 1);
            rotateInRange(nums, 0, k - 1);
            rotateInRange(nums, k, nums.length - 1);
        }

        private void rotateInRange(int[] nums, int left, int right) {
            while (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }

    class Solution2 {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            int[] _nums = Arrays.copyOf(nums, nums.length);
            int index = 0;
            for (int i = nums.length - k; i < nums.length; i++){
                nums[index++] = _nums[i];
            }

            for (int i =0; i < nums.length - k; i++)
                nums[index++] = _nums[i];
        }
    }
}
