# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        res = []
        queue = []
        queue.append(root)
        while (queue):
            temp = queue.pop()
            res.append(temp.val)
            if (temp.right != None):
                queue.append(temp.right)
            if (temp.left != None):
                queue.append(temp.left)

        return res