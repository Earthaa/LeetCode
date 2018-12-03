class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        if n == 2:
            return 2
        dp = [0 for x in range(n)]
        dp[-1] = 1
        dp[-2] = 2
        for i in range(n-3,-1,-1):
            dp[i] = dp[i + 1]+dp[i + 2]
        return dp[0]

MySolution = Solution()
print MySolution.climbStairs(4)
