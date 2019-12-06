package LeetCode.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses == 0)    return true;
            if (prerequisites.length >= numCourses) return false;

            //1. build the graph and count indegree;
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                List<Integer> neighbors = new ArrayList<>();
                graph.add(neighbors);
            }

            int[] indegree = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                List<Integer> neighbors = graph.get(prerequisites[i][1]);
                neighbors.add(prerequisites[i][0]);
                graph.set(prerequisites[i][1], neighbors);
                indegree[prerequisites[i][0]]++;
            }

            //2. topological sort - bfs
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0)   queue.offer(i);
            }
            List<Integer> visited = new ArrayList<>();

            while (!queue.isEmpty()) {
                int node = queue.poll();
                visited.add(node);
                for (int neighbor : graph.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            if (visited.size() == numCourses) return true;
            else return false;
        }

    }
}
