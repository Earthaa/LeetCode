class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        Grids = [[0 for x in range(m + 1)] for y in range(n + 1)]
        Grids[n][m - 1] = 1
        for i in range(n - 1,-1, -1):
            for j in range(m - 1,-1,-1):
                Grids[i][j] = Grids[i + 1][j] + Grids[i][j + 1]
        return Grids[0][0]

MySolution = Solution()
answer = MySolution.uniquePaths(7,3)
print answer

