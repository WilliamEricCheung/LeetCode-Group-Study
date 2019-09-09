package LeetCode.DepthFirstSearch;

import java.lang.reflect.Array;
import java.util.*;

public class PermutationsII_47 {
    class Solution {
        //private Set<List<Integer>> ans_set = new HashSet<>();
        private List<List<Integer>> ans = new ArrayList<>();
        private LinkedList<Integer> curr = new LinkedList<>();
        private boolean used[];

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            for (int i = 0; i < used.length; i++)
                used[i] = false;
            perm(0, nums);

            return ans;
        }

        public void perm(int d, int[] nums) {
            if(d == nums.length) {
                ans.add(new ArrayList<Integer>(curr));
                return;
            }

            for(int i = 0; i < nums.length; i++) {
                if(used[i] == true) continue;
                if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false)   continue;
                curr.add(nums[i]);
                used[i] = true;
                perm(d+1, nums);
                curr.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII_47 perm = new PermutationsII_47();
        Solution obj = perm.new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = obj.permuteUnique(nums);
        System.out.println(ans);
    }
}
