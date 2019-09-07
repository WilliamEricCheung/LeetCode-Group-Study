package LeetCode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

    //failed
    class Solution_v1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            LinkedList<Integer> tmp = new LinkedList<>();
            dfs(candidates, target, ans, 0, 0, tmp);
            return ans;
        }

        public void dfs(int[] candidates, int target, List<List<Integer>> ans, int l, int sum, LinkedList<Integer> tmp) {
            if(sum == target) {
                LinkedList<Integer> q = new LinkedList<>(tmp);
                ans.add(q);
                return;
            }
            if(sum > target || l >= candidates.length)  return;

            dfs(candidates, target, ans, l+1, sum, tmp);
            tmp.add(candidates[l]);
            dfs(candidates, target, ans, l+1, sum + candidates[l], tmp);
            tmp.removeLast();
        }
    }

    //new class: LinkedList<>(); removeLast();
    //time: 66.3%
    class Solution_v2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            LinkedList<Integer> tmp = new LinkedList<>();
            dfs(candidates, target, 0, 0, ans, tmp);
            return ans;
        }

        public void dfs(int[] candidates, int target, int index, int sum, List<List<Integer>> ans, LinkedList<Integer> tmp){
            if(sum == target) {
                List<Integer> cp = new LinkedList<>(tmp);
                ans.add(cp);
                return;
            }
            if(sum > target)    return;

            for(int i = index; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                dfs(candidates, target, i, sum + candidates[i], ans, tmp);
                tmp.removeLast();
            }
        }
    }

    //trim the tree by using sorted candidates
    //api: Arrays.sort();
    //time: 99.98%
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            LinkedList<Integer> tmp = new LinkedList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, 0, ans, tmp);
            return ans;
        }

        public void dfs(int[] candidates, int target, int index, int sum, List<List<Integer>> ans, LinkedList<Integer> tmp){
            if(sum == target) {
                List<Integer> cp = new LinkedList<>(tmp);
                ans.add(cp);
                return;
            }

            for(int i = index; i < candidates.length; i++) {
                sum += candidates[i];
                //trim the tree if current sum > target
                if(sum > target)    break;
                tmp.add(candidates[i]);
                dfs(candidates, target, i, sum, ans, tmp);
                tmp.removeLast();
                sum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates ={2,3,4,6,7};
        int sum = 6;
        CombinationSum_39 obj = new CombinationSum_39();
        Solution sl = obj.new Solution();
        List<List<Integer>> ans = sl.combinationSum(candidates, sum);
        System.out.println(ans);
    }
}
