class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """

        if num == 1:
            return True
        if num == 0 or (num % 2 != 0 and num % 3 != 0 and num % 5 != 0):
            return False
        if num % 2 == 0:
            return self.isUgly(num / 2)
        elif num % 3 == 0:
            return self.isUgly(num / 3)
        elif num % 5 == 0:
            return self.isUgly(num / 5)

MySolution = Solution()
print MySolution.isUgly(-2147483648)
