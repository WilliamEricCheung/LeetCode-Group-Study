from typing import List


class TreeNode:
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None
class Solution:
    res=[]
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        def dfs(node):
            if(node.left!=None):
                dfs(node.left)
            self.res.append(node.val)
            if(node.right!=None):
                dfs(node.right)
        self.res=[]
        if not root:
            return self.res
        dfs(root)
        return self.res