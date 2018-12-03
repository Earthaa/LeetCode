class Solution(object):
    def validTree(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        if len(edges) < n - 1:
            return False
        map_dict = {}
        belong_node = [-1 for i in range(n)]
        for each in edges:
            # two new nodes
            if belong_node[each[0]] == -1 and belong_node[each[1]] == -1:
                node = min(each[0], each[1])
                map_dict[node] = [each[0], each[1]]
                belong_node[each[0]] = node
                belong_node[each[1]] = node
            # two nodes has already been in the same tree
            elif belong_node[each[0]] == belong_node[each[1]]:
                return False
            # one in a tree and the another is a new node
            elif belong_node[each[0]] == -1 or belong_node[each[1]] == -1:
                node = max(belong_node[each[0]], belong_node[each[1]])
                belong_node[each[0]] = node
                belong_node[each[1]] = node
                map_dict[node].append(each[0])
                map_dict[node].append(each[1])
            # one in a tree and the another in another  tree
            elif belong_node[each[0]] != belong_node[each[1]]:
                node_max = (lambda node1, node2: node1 if len(map_dict[node1]) >= len(map_dict[node2]) else node2)(belong_node[each[0]], belong_node[each[1]])
                node_min = (lambda node1, node2: node1 if len(map_dict[node1]) < len(map_dict[node2]) else node2)(belong_node[each[0]], belong_node[each[1]])
                for each_node in map_dict[node_min]:
                    map_dict[node_max].append(each_node)
                    belong_node[each_node] = node_max
                map_dict.pop(node_min)
        if len(map_dict) > 1:
            return False
        else:
            return True



MySolution = Solution()
print MySolution.validTree(4,[[0,1],[2,3],[1,2]])


