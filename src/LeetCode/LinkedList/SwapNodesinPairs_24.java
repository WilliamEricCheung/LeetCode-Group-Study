package LeetCode.LinkedList;

public class SwapNodesinPairs_24 {
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
        public ListNode swapPairs(ListNode head) {
            if (head == null)   return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            head = dummy;

            while (true) {
                ListNode p = head.next;
                if (p == null)  break;
                ListNode q = p.next;
                if (q == null)  break;
                p.next = q.next;
                q.next = p;
                head.next = q;
                head = p;
            }

            return dummy.next;
        }
    }
}
