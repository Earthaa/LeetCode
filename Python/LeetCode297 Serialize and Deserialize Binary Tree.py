# Definition for a binary tree node.
import collections
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""
        q = collections.deque()
        array = []
        q.append(root)
        while len(q) != 0:
            cur_node = q.popleft()
            if not cur_node:
                array.append("null")
                continue
            array.append(str(cur_node.val))
            q.append(cur_node.left)
            q.append(cur_node.right)
        return ",".join(array)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data == "":
            return None
        array = data.split(",")
        q1 = collections.deque()
        q2 = collections.deque()
        root = TreeNode(array[0])
        q1.append(root)
        i = 1

        def get_node(a_str):
            if a_str == "null":
                return None
            else:
                return TreeNode(int(a_str))
        while i < len(array):
            while len(q1) != 0:
                new_node = q1.popleft()
                if not new_node:
                    continue
                new_node.left = get_node(array[i])
                i += 1
                new_node.right = get_node(array[i])
                i += 1
                q2.append(new_node.left)
                q2.append(new_node.right)
            q1, q2 = q2, q1
        return root
        # Your Codec object will be instantiated and called as such:
codec = Codec()
root = TreeNode(1)
a = TreeNode(2)
b = TreeNode(3)
c = TreeNode(4)
d = TreeNode(5)
e = TreeNode(6)
f = TreeNode(7)
root.left = a
root.right = b
a.right = d
b.left = e
e.left = f
test = codec.deserialize(codec.serialize(root))

print "stop"