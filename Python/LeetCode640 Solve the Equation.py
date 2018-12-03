class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        lo = 0
        lx = 0
        ro = 0
        rx = 0
        i = 0
        # left side
        while equation[i] != '=':
            if equation[i] >='0' and equation[i] <= '9':
                j = i
                while equation[j] != '=' and equation[j] >= '0' and equation[j] <= '9':
                    j = j + 1
                if equation[j] == 'x':
                    if i -1 >= 0 and equation[i - 1] == '-':
                        lx = lx - int(equation[i:j])
                    else:
                        lx = lx + int(equation[i:j])
                    i = j + 1
                else:
                    if i -1 >= 0 and equation[i - 1] == '-':
                        lo = lo - int(equation[i:j])
                    else:
                        lo = lo + int(equation[i:j])
                    i = j
            elif equation[i] == 'x':
                if i - 1 >= 0 and equation[i - 1] == '-':
                    lx = lx - 1
                else:
                    lx = lx + 1
                i = i + 1
            else: i = i + 1
        i = i + 1
        while i < len(equation):
            if equation[i] >='0' and equation[i] <= '9':
                j = i
                while j < len(equation) and equation[j] >= '0' and equation[j] <= '9':
                    j = j + 1
                if j < len(equation) and equation[j] == 'x':
                    if equation[i - 1] != '=' and equation[i - 1] == '-':
                        rx = rx - int(equation[i:j])
                    else:
                        rx = rx + int(equation[i:j])
                else:
                    if equation[i - 1] != '=' and equation[i - 1] == '-':
                        ro = ro - int(equation[i:j])
                    else:
                        ro = ro + int(equation[i:j])
                i = j + 1
            elif equation[i] == 'x':
                if equation[i - 1] != '=' and equation[i - 1] == '-':
                    rx = rx - 1
                else:
                    rx = rx + 1
                i = i + 1
            else: i = i + 1
        coeff = lx - rx
        rvalue = ro - lo
        if coeff == 0 and rvalue != 0:
            return "No solution"
        elif coeff == 0 and rvalue == 0:
            return "Infinite solutions"
        else:
            return "x="+str(rvalue/coeff)
MySolution = Solution()
print MySolution.solveEquation("-36=x")




