class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        lsr = ""
        ssr = ""
        if len(a) >= len(b):
            lsr,ssr = a,b
        else:
            lsr,ssr = b,a
        ssr = "0" * (len(lsr) - len(ssr)) + ssr
        ans = ""
        car = 0
        for i in range(len(lsr) - 1,-1,-1):
            if int(lsr[i]) + int(ssr[i]) + car == 1:
                ans = "1" + ans
                car = 0
            elif int(lsr[i]) + int(ssr[i]) + car == 2:
                ans = "0" + ans
                car = 1
            elif int(lsr[i]) + int(ssr[i]) + car == 3:
                ans = "1" + ans
                car = 1
            elif int(lsr[i]) + int(ssr[i]) + car == 0:
                ans = "0" + ans
                car = 0
        if car == 1:
            ans = "1" + ans
        return ans
MySolution = Solution()
print MySolution.addBinary("10","1100000000")
