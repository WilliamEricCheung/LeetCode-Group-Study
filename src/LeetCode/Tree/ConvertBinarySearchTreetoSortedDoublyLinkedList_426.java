package LeetCode.Tree;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList_426 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    class Solution {
        public Node treeToDoublyList(Node root) {
            returnType output = helper(root);
            output.min.left = output.max;
            output.max.right = output.min;
            return output.min;
        }

        private class returnType {
            public Node min;
            public Node max;
            public returnType(Node min, Node max) {
                this.min = min;
                this.max = max;
            }
        }

        private returnType helper(Node root) {
            if (root == null)   return null;

            returnType leftSub = helper(root.left);
            returnType rightSub = helper(root.right);

            if (leftSub == null && rightSub == null) {
                return new returnType(root, root);
            }
            if (leftSub != null && rightSub == null) {
                root.left = leftSub.max;
                leftSub.max.right = root;
                return new returnType(leftSub.min, root);
            }
            if (rightSub != null && leftSub == null) {
                root.right = rightSub.min;
                rightSub.min.left = root;
                return new returnType(root, rightSub.max);
            }
            else {
                root.left = leftSub.max;
                leftSub.max.right = root;
                root.right = rightSub.min;
                rightSub.min.left = root;
                return new returnType(leftSub.min, rightSub.max);
            }
        }
    }
}
