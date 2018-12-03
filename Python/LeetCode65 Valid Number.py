class Solution(object):
  def isNumber(self, s):
      """
      :type s: str
      :rtype: bool
      """
      #define a DFA
      state = [{},
              {'blank': 1, 'sign': 2, 'digit':3, '.':4},
              {'digit':3, '.':4},
              {'digit':3, '.':5, 'e':6, 'blank':9},
              {'digit':5},
              {'digit':5, 'e':6, 'blank':9},
              {'sign':7, 'digit':8},
              {'digit':8},
              {'digit':8, 'blank':9},
              {'blank':9}]
      currentState = 1
      for c in s:
          if c >= '0' and c <= '9':
              c = 'digit'
          if c == ' ':
              c = 'blank'
          if c in ['+', '-']:
              c = 'sign'
          if c not in state[currentState].keys():
              return False
          currentState = state[currentState][c]
      if currentState not in [3,5,8,9]:
          return False
      return True
# class Solution(object):
#     Edges = {
#         (1,'0'):2,(1,'1'):2,(1,'2'):2,(1,'3'):2,(1,'4'):2,(1,'5'):2,(1,'6'):2,(1,'7'):2,(1,'8'):2,(1,'9'):2,
#         (2, '0'): 2, (2, '1'): 2, (2, '2'): 2, (2, '3'): 2, (2, '4'): 2, (2, '5'): 2, (2, '6'): 2, (2, '7'): 2,
#         (2, '8'): 2, (2, '9'): 2,
#         (2,'.'):3,
#         (2,'e'):5,
#         (1,'+'):4,(1,'-'):4,
#         (3,'e'):5,
#         (3, '0'): 3, (3, '1'): 3, (3, '2'): 3, (3, '3'): 3, (3, '4'): 3, (3, '5'): 3, (3, '6'): 3, (3, '7'): 3,
#         (3, '8'): 3, (3, '9'): 3,
#         (4, '0'): 2, (4, '1'): 2, (4, '2'): 2, (4, '3'): 2, (4, '4'): 2, (4, '5'): 2, (4, '6'): 2, (4, '7'): 2,
#         (4, '8'): 2, (4, '9'): 2,
#         (5, '0'): 6, (5, '1'): 6, (5, '2'): 6, (5, '3'): 6, (5, '4'): 6, (5, '5'): 6, (5, '6'): 6, (5, '7'): 6,
#         (5, '8'): 6, (5, '9'): 6,
#         (5,'+'):9,(5,'-'):9,
#         (6, '0'): 6, (6, '1'): 6, (6, '2'): 6, (6, '3'): 6, (6, '4'): 6, (6, '5'): 6, (6, '6'): 6, (6, '7'): 6,
#         (6, '8'): 6, (6, '9'): 6,
#         (1,' '):1,(2,' '):7,(3,' '):7,(6,' '):7,(7,' '):7,
#         (1,'.'):8,(4,'.'):8,
#         (8, '0'): 3, (8, '1'): 3, (8, '2'): 3, (8, '3'): 3, (8, '4'): 3, (8, '5'): 3, (8, '6'): 3, (8, '7'): 3,
#         (8, '8'): 3, (8, '9'): 3,
#         (9, '0'): 6, (9, '1'): 6, (9, '2'): 6, (9, '3'): 6, (9, '4'): 6, (9, '5'): 6, (9, '6'): 6, (9, '7'): 6,
#         (9, '8'): 6, (9, '9'): 6,
#     }
#     Acceptings = [2,3,6,7]
#     def isNumber(self, s):
#         """
#         :type s: str
#         :rtype: bool
#         """
#         state = 1
#         for i in range(0,len(s)):
#             edge = (state,s[i])
#             if edge in self.Edges:
#                 state = self.Edges[edge]
#             else:
#                 return False
#         if state in self.Acceptings:
#             return True
#         else:
#             return False

MySolution = Solution()
print MySolution.isNumber("4e10")


