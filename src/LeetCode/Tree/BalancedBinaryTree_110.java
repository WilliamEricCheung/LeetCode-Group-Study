package LeetCode.Tree;

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

public class BalancedBinaryTree_110 {

    class resultType{
        boolean isBalanced;
        int height;
        resultType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return helper(root).isBalanced;
        }

        public resultType helper(TreeNode root) {

            if (root == null)   return new resultType(true, 0);

            resultType left = helper(root.left);
            resultType right = helper(root.right);

            if (!left.isBalanced || !right.isBalanced)
                return new resultType(false, -1);
            if (left.height - right.height >= 2 || left.height - right.height <= -2)
                return new resultType(false, -1);

            return new resultType(true, Math.max(left.height, right.height) + 1);
        }
    }
}
