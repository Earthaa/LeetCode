class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        first1 = float("inf")
        first2 = float("inf")
        for i in range(len(nums)):
            if nums[i] == 0:
                if first1 != float("inf"):
                    nums[i], nums[first1] = nums[first1], nums[i]
                    first1 += 1
                elif first2 != float("inf"):
                    nums[i], nums[first2] = nums[first2], nums[i]
                    first2 += 1
            if nums[i] == 1:
                if first2 != float("inf"):
                    nums[i], nums[first2] = nums[first2], nums[i]
                    if first1 == float("inf"):
                        first1 = first2
                    first2 += 1
                elif first1 == float("inf"):
                    first1 = i
            if nums[i] == 2 and first2 == float("inf"):
                first2 = i
        return nums
MySolution = Solution()
print MySolution.sortColors([1,0,1,2,1,2])


