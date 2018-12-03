class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if matrix == []:
            return []
        up = 0
        down = len(matrix)
        left = 0
        right = len(matrix[0])
        answer = []
        while True:
            for i in range(left,right):
                answer.append(matrix[up][i])
            up += 1
            if up >= down or left >= right:
                break
            for j in range (up,down):
                answer.append(matrix[j][right-1])
            right -= 1
            if up >= down or left >=right:
                break
            for i in range(right-1,left-1,-1):
                answer.append(matrix[down-1][i])
            down -= 1
            if up >= down or left >=right:
                break
            for j in range(down-1,up-1,-1):
                answer.append(matrix[j][left])
            left += 1
            if up >= down or left >=right:
                break
        return answer

MySolution = Solution()
answer = MySolution.spiralOrder([
  [1, 2, 3],
  [5, 6, 7],
  [9,10,11]
])
print answer