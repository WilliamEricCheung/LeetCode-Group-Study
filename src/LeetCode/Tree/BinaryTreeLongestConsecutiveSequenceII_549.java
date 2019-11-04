package LeetCode.Tree;

public class BinaryTreeLongestConsecutiveSequenceII_549 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private int longestPath;

        public int longestConsecutive(TreeNode root) {
            longestPath = 0;
            helper(root);
            return longestPath;
        }

        private int[] helper(TreeNode root) {
            if (root == null)
                return new int[] {0, 0};

            int[] left = helper(root.left);
            int[] right = helper(root.right);

            int[] length = {1, 1};
            if (root.left != null) {
                if (root.val == root.left.val + 1)
                    length[0] = Math.max(length[0], left[0] + 1);
                if (root.val == root.left.val - 1)
                    length[1] = Math.max(length[1], left[1] + 1);
            }

            if (root.right != null) {
                if (root.val == root.right.val + 1)
                    length[0] = Math.max(length[0], right[0] + 1);
                if (root.val == root.right.val - 1)
                    length[1] = Math.max(length[1], right[1] + 1);
            }

            int path = length[0] + length[1] - 1;
            longestPath = Math.max(longestPath, path);
            return length;
        }
    }
}
