package LeetCode.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();

            if (root == null) {
                return results;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);  //加进去

            while(!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();   //拿出来
                    level.add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                results.add(level);
            }

            return results;
        }
    }
}
