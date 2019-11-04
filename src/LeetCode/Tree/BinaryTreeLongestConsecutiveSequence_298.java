package LeetCode.Tree;

public class BinaryTreeLongestConsecutiveSequence_298 {
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
        private int maxLength;

        public int longestConsecutive(TreeNode root) {
            maxLength = 0;
            helper(root);
            return maxLength;
        }

        private int helper(TreeNode root) {
            if (root == null)   return 0;

            int left = helper(root.left);
            int right = helper(root.right);
            int length = 1;

            if (right != 0 && root.val + 1 == root.right.val) {
                length = Math.max(right + 1, length);
            }
            if (left != 0 && root.val + 1 == root.left.val) {
                length = Math.max(left + 1, length);
            }

            maxLength = Math.max(maxLength, length);
            return length;
        }
    }


    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequence_298 cl = new BinaryTreeLongestConsecutiveSequence_298();
        Solution sl = cl.new Solution();
        TreeNode root = cl.new TreeNode(1);
        root.right = cl.new TreeNode(2);
        System.out.println(sl.longestConsecutive(root));
    }
}
