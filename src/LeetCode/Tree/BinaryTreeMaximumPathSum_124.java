package LeetCode.Tree;

public class BinaryTreeMaximumPathSum_124 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private int  maxPath;
        public int maxPathSum(TreeNode root) {
            if (root == null)   return 0;
            maxPath = Integer.MIN_VALUE;
            helper(root);
            return maxPath;
        }

        private int helper(TreeNode root) {
            if (root == null)   return 0;
            int left = helper(root.left);
            int right = helper(root.right);

            int pathSum = root.val;
            if (left > 0 && right <= 0) {
                pathSum += left;
            }
            else if (left <=0 && right > 0)  {
                pathSum += right;
            }
            else if (left > 0 && right > 0) {
                pathSum += left + right;
            }

            if (pathSum > maxPath)   maxPath = pathSum;

            int max = Math.max(left, right);
            if (max < 0)    return root.val;
            else    return root.val + max;
        }
    }
}
