class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        # step 1: flip the matrix over its diagonal ( the transpose of the matrix )
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        # step 2: exchange the columns
        for i in range(n):
            for j in range(n / 2):
                matrix[i][j], matrix[i][n - j - 1] = matrix[i][n - j - 1], matrix[i][j]


# class Solution(object):
#     def rotate(self, matrix):
#         """
#         :type matrix: List[List[int]]
#         :rtype: void Do not return anything, modify matrix in-place instead.
#         """
#         N = len(matrix)
#         new_matrix = [([0] * N) for i in range(N)]
#         for i in range(0,N):
#             for j in range(0,N):
#                 new_matrix[j][N-i-1] = matrix[i][j]
#         for i in range(0,N):
#             for j in range(0,N):
#                 matrix[i][j] = new_matrix[i][j]
matrix = [
  [1,2,3],
  [4,5,6],
  [7,8,9]
]
MySolution = Solution()
MySolution.rotate(matrix)

print matrix