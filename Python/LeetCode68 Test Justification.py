class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        i = 0
        count = 0
        tmp = []
        ans = []
        while i < len(words):
            while i < len(words) and count + len(words[i]) <= maxWidth :
                count = count + len(words[i]) + 1
                tmp.append(words[i])
                i = i + 1
            count = count - len(tmp)
            spaceNum = len(tmp) - 1
            if i < len(words) and spaceNum != 0:
                space = (maxWidth - count) / spaceNum
                spacePlus = (maxWidth - count) % spaceNum
                str = ""
                for index in range(0,spaceNum):
                    if spacePlus != 0:
                        str = str + tmp[index] + (1 + space) * " "
                        spacePlus = spacePlus - 1
                    else:
                        str = str + tmp[index] + (space) * " "
                str = str + tmp[-1]
            elif spaceNum == 0 or i == len(words):
                str = ""
                for index in range(0,spaceNum):
                    str = str + tmp[index] + " "
                str = str + tmp[-1]
                str = str + (maxWidth - len(str)) * " "
            ans.append(str)
            count = 0
            tmp = []
        return ans

MySolution = Solution()
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
print MySolution.fullJustify(words,maxWidth)

