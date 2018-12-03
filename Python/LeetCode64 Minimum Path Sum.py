class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        for i in range(0,m):
            for j in range(0,n):
                if i == 0 and j == 0:
                    continue
                elif i == 0:
                    grid[i][j] = grid[i][j] + grid[i][j - 1]
                elif j == 0:
                    grid[i][j] = grid[i][j] + grid[i - 1][j]
                else:
                    grid[i][j] = grid[i][j] + min(grid[i][j - 1],grid[i - 1][j])
        return grid[m - 1][n - 1]

MySolution = Solution()
answer = MySolution.minPathSum([
  [1],
])
print answer

