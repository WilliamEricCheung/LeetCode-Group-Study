package LeetCode.DepthFirstSearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {

    class Solution {
        private ArrayList<List<Integer>> ans= new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {

            //dfs();
            dfs(new LinkedList<>(), n, k, 1, 0);
            return ans;
        }

        public void dfs( LinkedList<Integer> com, int n, int k, int start, int l) {
            if(l == k) {
                ans.add(new LinkedList<>(com));
                return;
            }
            for(int i = start; i <= n-k+l+1; i++) {
                com.add(i);
                dfs(com, n, k, i+1, l+1);
                com.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Combinations_77 obj = new Combinations_77();
        Solution sl = obj.new Solution();
        List<List<Integer>> ans = sl.combine(3, 3);
        System.out.println(ans);
    }
}
