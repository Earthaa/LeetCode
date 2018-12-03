class Solution(object):
    def helper(self,nums,permutation,answer,index):
        if len(permutation) == len(nums):
            if permutation not in answer:
                answer.append(permutation)
            return
        for i in range(0,len(nums)):
            if i not in index:
                self.helper(nums,permutation+[nums[i]],answer,index+[i])
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        answer = []
        self.helper(nums, [], answer,[])
        return answer
MySolution = Solution()
answer = MySolution.permuteUnique([1,1,3,3])
for each in answer:
    print each