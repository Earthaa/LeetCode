class Solution(object):
    def getrpn(self,s):
        output = []
        operator = []
        priority = {'+': 1, '-': 1, '*': 2, '/': 2,'(':3}
        i = 0
        while i < len(s):
            if s[i] >= '0' and s[i] <= '9':
                j = i
                while j < len(s) and s[j] >= '0' and s[j] <= '9':
                    j = j + 1
                num = int(s[i:j])
                output.append(num)
                i = j
            elif s[i] == ')':
                while operator[-1] != '(':
                    output.append(operator.pop())
                operator.pop()
                i = i + 1
            elif len(operator) == 0 or priority[s[i]] > priority[operator[-1]]:
                operator.append(s[i])
                i = i + 1
            elif priority[s[i]] <= priority[operator[-1]]:
                while len(operator) > 0 and operator[-1] != '(' and priority[s[i]] <= priority[operator[-1]]:
                    output.append(operator.pop())
                operator.append(s[i])
                i = i + 1
        while len(operator) != 0:
            output.append(operator.pop())
        return output
    def resolverpn(self,rpn):
        num = []
        for i in range(0,len(rpn)):
            if rpn[i] == '+':
                ro = num.pop()
                lo = num.pop()
                num.append(lo + ro)
            elif rpn[i] == '-':
                ro = num.pop()
                lo = num.pop()
                num.append(lo - ro)
            elif rpn[i] == '*':
                ro = num.pop()
                lo = num.pop()
                num.append(lo * ro)
            elif rpn[i] == '/':
                ro = num.pop()
                lo = num.pop()
                num.append(lo / ro)
            else:
                num.append(rpn[i])

        return num[0]
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.replace(" ","")
        rpn = self.getrpn(s)
        return self.resolverpn(rpn)
MySolution = Solution()
print MySolution.calculate("(2+6* 3+5- (3*14/7+2)*5)+3")
