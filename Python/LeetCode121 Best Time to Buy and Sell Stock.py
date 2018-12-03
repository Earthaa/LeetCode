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
        cur_max = prices[0]
        for i in range(0, len(prices)):
            if prices[i] < cur_min:
                if max_profit < cur_max - cur_min:
                    max_profit = cur_max - cur_min
                cur_min = prices[i]
                cur_max = prices[i]
            elif prices[i] > cur_max:
                cur_max = prices[i]
        if max_profit < cur_max - cur_min:
            max_profit = cur_max - cur_min
        return max_profit

MySolution = Solution()
print MySolution.maxProfit([6,7,8,9,10,11,12])



