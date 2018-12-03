import copy
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
                   for each in matrix:
                       answer_matrix.append("".join(each))
                   res.append(answer_matrix)
               else:
                   self.solver(n,matrix,res,start+1)
               matrix[start][j] = "."
            else:
                continue

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        matrix = [(["."] * n)for i in range(0,n)]
        res = []
        self.solver(n,matrix,res,0)
        return res

MySolution = Solution()
answer = MySolution.solveNQueens(10)
print len(answer)
# for each in answer:
#     print each

