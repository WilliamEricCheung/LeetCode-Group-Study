package LeetCode.Tree;

public class MaximumAverageSubtree_1120 {
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

    class Solution {
        class resultType {
            int sum, size;
            resultType(int sum, int size){
                this.sum = sum;
                this.size = size;
            }
        }

        public resultType best;

        public double maximumAverageSubtree(TreeNode root) {
            if (root == null)   return 0;
            if (root == null)   return 0;
            double ans;
            helper(root);
            ans = (double) best.sum / best.size;
            return ans;
        }

        private resultType helper(TreeNode root) {
            if (root == null)   return new resultType(0, 0);

            resultType left = helper(root.left);
            resultType right = helper(root.right);
            resultType r = new resultType(left.sum + right.sum + root.val, left.size + right.size + 1);

            if(best == null)    best = r;
            else if (best.sum / best.size < r.sum / r.size) best = r;

            return r;
        }
    }
}
