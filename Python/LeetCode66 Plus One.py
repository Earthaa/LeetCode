class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        add = 1
        if digits[len(digits) - 1] != 9:
            digits[len(digits) - 1] = digits[len(digits) - 1] + 1
            return digits
        else:
            for i in range(len(digits) - 1, -1 ,-1):
                digits[i] = digits[i] +  add
                if digits[i] == 10:
                    add = 1
                    digits[i] = 0
                else:
                    return digits
            ans = [1]
            for i in range(0,len(digits)):
                ans.append(digits[i])

            return ans

MySolution = Solution()
print MySolution.plusOne([9,9,9])

