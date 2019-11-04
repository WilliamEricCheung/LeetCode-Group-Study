package LeetCode.Tree;

public class FlattenBinaryTreetoLinkedList_114 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void flatten(TreeNode root) {
            helper(root);
        }

        public TreeNode helper(TreeNode root) {
            if (root == null)   {
                return null;
            }

            TreeNode leftLast = helper(root.left);
            TreeNode rightLast = helper(root.right);

            if (leftLast == null) {
                if (rightLast == null)  return root;
                else return rightLast;
            }
            else {
                leftLast.right = root.right;
                root.right = root.left;
                root.left = null;
                if (rightLast != null)    return rightLast;
                else return leftLast;
            }
        }
    }
}
