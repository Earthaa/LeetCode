class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 1 or x == 2 or x == 3:
            return 1
        if x == 4 or x == 5:
            return 2
        lo = 0
        hi = x/2
        while True:
            mid = (lo + hi) / 2
            if mid * mid <= x and (mid + 1)*(mid + 1) > x:
                return mid
            elif mid * mid > x:
                hi = mid
            elif mid * mid < x:
                lo = mid

MySolution = Solution()
print MySolution.mySqrt(2)