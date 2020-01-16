package LeetCode.Array;

import java.util.*;

public class SubarraySumClosest {
    public class Solution {
        /*
         * @param nums: A list of integers
         * @return: A list of integers includes the index of the first number and the index of the last number
         */
        public int[] subarraySumClosest(int[] nums) {
            // write your code here
            int[] ans = new int[2];
            if (nums == null || nums.length < 2)
                return ans;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum)) {
                    ans[0] = map.get(sum) + 1;
                    ans[1] = i;
                    return ans;
                }
                map.put(sum, i);
            }

            ArrayList<Integer> sums = new ArrayList<>(map.keySet());
            Collections.sort(sums);
            int minGap = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                int sumi = sums.get(i - 1), sumj = sums.get(i);
                if (sumj - sumi < minGap) {
                    minGap = sumj - sumi;
                    ans[0] = map.get(sumi);
                    ans[1] = map.get(sumj);
                }
            }

            Arrays.sort(ans);
            ans[0]++;
            return ans;
        }
    }
}
