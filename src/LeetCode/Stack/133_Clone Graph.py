"""
# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:

    def cloneGraph(self, node):
          def dfs(node,reach):
            if node in reach:
                return reach[node]
            new_node=Node(node.val,[])
            reach[node]=new_node
            for new_neighbors in node.neighbors:
                new_node.neighbors.append(dfs(new_neighbors,reach))
            return new_node
          if node== None:
                    return None
          return dfs(node,{})