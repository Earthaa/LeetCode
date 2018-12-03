class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        upperRange = 0
        for i in range(0,len(nums)):
            if upperRange >= len(nums) - 1:
                return True
            elif nums[i] == 0 and upperRange <= i:
                return False
            elif nums[i] + i > upperRange:
                upperRange = nums[i] + i
        return True


MySolution = Solution()
answer = MySolution.canJump([0])
print answer
