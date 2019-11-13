package LeetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class PathSumIII_437 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution_v1 {
        private int count;
        public int pathSum(TreeNode root, int target) {
            count = 0;
            ArrayList<Integer> sums = new ArrayList<>();
            dfs(root, sums, target);
            return count;
        }

        private void dfs(TreeNode root, ArrayList<Integer> sums, int target) {
            if (root == null)   return;
            int l = sums.size();
            int sum = 0;
            if (l == 0)     sum = root.val;
            else    sum = sums.get(l - 1) + root.val;
            if (sum == target)  count++;
            sums.add(sum);
            for (int i = l - 1; i >=0; i--) {
                if (sum - sums.get(i) == target)    count++;
            }

            dfs(root.left, sums, target);
            dfs(root.right, sums, target);

            sums.remove(l);
            return;
        }
    }

    class Solution {
        int count = 0;
        int target;
        public int pathSum(TreeNode root, int sum) {
            if (root == null)   return 0;
            target = sum;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            helper(root, map, 0);
            return count;
        }

        private void helper(TreeNode root, HashMap<Integer, Integer> map, int curr) {
            if (root == null)   return;
            curr += root.val;
            int compensate = curr - target;
            if (map.containsKey(compensate)) {
                if (map.get(compensate) != 0)   count += map.get(compensate);
            }
            if (map.containsKey(curr)) {
                int num = map.get(curr);
                num += 1;
                map.put(curr, num);
            }
            else {
                map.put(curr, 1);
            }

            helper(root.left, map, curr);
            helper(root.right, map, curr);

            map.put(curr, map.get(curr) - 1);
            return;
        }
    }
}
