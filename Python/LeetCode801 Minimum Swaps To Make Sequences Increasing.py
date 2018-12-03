# class Solution(object):
#     def minSwap(self, A, B):
#         """
#         :type A: List[int]
#         :type B: List[int]
#         :rtype: int
#         """
#         dp = [[0,1] for i in range(len(A))]
#         dp[0][0] = 0
#         dp[0][1] = 1
#         for i in range(1,len(A)):
#             if A[i] > A[i - 1] and B[i] > B[i - 1] and A[i] > B[i - 1] and B[i] > A[i - 1]:
#                 dp[i][0] = min(dp[i - 1][0],dp[i - 1][1])
#                 dp[i][1] = min(dp[i - 1][0],dp[i - 1][1]) + 1
#             elif A[i] > A[i - 1] and B[i] > B[i - 1]:
#                 dp[i][0] = dp[i - 1][0]
#                 dp[i][1] = dp[i - 1][1] + 1
#             elif A[i] > B[i - 1] and B[i] > A[i - 1]:
#                 dp[i][0] = dp[i - 1][1]
#                 dp[i][1] = dp[i - 1][0] + 1
#         return min(dp[-1])
class Solution(object):
    def minSwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        dp = [[3000,3000] for i in range(len(A))]
        dp[0][0] = 0
        dp[0][1] = 1
        for i in range(1,len(A)):
            if A[i] > A[i - 1] and B[i] > B[i - 1]:
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = dp[i - 1][1] + 1
            if A[i] > B[i - 1] and B[i] > A[i - 1]:
                dp[i][0] = min(dp[i][0],dp[i - 1][1])
                dp[i][1] = min(dp[i][1],dp[i - 1][0] + 1)
        print dp
        return min(dp[-1])
MySolution = Solution()
print MySolution.minSwap([0,7,8,10,10,11,12,13,19,18],[4,4,5,7,11,14,15,16,17,20])