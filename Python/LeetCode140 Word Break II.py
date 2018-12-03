class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        answer = []
        dp1 = [0 for i in range(len(s))]
        dp2 = [[-1 for i in range(len(s))] for j in range(len(s))]
        wordDict.sort(key = len)
        for i in range(0,len(s)):
            for j in range(len(wordDict)):
                start = i - len(wordDict[j]) + 1
                if start < 0:
                    break
                elif (start == 0 or dp1[start - 1] == 1) and s[start:i+1] == wordDict[j]:
                    dp2[start][i] = j
                    dp1[i] = 1

        if dp1[-1] == 0:
            return answer
        def helper(start,strs):
            if start == len(s):
                ans = strs[0]
                for i in range(1,len(strs)):
                    ans = ans + " " + strs[i]
                answer.append(ans)
                return
            for end in range(0,len(s)):
                if dp2[start][end] != -1:
                    strs.append(wordDict[dp2[start][end]])
                    helper(end + 1,strs)
                    strs.pop()
        helper(0,[])
        return answer

MySolution = Solution()
print MySolution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"])

