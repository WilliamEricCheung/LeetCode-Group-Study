package LeetCode.BreadthFirstSearch;

import java.util.*;

public class GraphValidTree_261 {
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            int len = edges.length;
            if (len != n - 1)   return false;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i, new HashSet<>());
            }

            Set<Integer> v;
            for (int i = 0; i < len; i++) {
                v = map.get(edges[i][0]);
                v.add(edges[i][1]);
                map.put(edges[i][0], v);

                v = map.get(edges[i][1]);
                v.add(edges[i][0]);
                map.put(edges[i][1], v);
            }

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(0);
            visited.add(0);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                Set<Integer> neighbors = map.get(curr);
                for (Integer i : neighbors) {
                    if (visited.contains(i))    continue;
                    queue.offer(i);
                    visited.add(i);
                }
            }

            return (visited.size() == n);
        }
    }
}
