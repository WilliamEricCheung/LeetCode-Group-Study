package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> output = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            TreeNode curr = root;
            while (curr != null || !(stack.isEmpty())) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();
                output.add(curr.val);
                curr = curr.right;
            }

            return output;
        }
    }
}
