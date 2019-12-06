package LeetCode.BreadthFirstSearch;

import java.util.*;

public class CloneGraph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null)   return null;
            List<Node> nodes = getNodes(node);

            Map<Node, Node> map = new HashMap<>();
            for (Node n : nodes) {
                map.put(n, new Node(n.val, new ArrayList<>()));
            }

            for (Node n: nodes) {
                Node newNode = map.get(n);
                for (Node neighbor : n.neighbors) {
                    Node newNeighbor = map.get(neighbor);
                    newNode.neighbors.add(newNeighbor);
                }
            }

            return map.get(node);
        }

        private List<Node> getNodes(Node node) {
            Queue<Node> queue = new LinkedList<>();
            Set<Node> visited = new HashSet<>();
            queue.offer(node);
            visited.add(node);

            while (!queue.isEmpty()) {
                Node n = queue.poll();
                for (Node neighbor : n.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            return new ArrayList<Node>(visited);
        }
    }
}
