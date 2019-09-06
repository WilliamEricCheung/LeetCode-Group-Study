package LeetCode.Array;

public class SubarraySumEqualsK_560 {
    //time complexity: O(n^2)
    //space complexity: O(1)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                int sum = 0;
                for(int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k)
                        count++;
                }
            }
            return count;

        }
    }
}
