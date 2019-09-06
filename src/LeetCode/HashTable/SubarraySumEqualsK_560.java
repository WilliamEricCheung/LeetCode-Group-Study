package LeetCode.HashTable;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {

    //Time Complexity: O(n);
    //Space Complexity: O(1);
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(map.containsKey(sum-k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
