class Solution(object):
    def helper(self,nums,permutation,answer):
        if len(permutation) == len(nums):
            answer.append(permutation)
            return
        for num in nums:
            if num not in permutation:
                self.helper(nums,permutation+[num],answer)

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        answer = []
        self.helper(nums,[],answer)
        return answer

MySolution = Solution()
answer = MySolution.permute([1,2,3,4,6,8])
for each in answer:
    print each

