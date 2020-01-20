package LeetCode.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    int[] ans = new int[2];
                    ans[0] = map.get(complement);
                    ans[1] = i;
                    return ans;
                }
                map.put(nums[i], i);
            }

            int[] ans = new int[2];
            return ans;
        }
    }
}
