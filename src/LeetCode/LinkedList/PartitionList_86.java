package LeetCode.LinkedList;

public class PartitionList_86 {
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
        public ListNode partition(ListNode head, int x) {
            ListNode[] dummys = new ListNode[3];
            ListNode[] tails = new ListNode[3];
            for (int i = 0; i < 3; i++) {
                dummys[i] = new ListNode(0);
                tails[i] = dummys[i];
            }

            for (ListNode p = head; p != null; p = p.next) {
                if (p.val < x) {
                    tails[0].next = p;
                    tails[0] = p;
                }
                else if (p.val == x) {
                    tails[1].next = p;
                    tails[1] = p;
                }
                else {
                    tails[2].next = p;
                    tails[2] = p;
                }
            }

            tails[0].next = dummys[1].next;
            tails[1].next = dummys[2].next;
            return dummys[0].next;
        }
    }
}
