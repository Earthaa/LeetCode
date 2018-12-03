class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ugly = [1]
        fac2, fac3, fac5 = 0, 0, 0
        for i in range(1, n):
            next_val = min(ugly[fac2] * 2, ugly[fac3] * 3, ugly[fac5] * 5)
            if next_val == ugly[fac2] * 2:
                fac2 += 1
            if next_val == ugly[fac3] * 3:
                fac3 += 1
            if next_val == ugly[fac5] * 5:
                fac5 += 1
            ugly.append(next_val)
        return ugly[-1]
MySolution = Solution()
print MySolution.nthUglyNumber(2)
