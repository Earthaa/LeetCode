class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        return self.resolverpn(tokens)
    def resolverpn(self,rpn):
        num = []
        for i in range(0,len(rpn)):
            if rpn[i] == "+":
                ro = num.pop()
                lo = num.pop()
                num.append(lo + ro)
            elif rpn[i] == "-":
                ro = num.pop()
                lo = num.pop()
                num.append(lo - ro)
            elif rpn[i] == "*":
                ro = num.pop()
                lo = num.pop()
                num.append(lo * ro)
            elif rpn[i] == "/":
                ro = num.pop()
                lo = num.pop()
                if lo / ro < 0 and lo % ro != 0:
                    num.append(lo / ro + 1)
                else:
                    num.append(lo / ro)
            else:
                num.append(int(rpn[i]))
        return num[0]
MySolution = Solution()
print MySolution.evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"])
