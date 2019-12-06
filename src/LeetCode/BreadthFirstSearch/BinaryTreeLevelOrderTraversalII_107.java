package LeetCode.BreadthFirstSearch;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII_107 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)   return ans;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null)  queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                ans.add(level);
            }

            Collections.reverse(ans);

            return ans;
        }
    }
}
