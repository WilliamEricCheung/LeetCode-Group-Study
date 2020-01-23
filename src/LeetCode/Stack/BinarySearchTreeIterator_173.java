package LeetCode.Stack;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class BSTIterator {
        private Stack<TreeNode> stack;

        private void pushStack(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.pushStack(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode top = stack.pop();

            TreeNode tmp = top.right;
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            return top.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
