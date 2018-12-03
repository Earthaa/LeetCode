class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if len(ratings) == 1:
            return 1
        i = 0
        j = i + 1
        yumiko = 1
        flag = 0# show the state
        ordercount = 1 # show the number of a num in a positive order
        while j < len(ratings):
            if ratings[j] == ratings[j - 1]:
                if flag != 1:
                    flag = 1
                    i = j - 1
                    ordercount = 1
                yumiko = yumiko + 1
            elif ratings[j] > ratings[j - 1]:
                if flag != 2:
                    flag = 2
                    i = j - 1
                    ordercount = 1
                yumiko = yumiko + j - i + 1
                ordercount = ordercount + 1
            elif ratings[j] < ratings[j - 1]:
                if flag != 3:
                    flag = 3
                    i = j - 1
                if j - i < ordercount:
                    yumiko = yumiko + j - i
                else:
                    yumiko = yumiko + j - i + 1
            j = j + 1
        return yumiko

MySolution = Solution()
print MySolution.candy([1,3,2,2,1])