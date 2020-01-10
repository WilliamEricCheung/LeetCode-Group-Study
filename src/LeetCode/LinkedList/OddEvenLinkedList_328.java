package LeetCode.LinkedList;

public class OddEvenLinkedList_328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null)   return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode odd = head;
            ListNode oddTail = odd;
            ListNode even = odd.next;
            ListNode evenTail = even;
            while (evenTail != null) {
                ListNode nextOdd = evenTail.next;
                if (nextOdd == null)    break;
                ListNode nextEven = nextOdd.next;
                oddTail.next = nextOdd;
                oddTail = nextOdd;
                oddTail.next = even;
                evenTail.next = nextEven;
                evenTail = nextEven;
            }

            return dummy.next;
        }
    }
}
