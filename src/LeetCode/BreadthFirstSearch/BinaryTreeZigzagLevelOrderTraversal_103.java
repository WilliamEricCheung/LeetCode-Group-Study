package LeetCode.BreadthFirstSearch;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)   return ans;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            boolean zig = true;
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                if (!zig)   Collections.reverse(level);
                ans.add(level);
                zig = !zig;
            }

            return ans;
        }
    }
}
