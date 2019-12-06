package LeetCode.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree_297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)   return "[]";
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            sb.append(root.val);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sb.append(',');
                if (node.left != null) {
                    sb.append(node.left.val);
                    queue.offer(node.left);
                }
                else
                    sb.append("null");

                sb.append(',');
                if (node.right != null){
                    sb.append(node.right.val);
                    queue.offer(node.right);
                }
                else
                    sb.append("null");
            }

            sb.append(']');

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]"))  return null;

            String[] array = data.substring(1, data.length() - 1).split(",");
            int index = 0;
            ArrayList<TreeNode> queue = new ArrayList<>();
            TreeNode root = new TreeNode(Integer.valueOf(array[0]));
            queue.add(root);
            boolean isLeft = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i].equals("null")) {
                    if (!isLeft)    index++;
                    isLeft = !isLeft;
                    continue;
                }
                TreeNode node = new TreeNode(Integer.valueOf(array[i]));
                queue.add(node);

                if (isLeft) queue.get(index).left = node;
                else    queue.get(index).right = node;

                if (!isLeft)    index++;
                isLeft = !isLeft;
            }

            return root;
        }
    }
}
