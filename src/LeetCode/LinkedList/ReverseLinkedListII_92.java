package LeetCode.LinkedList;

public class ReverseLinkedListII_92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            head = dummy;

            for (int i = 1; i < m; i++)
                head = head.next;
            ListNode before = head;
            head = head.next;
            ListNode tail = head;

            ListNode prev = null;
            for (int i = m; i <= n; i++) {
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
            }
            before.next = prev;
            tail.next = head;

            return dummy.next;

        }
    }
}
