package LeetCode.LinkedList;

public class SortList_148 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //my solution, merge sort, O(nlgn), O(1), 16%, 68%
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null)   return null;
            int length = 0;
            ListNode p = head;
            while (p != null) {
                length ++;
                p = p.next;
            }

            for (int step = 1; step < length; step *= 2) {
                head = splitandMerge(head, step);
            }

            return head;
        }

        private ListNode splitandMerge(ListNode head, int step) {
            ListNode merged = new ListNode(0);
            ListNode tail = merged;
            ListNode remainder = head;
            while (remainder != null) {
                ListNode h1 = remainder;
                for (int i = 0; i < step - 1; i++) {
                    remainder = remainder.next;
                    if (remainder == null)
                        break;
                }

                ListNode h2 = (remainder == null) ? null : remainder.next;
                if (remainder != null)
                    remainder.next = null;
                remainder = h2;
                for (int i = 0; i < step - 1 && remainder != null; i++) {
                    remainder = remainder.next;
                }
                if (remainder != null) {
                    ListNode tmp = remainder.next;
                    remainder.next = null;
                    remainder = tmp;
                }

                while (h1 != null && h2 != null) {
                    if (h1.val < h2.val) {
                        tail.next = h1;
                        tail = h1;
                        h1 = h1.next;
                        tail.next = null;
                    }
                    else {
                        tail.next = h2;
                        tail = h2;
                        h2 = h2.next;
                        tail.next = null;
                    }
                }
                if (h1 == null) {
                    tail.next = h2;
                    while (tail.next != null)
                        tail = tail.next;
                }
                else {
                    tail.next = h1;
                    while (tail.next != null)
                        tail = tail.next;
                }
            }

            return merged.next;
        }
    }

    //recursive merge sort, O(nlgn), O(lgn) (each recursion takes O(1)), 98%, 100%
    //slow & fast pointer to partition into halves
    class SolutionII {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode slow = head, fast = head, tail = slow;
            while (fast != null) {
                tail = slow;
                slow = slow.next;
                fast = (fast.next == null) ? null : fast.next.next;
            }

            tail.next = null;
            ListNode h1 = sortList(head);
            ListNode h2 = sortList(slow);

            return merge(h1, h2);
        }

        private ListNode merge(ListNode h1, ListNode h2) {
            ListNode result = new ListNode(0);
            ListNode tail = result;
            while (h1 != null && h2 != null) {
                if (h1.val < h2.val) {
                    tail.next = h1;
                    h1 = h1.next;
                    tail = tail.next;
                    tail.next = null;
                }
                else {
                    tail.next = h2;
                    h2 = h2.next;
                    tail = tail.next;
                    tail.next = null;
                }
            }

            tail.next = (h1 == null) ? h2 : h1;

            return result.next;
        }

    }

}
