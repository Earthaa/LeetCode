class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        jumps = 0
        CurEnd = 0
        CurMax = 0
        for i in range(0,len(nums) - 1):
            CurMax = max(CurMax, nums[i] + i)
            if i == CurEnd:
                jumps = jumps + 1
                CurEnd = CurMax
        return jumps

MySolution = Solution()
print MySolution.jump([2,3,1,1,4])