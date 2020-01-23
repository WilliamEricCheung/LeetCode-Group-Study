package LeetCode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache_146 {
    class LRUCache {
        private Map<Integer, ListNode> map;
        private int capacity, size;
        private ListNode head, tail;

        private class ListNode {
            private int key, val;
            private ListNode prev, next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private void removeNode(ListNode node) {
            map.remove(node.key);
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        private void addNode(ListNode node) {
            map.put(node.key, node);
            ListNode tmp = head.next;
            tmp.prev = node;
            node.next = tmp;
            head.next = node;
            node.prev = head;
            size++;
        }

        public LRUCache(int capacity) {
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            map = new HashMap<>();
            this.capacity = capacity;
            this.size = 0;
        }


        public int get(int key) {
            if (!map.containsKey(key))
                return -1;

            ListNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                ListNode res = map.get(key);
                if (res.val == value)
                    return;
                else removeNode(res);
            }

            ListNode node = new ListNode(key, value);
            if (size == 0) {
                head.next = node;
                node.prev = head;
                node.next = tail;
                tail.prev = node;
                map.put(key, node);
                size++;
                return;
            }

            if (size == capacity) {
                ListNode last = tail.prev;
                removeNode(last);
            }
            addNode(node);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
