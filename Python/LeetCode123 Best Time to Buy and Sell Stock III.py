class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) <= 1:
            return 0
        profits = [[0 for x in range(len(prices))] for y in range(3)]

        for i in range(1,3):
            min_cost = profits[i - 1][0] - prices[0]
            for j in range(1, len(prices)):
                min_cost = max(profits[i - 1][j] - prices[j], min_cost)
                profits[i][j] = max(profits[i][j - 1], prices[j] + min_cost)
        return profits[2][-1]


MySolution = Solution()
print MySolution.maxProfit([3,3,5,0,0,3,1,4])