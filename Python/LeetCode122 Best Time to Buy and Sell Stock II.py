class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        max_profit = 0
        if len(prices) <= 1:
            return max_profit
        cur_min = prices[0]
        for i in range(0, len(prices) - 1):
           if prices[i] > prices[i + 1]:
               max_profit += prices[i] - cur_min
               cur_min = prices[i + 1]

        max_profit += prices[-1] - cur_min
        return max_profit

MySolution = Solution()
print MySolution.maxProfit([7,6,4,3,1])
