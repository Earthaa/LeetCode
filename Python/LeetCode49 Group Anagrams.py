class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        strdict = {}
        for each_str in strs:
            sorted = "".join((lambda s:(s.sort(),s)[1])(list(each_str)))
            if strdict.has_key(sorted):
                strdict[sorted].append(each_str)
            else:
                strdict[sorted] = [each_str]
        answer = []
        for each in strdict.keys():
            answer.append(strdict[each])
        return answer

MySolution = Solution()
print MySolution.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
