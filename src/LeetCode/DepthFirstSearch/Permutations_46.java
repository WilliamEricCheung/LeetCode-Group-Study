package LeetCode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
    class Solution {
        private ArrayList<List<Integer>> ans = new ArrayList<>();
        private LinkedList<Integer> curr = new LinkedList<>();
        private boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            //perm()
            used = new boolean[nums.length];
            for(int i = 0; i < nums.length; i++)
                used[i] = false;
            perm(0, nums);
            return ans;
        }

        public void perm(int d, int[] nums) {
            if(d >= nums.length) {
                ans.add(new LinkedList<>(curr));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(used[i]) continue;
                curr.add((nums[i]));
                used[i] = true;
                perm(d+1, nums);
                curr.removeLast();
                used[i] = false;
            }
        }
    }
}
