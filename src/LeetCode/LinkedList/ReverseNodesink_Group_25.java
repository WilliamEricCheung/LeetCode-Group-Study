package LeetCode.LinkedList;

public class ReverseNodesink_Group_25 {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null)   return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            head = dummy;
            while (true) {
                head = reverseK(head, k);
                if (head == null)   break;
            }
            return dummy.next;
        }

        private ListNode reverseK(ListNode head, int k) {
            ListNode n1 = head.next;
            ListNode nk = head;
            for (int i = 0; i < k; i++) {
                nk = nk.next;
                if (nk == null)
                    return null;
            }
            ListNode nkplus = nk.next;

            ListNode prev = nkplus;
            ListNode curr = n1;
            ListNode tmp = curr.next;
            while (true) {
                curr.next = prev;
                prev = curr;
                curr = tmp;
                tmp = tmp.next;
                if (curr == nkplus)
                    break;
            }

            head.next = nk;
            return n1;
        }
    }
}
