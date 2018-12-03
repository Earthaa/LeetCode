class Solution(object):
    def judge(self,matrix,row,col,n):
        for i in range(0,row):
            if matrix[i][col] == "Q":
                return False
            if col - row + i >=0 and matrix[i][col - row + i] == "Q":
                return False
            if row + col - i <n and matrix[i][row + col - i] == "Q":
                return False
        return True

    def solver(self,n,matrix,res,start):
        for j in range(0,n):
            if self.judge(matrix,start,j,n):
               matrix[start][j] = "Q"
               if start == n - 1:
                   answer_matrix = []
                   res.append(1)
               else:
                   self.solver(n,matrix,res,start+1)
               matrix[start][j] = "."
            else:
                continue
    def totalNQueens(self, n):
        matrix = [(["."] * n) for i in range(0, n)]
        res = []
        self.solver(n, matrix, res, 0)
        return len(res)

MySolution = Solution()
answer = MySolution.totalNQueens(8)
print answer
