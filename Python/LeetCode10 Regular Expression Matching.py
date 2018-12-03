class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """



MySolution = Solution()
print MySolution.isMatch("ddd","a*b*c*ddd")
# class Solution(object):
#     def isMatch(self, s, p):
#         """
#         :type s: str
#         :type p: str
#         :rtype: bool
#         """
#         Edges = []
#         Pstate = 1
#         for i in range(0,len(p)):
#             if p[i] == '*':
#                 continue
#             if i + 1 < len(p) and p[i + 1] != '*' or i + 1 == len(p):
#                 if Pstate > len(Edges):
#                     Edges.append({p[i]:Pstate + 1})
#                 else:
#                     Edges[Pstate - 1][p[i]] = Pstate + 1
#                 Pstate = Pstate + 1
#             elif i + 1 < len(p) and p[i + 1] == '*':
#                 if Pstate > len(Edges):
#                     Edges.append({'':Pstate + 1})
#                 else:
#                     Edges[Pstate - 1][''] = Pstate + 1
#                 Edges.append({p[i]: Pstate + 1})
#                 Pstate = Pstate + 1
#         print Edges
#         state = 1
#
#         i = 0
#         while i < len(s):
#             if state - 1 < len(Edges) and s[i] in Edges[state - 1]:
#                 state = Edges[state - 1][s[i]]
#                 i = i + 1
#             elif state - 1 < len(Edges) and '.' in Edges[state - 1]:
#                 state = Edges[state - 1]['.']
#                 i = i + 1
#             elif state - 1 < len(Edges) and '' in Edges[state - 1]:
#                 state = Edges[state - 1]['']
#             else:
#                 return False
#         print state
#         if state == Pstate:
#             return True
#         else:
#             return False

