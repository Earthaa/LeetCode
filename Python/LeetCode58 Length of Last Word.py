class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        Words = s.strip().split(" ")
        return len(Words[len(Words)-1])

MySolution = Solution()
print MySolution.lengthOfLastWord(" Are you Ok         ")