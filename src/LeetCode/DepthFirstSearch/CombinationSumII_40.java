package LeetCode.DepthFirstSearch;

import java.util.*;

public class CombinationSumII_40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
//            HashSet<List<Integer>> ans_set = new HashSet<>();
            LinkedList<Integer> tmp = new LinkedList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, ans, 0, 0, tmp);
//            List<List<Integer>> ans = new ArrayList<>(ans_set);
            return ans;
        }

        public void dfs(int[] candidates, int target, List<List<Integer>> ans, int index, int sum, LinkedList<Integer> tmp) {
            if(sum == target) {
                LinkedList<Integer> q = new LinkedList<>(tmp);
                ans.add(q);
                return;
            }

            for(int i = index; i < candidates.length; i++) {
                if(i > index && candidates[i] == candidates[i-1])   continue;
                sum += candidates[i];
                if(sum > target) break;
                tmp.add(candidates[i]);
                dfs(candidates, target, ans, i+1, sum, tmp);
                tmp.removeLast();
                sum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates ={10, 1, 2, 7, 6, 1, 5, 7};
        int sum = 15;
        CombinationSumII_40 obj = new CombinationSumII_40();
        CombinationSumII_40.Solution sl = obj.new Solution();
        List<List<Integer>> ans = sl.combinationSum2(candidates, sum);
        System.out.println(ans);
    }
}
