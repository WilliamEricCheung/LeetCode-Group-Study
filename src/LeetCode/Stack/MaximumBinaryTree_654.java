package LeetCode.Stack;

import java.util.Stack;

public class MaximumBinaryTree_654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class SolutionSlow {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0)
                return null;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode(nums[0]);
            stack.push(root);
            for (int i = 1; i < nums.length; i++) {
                TreeNode node = new TreeNode(nums[i]);
                if (nums[i] > root.val) {
                    root = node;
                }

                if (nums[i] < stack.peek().val) {
                    stack.peek().right = node;
                    stack.push(node);
                }
                else {
                    TreeNode top = stack.pop();
                    while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                        top = stack.pop();
                    }
                    node.left = top;
                    if (!stack.isEmpty())
                        stack.peek().right = node;
                    stack.push(node);
                }
            }

            return root;
        }
    }
}
