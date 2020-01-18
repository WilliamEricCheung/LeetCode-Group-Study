package LeetCode.TwoPointers;

public class MoveZeroes_283 {
    class Solution  {
        public void moveZeroes(int[] nums) {
            if (nums.length < 2)
                return;

            int i = 0;
            while (nums[i] != 0 && i + 1 < nums.length)
                i++;
            if (i >= nums.length - 1)
                return;
            int j = i + 1;
            while(nums[j] == 0 && j + 1 < nums.length)
                j++;
            if (j == nums.length)
                return;

            while (j < nums.length) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
                if (j < nums.length)
                    while (nums[j] == 0 && j + 1 < nums.length)
                        j++;
            }
        }
    }
}
