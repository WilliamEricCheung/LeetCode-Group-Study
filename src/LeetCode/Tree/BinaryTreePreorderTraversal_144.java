package LeetCode.Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();

            stack.add(root);
            while(!(stack.isEmpty())) {
                TreeNode curr = stack.pollLast();
                output.add(curr.val);
                if (curr.right != null) stack.add(curr.right);
                if (curr.left != null)  stack.add(curr.left);
            }

            return output;
        }
    }
}
