class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        n = len(obstacleGrid)
        m = len(obstacleGrid[0])
        Grids = [[0 for x in range(m + 1)] for y in range(n + 1)]
        Grids[n][m - 1] = 1
        for i in range(n - 1,-1,-1):
            for j in range(m - 1,-1,-1):
                if obstacleGrid[i][j] == 1:
                    Grids[i][j] = 0
                else:
                    Grids[i][j] = Grids[i + 1][j] + Grids[i][j + 1]
        return Grids[0][0]

MySolution = Solution()
answer = MySolution.uniquePathsWithObstacles(
[
  [0,0,0],
  [0,1,1],
  [0,0,0]
]
)
print answer
