package LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists_160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB){
            int lenA = 0, lenB = 0;
            ListNode pA = headA, pB = headB;
            while (pA != null) {
                lenA ++;
                pA = pA.next;
            }

            while (pB != null) {
                lenB ++;
                pB = pB.next;
            }

            pA = headA;
            pB = headB;
            if (lenA > lenB) {
                int diff = lenA - lenB;
                for (int i = 0; i < diff; i++) {
                    pA = pA.next;
                }
            }
            else if (lenB > lenA) {
                int diff = lenB - lenA;
                for (int i = 0; i < diff; i++) {
                    pB = pB.next;
                }
            }

            while (pA != null) {
                if (pA == pB)   return pA;
                pA = pA.next;
                pB = pB.next;
            }

            return null;
        }
    }
}
