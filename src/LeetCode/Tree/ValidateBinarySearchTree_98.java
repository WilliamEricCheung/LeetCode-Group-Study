package LeetCode.Tree;

public class ValidateBinarySearchTree_98 {
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
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null)   return true;
            returnType output = helper(root);
            return output.isBST;
        }

        private class returnType {
            boolean isBST;
            int min;
            int max;
            returnType(boolean isBST, int min, int max) {
                this.isBST = isBST;
                this.min = min;
                this.max = max;
            }
        }

        private returnType helper(TreeNode root) {
            if (root.left == null && root.right == null)    return new returnType(true, root.val, root.val);
            if (root.left == null) {
                returnType right = helper(root.right);
                return new returnType(right.min > root.val && right.isBST, root.val, right.max);
            }
            if (root.right == null){
                returnType left = helper(root.left);
                return new returnType(left.max < root.val && left.isBST, left.min, root.val);
            }

            returnType left = helper(root.left);
            returnType right = helper(root.right);

            boolean isBST = left.isBST && right.isBST && root.val > left.max && root.val < right.min;
            int min = left.min;
            int max = right.max;
            return new returnType(isBST, min, max);
        }
    }
}
