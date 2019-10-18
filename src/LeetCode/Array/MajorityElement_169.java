package LeetCode.Array;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MajorityElement_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> table = new HashMap<>();
            for (int i = 0; i < nums.length; i ++) {
                if (table.containsKey(nums[i])) {
                    int v = table.get(nums[i]);
                    v++;
                    if (v > nums.length / 2)    return nums[i];
                    table.put(nums[i], v);
                }
                else {
                    table.put(nums[i], 1);
                    if (1 > nums.length / 2)    return nums[i];
                }
            }
            return -1;
        }
    }
}
