package LeetCode.Heap;

import java.util.*;

public class TopKFrequentWords_692 {
    class Solution {
        class Node implements Comparable<Node> {
            int count;
            String str;

            Node(String str, int count) {
                this.str = str;
                this.count = count;
            }

            @Override
            public int compareTo(Node n) {
                if (this.count != n.count)
                    return n.count - this.count;
                else
                    return this.str.compareTo(n.str);
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> count =  new HashMap<>();
            for (String word : words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }

            Queue<Node> queue = new PriorityQueue();
            for (String str : count.keySet()) {
                Node node = new Node(str, count.get(str));
                queue.offer(node);
            }

            List<String> ans = new ArrayList();
            for (int i = 0; i < k; i++)
                ans.add(queue.poll().str);

            return ans;
        }
    }
}
