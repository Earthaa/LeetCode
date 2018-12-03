class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 1:
            return nums
        count1 = 0
        count2 = 0
        candidate1 = None
        candidate2 = None
        for each in nums:
            if candidate1 == each:
                count1 += 1
            elif candidate2 == each:
                count2 += 1
            elif count1 == 0:
                candidate1 = each
                count1 = 1
            elif count2 == 0:
                candidate2 = each
                count2 = 1
            else:
                count2 -= 1
                count1 -= 1

        count1, count2 = 0, 0
        res = []
        for each in nums:
            if each == candidate1:
                count1 += 1
            elif each == candidate2:
                count2 += 1

        if count1 > len(nums) / 3:
            res.append(candidate1)
        if count2 > len(nums) / 3:
            res.append(candidate2)

        return res

MySolution = Solution();
print MySolution.majorityElement([3,3,2])

