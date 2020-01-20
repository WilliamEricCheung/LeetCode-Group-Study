package LeetCode.TwoPointers;

public class TwoSumIIInputarrayissorted_167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    int[] ans = new int[2];
                    ans[0] = left + 1;
                    ans[1] = right + 1;
                    return ans;
                }
                if (sum < target)
                    left++;
                else
                    right--;
            }

            int[] ans = new int[2];
            return ans;
        }
    }
}
