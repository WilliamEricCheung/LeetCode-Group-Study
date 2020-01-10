package LeetCode.LinkedList;

public class LinkedListCycle_141 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head.next == null)  return false;
            ListNode slow = head.next;
            ListNode fast = slow.next;
            while (fast != null) {
                if (slow == fast)   return true;
                slow = slow.next;
                if (fast.next == null)  return false;
                fast = fast.next.next;
            }

            return false;
        }
    }
}
