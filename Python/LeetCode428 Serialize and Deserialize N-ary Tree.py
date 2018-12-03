# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: Node
        :rtype: str
        """
        if root == None:
            return ""
        def do_serialize(original_root):
            array = []
            array.append(original_root.val)
            if len(original_root.children) > 0:
                for each_child in original_root.children:
                    array.append(do_serialize(each_child))
            return array
        return str(do_serialize(root))


    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: Node
        """
        if data == "":
            return None

        def helper(mystr):
            array = []
            bracket = []
            i = 1
            while i < len(mystr) - 1:
                if mystr[i] == ',' or mystr == ' ':
                    continue
                elif mystr[i] == '-' or (mystr[i] >= '0' and mystr[i] <= '9'):
                    j = i + 1
                    while mystr[j] == '-' or (mystr[j] >= '0' and mystr[j] <= '9'):
                        j += 1
                    array.append(int(mystr[i:j]))
                    i = j
                elif mystr[i] == '[':
                    bracket.append(mystr[i])
                    j = i + 1
                    while len(bracket) != 0:
                        if mystr[j] == ']':
                            bracket.pop()
                        elif mystr[j] == '[':
                            bracket.append(mystr[j])
                        j += 1
                    array.append(helper(mystr[i:j]))
                    i = j
                i += 1
            return array

        def do_deserialize(original_data):
            array = list(original_data)
            new_node = Node(val=array[0], children=[])
            if len(array) > 1:
                for i in range(1,len(array)):
                    new_node.children.append(do_deserialize((array[i])))
            return new_node
        return do_deserialize(helper(data))


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

test = codec.deserialize(codec.serialize(root))

print "abc"