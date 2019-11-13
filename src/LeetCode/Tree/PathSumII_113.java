package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<List<Integer>> ans;
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            ans = new ArrayList<>();
            if (root == null)   return ans;
            LinkedList<Integer> path = new LinkedList<>();
            dfs(root, sum, path);
            return ans;
        }

        private void dfs(TreeNode root, int sum, LinkedList<Integer> path) {
            path.add(root.val);
            int thisSum = sum - root.val;
            if (root.left == null && root.right == null && thisSum == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            if(root.left != null)   {
                dfs(root.left, thisSum, path);
                path.removeLast();
            }
            if(root.right != null) {
                dfs(root.right, thisSum, path);
                path.removeLast();
            }
        }
    }
}
