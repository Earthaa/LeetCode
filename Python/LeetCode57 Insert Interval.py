# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        s, e = newInterval.start, newInterval.end
        left = [i for i in intervals if i.end < s]
        right = [i for i in intervals if i.start > e]

        if left + right != intervals:
            s = min(s, intervals[len(left)].start)
            e = max(e, intervals[len(intervals) - len(right) - 1].end)
        return left + [Interval(s, e)] + right

    
# class Solution(object):
#     def insert(self, intervals, newInterval):
#         """
#         :type intervals: List[Interval]
#         :type newInterval: Interval
#         :rtype: List[Interval]
#         """
#         if intervals == [] or newInterval.end < intervals[0].start:
#             return [newInterval] + intervals
#         iter = 0
#         answer = []
#         while iter<len(intervals) and intervals[iter].end < newInterval.start:
#             answer.append(intervals[iter])
#             iter += 1
#         while iter<len(intervals) and not (intervals[iter].start > newInterval.end or intervals[iter].end < newInterval.start):
#             newInterval.start = min(newInterval.start,intervals[iter].start)
#             newInterval.end = max(newInterval.end,intervals[iter].end)
#             iter += 1
#         answer.append(newInterval)
#         while iter<len(intervals):
#             answer.append(intervals[iter])
#             iter += 1
#         return answer


i1 = Interval(1,5)
i2 = Interval(3,5)
i3 = Interval(6,7)
i4 = Interval(8,10)
i5 = Interval(12,16)
newinterval = Interval(6,8)
test = [i1]
mySolution = Solution()
answer = mySolution.insert(test,newinterval)
for each in answer:
    print each.start,each.end

