package LeetCode.LinkedList;

public class ReorderList_143 {
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
        public void reorderList(ListNode head) {
            ListNode reversed = new ListNode(0);
            ListNode p = head;
            int size = 0;
            while (p != null) {
                ListNode curr = new ListNode(p.val);
                p = p.next;
                ListNode tmp = reversed.next;
                reversed.next = curr;
                curr.next = tmp;
                size ++;
            }

            p = head;
            ListNode q = reversed.next;
            ListNode ans = new ListNode(0);
            ListNode tail = ans;
            for (int i = 0; i < size / 2; i++) {
                tail.next = p;
                tail = p;
                p = p.next;
                if ((i == size / 2 - 1) && (size % 2 == 1))
                    break;
                tail.next = q;
                tail = q;
                q = q.next;
            }

            head = ans.next;
        }
    }
}
