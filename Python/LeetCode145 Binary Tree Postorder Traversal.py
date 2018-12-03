class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        ans = []
        nodeStack = []
        nodeStack.append(root)
        while nodeStack != []:
            if nodeStack[-1].left == None and nodeStack[-1].right == None:
                tmp = nodeStack.pop()
                ans.append(tmp.val)
                while len(nodeStack) > 0 and ((tmp == nodeStack[-1].left and nodeStack[-1].right == None) or (tmp == nodeStack[-1].right)):
                    tmp = nodeStack.pop()
                    ans.append(tmp.val)
                if len(nodeStack) > 0 and nodeStack[-1].right != None:
                    nodeStack.append(nodeStack[-1].right)
            elif nodeStack[-1].left != None:
                nodeStack.append(nodeStack[-1].left)
            elif nodeStack[-1].right != None:
                nodeStack.append(nodeStack[-1].right)
        return ans

a = TreeNode(1)
b = TreeNode(2)
c = TreeNode(3)
d = TreeNode(4)
e = TreeNode(5)
f = TreeNode(6)
a.left = b
a.right= c
b.left = d
b.right = e
c.right = f
MySolution = Solution()
print MySolution.postorderTraversal(a)