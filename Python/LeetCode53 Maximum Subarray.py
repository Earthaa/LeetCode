class Solution(object):
    def maxSubArray(self,nums):
        for i in range(1,len(nums)):
            if(nums[i-1]>0):
                nums[i] = nums[i] + nums[i-1]
        return max(nums)
# class Solution(object):
#     def maxSubArray(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         maxSum = float('-inf')
#         for i in range(0,len(nums)):
#             if nums[i] < 0:
#                 if nums[i] > maxSum:
#                     maxSum = nums[i]
#                 continue
#             cur = nums[i]
#             curMax = nums[i]
#             for j in range(i+1,len(nums)):
#                 cur += nums[j]
#                 if cur > curMax:
#                     curMax = cur
#                 elif cur < 0:
#                     i = j + 1
#                     break
#             if curMax > maxSum:
#                 maxSum = curMax
#         return maxSum

MySolution = Solution()
answer = MySolution.maxSubArray([-2,1,-3,6,-2,9,9,-5,100])
print answer




