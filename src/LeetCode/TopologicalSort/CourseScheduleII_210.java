package LeetCode.TopologicalSort;

import java.util.*;

public class CourseScheduleII_210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses == 0)    return null;

            //1. build the graph
            ArrayList<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }

            //2. count the indegree
            int[] indegree = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
                indegree[prerequisites[i][0]]++;
            }

            //3. topological sort
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int[] ans = new int[numCourses];
            int index = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                ans[index++] = node;
                for (int i : graph[node]) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }

            if (index == numCourses)    return ans;
            else return new int[0];
        }
    }
}
