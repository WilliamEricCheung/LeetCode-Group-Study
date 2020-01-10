package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            HashMap<Node, Node> map = new HashMap<>();
            Node p = head;
            while (p != null) {
                map.put(p, new Node(p.val));
                p = p.next;
            }

            p = head;
            while (p != null) {
                map.get(p).next = map.get(p.next);
                map.get(p).random = map.get(p.random);
                p = p.next;
            }

            return map.get(head);
        }

//        private HashMap<Node, Node> buildMap(Node head, HashMap<Node, Node> map) {
//            while (head != null) {
//                map.put(head, new Node(head.val));
//                head = head.next;
//            }
//
//            return map;
//        }
    }
}
