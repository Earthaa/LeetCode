# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

'''
    The right TreeNodes share the same root Node with the root TreeNode
    And the left TreeNode should is the first child Node of the root Node
    Next Level -> left, Same Level -> right
'''
class Codec:
    def encode(self, root):
        """Encodes an n-ary tree to a binary tree.
        :type root: Node
        :rtype: TreeNode
        """
        if root == None:
            return None
        # The first child code be the left, and the following be the right series
        # of the first child code

        def get_node(original_node):
            new_node = TreeNode(original_node.val)
            if len(original_node.children) > 0:
                new_node.left = get_node(original_node.children[0])
                if len(original_node.children) > 1:
                    cur_child_node = new_node.left
                    for i in range(1, len(original_node.children)):
                        cur_child_node.right = get_node(original_node.children[i])
                        cur_child_node = cur_child_node.right
            return new_node
        return get_node(root)


    def decode(self, data):
        """Decodes your binary tree to an n-ary tree.
        :type data: TreeNode
        :rtype: Node
        """
        if data == None:
            return None

        def get_node(original_node):
            new_node = Node(val=original_node.val, children=[])
            if original_node.left != None:
                new_node.children.append(get_node(original_node.left))
                cur_child_node = original_node.left.right
                while cur_child_node != None:
                    new_node.children.append(get_node(cur_child_node))
                    cur_child_node = cur_child_node.right
            return new_node
        return get_node(data)

# Your Codec object will be instantiated and called as such:
codec = Codec()

root = Node(val=1, children=[])
a = Node(val=2, children=[])
b = Node(val=3, children=[])
c = Node(val=4, children=[])
d = Node(val=5, children=[])
e = Node(val=6, children=[])
f = Node(val=7, children=[])
g = Node(val=8, children=[])
h = Node(val=9, children=[])
root.children = [a, b, c]
a.children = [d, e, f]
b.children = [g, h]

final = codec.decode(codec.encode(root))

print(123)