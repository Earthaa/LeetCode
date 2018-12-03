class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        res = []
        rowIndex += 1
        if rowIndex <= 2:
            for i in range(0, rowIndex):
                res.append(1)
            return res
        res = [1, 1]
        for row in range(2, rowIndex):
            first = res[0]
            second = res[1]
            for loc in range(1, row):
                res[loc] = first + second
                first = second
                if loc + 1 < len(res):
                    second = res[loc + 1]
            res.append(1)
        return res
MySolution = Solution()
print MySolution.getRow(3)