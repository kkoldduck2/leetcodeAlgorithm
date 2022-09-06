# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        
        max_dept = 0
        if root.left is not None:
            max_dept = max(1+self.maxDepth(root.left), max_dept)
        if root.right is not None :
            max_dept = max(1+self.maxDepth(root.right), max_dept)
        
        return max_dept