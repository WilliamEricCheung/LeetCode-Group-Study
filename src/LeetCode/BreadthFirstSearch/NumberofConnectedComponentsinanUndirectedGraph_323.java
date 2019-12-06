package LeetCode.BreadthFirstSearch;

import java.util.*;

public class NumberofConnectedComponentsinanUndirectedGraph_323 {
    class Solution {
        public int countComponents(int n, int[][] edges) {
            if (edges == null)  return n;
            int ans = 0;

            Map<Integer, List<Integer>> map = getMap(edges);
            Set<Integer> unvisited = new HashSet<>();
            for (int i = 0; i < n; i++)
                unvisited.add(i);

            Queue<Integer> queue = new LinkedList<>();
            while (!unvisited.isEmpty()) {
                int root = unvisited.iterator().next();
                queue.offer(root);
                unvisited.remove(root);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    if (!map.containsKey(node)) continue;
                    for (int neighbor : map.get(node)) {
                        if (unvisited.contains(neighbor)) {
                            queue.offer(neighbor);
                            unvisited.remove(neighbor);
                        }
                    }
                }
                ans++;
            }

            return ans;
        }

        Map<Integer, List<Integer>> getMap(int[][] edges) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
//                List<Integer> neighbors;
                if (map.containsKey(edge[0])){
                    List<Integer> neighbors = map.get(edge[0]);
                    neighbors.add(edge[1]);
                    map.put(edge[0], neighbors);
                }
                else{
                    List<Integer> neighbors = new ArrayList<>();
                    neighbors.add(edge[1]);
                    map.put(edge[0], neighbors);
                }

                if (map.containsKey(edge[1])) {
                    List<Integer> neighbors = map.get(edge[1]);
                    neighbors.add(edge[0]);
                    map.put(edge[1], neighbors);
                }
                else{
                    List<Integer> neighbors = new ArrayList<>();
                    neighbors.add(edge[0]);
                    map.put(edge[1], neighbors);
                }
            }

            return map;
        }
    }
}
