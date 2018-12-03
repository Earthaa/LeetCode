# Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if node == None:
            return None
        def getGraph(node,dict):
            newNode = UndirectedGraphNode(node.label)
            if dict.has_key(newNode.label) == False:
                dict[newNode.label] = newNode
            for each_node in node.neighbors:
                if dict.has_key(each_node.label) == True:
                    newNode.neighbors.append(dict[each_node.label])
                else:
                    newNode.neighbors.append(getGraph(each_node,dict))
            return newNode
        node = getGraph(node,{})
        return node

