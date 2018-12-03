# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def sortInterval(self,x):
        return x.start
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        answer = []
        if intervals == []:
            return answer
        intervals.sort(key = self.sortInterval)
        new_interval = Interval(intervals[0].start,intervals[0].end)
        for each in intervals:
            if each.start > new_interval.end:
                answer.append(new_interval)
                new_interval = Interval(each.start,each.end)
            elif each.end > new_interval.end:
                new_interval.end = each.end
            else:
                continue
        answer.append(new_interval)
        return answer

i1 = Interval(1,3)
i2 = Interval(2,6)
i3 = Interval(8,10)
i4 = Interval(15,18)
i5 = Interval(3,14)
test = [i1,i2,i3,i4,i5]
mySolution = Solution()
answer = mySolution.merge(test)
for each in answer:
    print each.start,each.end
