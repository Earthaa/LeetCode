class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        delta = []
        for i in range(len(gas)):
            delta.append(gas[i] - cost[i])
        if sum(delta) < 0:
            return -1
        i = 0
        cur = 0
        start = 0
        while i < len(delta):
            if cur + delta[i] >= 0:
                cur = cur + delta[i]
            else:
                cur = 0
                start = i + 1
            i = i + 1
        return start

MySolution = Solution()
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
print MySolution.canCompleteCircuit(gas,cost)

