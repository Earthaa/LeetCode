class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        wordDict.sort(key = len)
        dp = [0 for i in range(len(s))]
        for i in range(0,len(s)):
            for j in range(0,len(wordDict)):
                start = i - len(wordDict[j]) + 1
                if start < 0:
                    break
                elif (start == 0 or dp[start - 1] == 1) and s[start:i + 1] == wordDict[j]:
                    dp[i] = 1
        if dp[-1] == 1:
            return True
        else:
            return False
MySolution = Solution()
print MySolution.wordBreak(s = "ca", wordDict = ["c", "cat"])