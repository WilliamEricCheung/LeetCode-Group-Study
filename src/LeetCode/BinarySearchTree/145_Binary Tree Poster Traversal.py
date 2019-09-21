class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        def postorder(treenode, stack):
            if (treenode.left != None):
                postorder(treenode.left, stack)
            if (treenode.right != None):
                postorder(treenode.right, stack)
            stack.append(treenode.val)

        stack = []
        if not root:
            return []
        postorder(root, stack)
        return stack

