class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) <= 1:
            return 0
        print zip(prices[1:], prices[:-1])
        return sum(sell - buy for sell, buy in zip(prices[1:], prices[:-1]) if sell - buy > 0)
        profits = [0 for x in range(len(prices))]

        for i in range(0, k):
            min_cost = profits[0] - prices[0]
            for j in range(1, len(prices)):
                min_cost = max(profits[j] - prices[j], min_cost)
                profits[j] = max(profits[j - 1], prices[j] + min_cost)
        return profits[-1]

MySolution = Solution()
print MySolution.maxProfit(100, [3,2,6,5,0,3,9])