package LeetCode.BreadthFirstSearch;

import java.util.*;

public class AllNodesDistanceKinBinaryTree_863 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    class Solution{
        Map<Integer, List<Integer>> graph;
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> ans = new ArrayList<>();
            if (root == null)   return ans;
            graph = new HashMap<>();
            graph.put(root.val, new ArrayList<>());
            buildGraph(null, root);

            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(target.val);
            visited.add(target.val);
            int distance = 0;
            while (!queue.isEmpty()) {
                if (distance == K) {
                    while (!queue.isEmpty()) {
                        ans.add(queue.poll());
                    }
                    break;
                }
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    for (int neighbor : graph.get(curr)) {
                        if (visited.contains(neighbor)) continue;
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
                distance++;
            }

            if (distance != K)  return new ArrayList<>();
            return ans;
        }

        private void buildGraph(TreeNode parent, TreeNode curr) {
            if (parent != null) {
                if (!graph.containsKey(parent.val)) {
                    graph.put(parent.val, new ArrayList<>());
                }
                if (!graph.containsKey(curr.val))   graph.put(curr.val, new ArrayList<>());

                graph.get(parent.val).add(curr.val);
                graph.get(curr.val).add(parent.val);
            }

            if (curr.left != null)  buildGraph(curr, curr.left);
            if (curr.right != null) buildGraph(curr, curr.right);
        }
    }
}
