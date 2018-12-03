class Solution(object):
    def fractionAddition(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        def gcd(a,b):
            if b == 0:
                return a
            else:
                return gcd(b,a % b)
        def lcm(a,b):
            return (a * b) / gcd(a,b)

        numerator = 0
        denominator = 1
        i = 0
        while i < len(expression):
            j = i
            while j<len(expression) and expression[j] != '/':
                j = j + 1
            curnum = int(expression[i:j])
            i = j + 1
            j = i
            while j<len(expression) and expression[j] != '+' and expression[j] != '-':
                j = j + 1
            curden = int(expression[i:j])
            i = j
            nextden = lcm(max(denominator,curden),min(denominator,curden))
            numerator = (nextden / denominator) * numerator + (nextden / curden) * curnum
            denominator = nextden
            gcdnum = gcd(max(abs(numerator),denominator),min(abs(numerator),denominator))
            numerator = numerator/gcdnum
            denominator = denominator/gcdnum
        return str(numerator)+'/'+str(denominator)

MySolution = Solution()
print MySolution.fractionAddition("1/3+1/4+1/12")

