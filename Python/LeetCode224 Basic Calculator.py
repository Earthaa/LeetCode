class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.replace(" ","")
        ans = [0]
        flag = []
        if s[0] == '-' and s[1] == '(':
            flag.append(-1)
        else:
            flag.append(1)
        i = 0
        while i < len(s):
            if s[i] >= '0' and s[i] <= '9':
                j = i
                while j < len(s) and (s[j] >= '0' and s[j] <='9'):#get all the number
                    j = j + 1
                if i - 1 >= 0 and s[i - 1] == '-':
                    ans[-1] = ans[-1] - int(s[i:j])
                else:
                    ans[-1] = ans[-1] + int(s[i:j])
                i = j
            elif s[i] == '+' or s[i] == '-':
                if s[i + 1] >= '0' and s[i + 1] <='9':
                    i = i + 1
                    continue
                elif s[i] == '+':#that should be '('
                    ans.append(0)
                    flag.append(1)
                elif s[i] == '-':
                    ans.append(0)
                    flag.append(-1)
                i = i + 1
            elif s[i] == '(':
                if (i - 1 >= 0 and (s[i - 1] == '+' or s[i - 1] == '-')) or i == 0:
                    i = i + 1
                    continue
                else:
                    ans.append(0)
                    flag.append(1)
                    i = i + 1
            elif s[i] == ')':
                if len(ans) == 1 and i == len(s) - 1:
                    return ans[0]
                elif len(ans) == 1:
                    i = i + 1
                    continue
                else:
                    curflag = flag.pop()
                    curans = ans.pop()
                    ans[-1] = ans[-1] + curflag * curans
                    i = i + 1
        return ans[0]

MySolution = Solution()
print MySolution.calculate("(1+(2+(3+4)-5)-3)+6+991")







