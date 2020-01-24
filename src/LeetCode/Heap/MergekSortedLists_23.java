package LeetCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists_23 {
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
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode n1, ListNode n2) {
                    return n1.val - n2.val;
                }
            });

            for (ListNode list : lists){
                if (list != null)
                    queue.add(list);
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (!queue.isEmpty()) {
                ListNode top = queue.poll();
                tail.next = top;
                if (top.next != null)
                    queue.add(top.next);
                tail = top;
                tail.next = null;
            }

            return dummy.next;
        }
    }
}
