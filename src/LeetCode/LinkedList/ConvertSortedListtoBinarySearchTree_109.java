package LeetCode.LinkedList;

public class ConvertSortedListtoBinarySearchTree_109 {
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null)
                return new TreeNode(head.val);
            ListNode slow = head, fast = head, tail = slow;
            while (fast != null && fast.next != null) {
                tail = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            tail.next = null;
            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);

            return root;
        }
    }
}
