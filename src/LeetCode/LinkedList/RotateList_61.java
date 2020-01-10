package LeetCode.LinkedList;

public class RotateList_61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null)   return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }

            k = k % count;
            if (k == 0) return dummy.next;
            head = dummy;
            for (int i = 0; i < count - k; i++) {
                head = head.next;
            }

            ListNode right = dummy.next;
            dummy.next = head.next;
            head.next = null;
            head = dummy.next;
            while (head.next != null)
                head = head.next;
            head.next = right;
            return dummy.next;
        }
    }
}
