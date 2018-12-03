class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        Matrix = [[0 for x in range(n)] for y in range(n)]
        num = 1
        left = 0
        right = n - 1
        up = 0
        down = n - 1
        while left <= right:
            for i in range(left,right + 1):
                Matrix[up][i] = num
                num = num + 1
            up = up + 1
            for j in range(up ,down + 1):
                Matrix[j][right] = num
                num = num + 1
            right = right - 1
            for j in range(right,left - 1,-1):
                Matrix[down][j] = num
                num = num + 1
            down = down - 1
            for i in range(down, up - 1, -1):
                Matrix[i][left] = num
                num = num + 1
            left = left + 1
        return Matrix

MySolution = Solution()
answer = MySolution.generateMatrix(4)
print answer
