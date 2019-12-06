package LeetCode.TopologicalSort;

import java.util.*;

public class SequenceReconstruction_444 {
    class Solution {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            if (org.length == 0 || seqs.size() == 0) {
                if (org.length == 0 && seqs.size() == 0) return true;
                else return false;
            }
            Set<Integer>[] graph = new HashSet[org.length + 1];
            for (int i = 1; i <= org.length; i++) {
                graph[i] = new HashSet<>();
            }

            int[] indegree = new int[org.length + 1];
            boolean flag = false;
            for(List<Integer> list : seqs) {
                if (list.size() != 0)   flag = true;
                if (list.size() == 1)   {
                    if (list.get(0) > org.length || list.get(0) <= 0)  return false;
                }
                for (int i = 0; i < list.size() - 1; i++) {
                    int s = list.get(i), d = list.get(i+1);
                    if (s > org.length || s <= 0 || d > org.length || d <= 0)   return false;
                    if (!graph[s].contains(d)) {
                        graph[s].add(d);
                        indegree[d] ++;
                    }
                }
            }

            if (!flag)  return false;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= org.length; i++) {
                if (indegree[i] == 0)   queue.offer(i);
            }

            int index = 0;
            while (!queue.isEmpty()) {
                if (queue.size() != 1)  return false;
                int curr = queue.poll();
                if (org[index++] != curr)   return false;
                for (int i : graph[curr]) {
                    indegree[i] --;
                    if (indegree[i] == 0)   queue.offer(i);
                }
            }

            if (index != org.length)    return false;
            else return true;
        }
    }
}
