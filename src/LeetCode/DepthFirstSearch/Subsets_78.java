package LeetCode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    //non-recursion
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
             int n = nums.length;
             for (int i = 0; i < (1 << n); i++) {
                 List<Integer> curr = new ArrayList<>();
                 for (int j = 0; j < n; j++) {
                     if ((i & (1 << j)) == 1) {
                         curr.add(nums[j]);
                     }
                 }
                 ans.add(new ArrayList<>(curr));
             }
             return ans;
        }
    }
}
