class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = []
        if numRows <= 2:
            for row in range(numRows):
                arr = [1]
                for loc in range(row):
                    arr.append(1)
                res.append(arr)
            return res

        res = [[1], [1, 1]]
        for row in range(2, numRows):
            arr = [1]
            for loc in range(1, row):
                arr.append(res[row - 1][loc - 1] + res[row - 1][loc])
            arr.append(1)
            res.append(arr)
        return res

MySolution = Solution()
print MySolution.generate(2)

