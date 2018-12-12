import java.util.*;
public class LeetCode352_Data_Stream_As_Disjoint_Intervals {

}

class SummaryRanges {
    TreeSet<Interval> mySet;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        mySet = new TreeSet<>(cmp);
    }

    public void addNum(int val) {
        Interval newInterval = new Interval(val,val);
        Interval floor = mySet.floor(newInterval);
        Interval ceiling = mySet.ceiling(newInterval);
        boolean flag = false;
        if(ceiling != floor){
            if(floor != null && floor.end < val && floor.end >= val - 1 ) {
                floor.end = val;
                flag = true;
            }
            if(ceiling != null && ceiling.start <= val + 1) {
                ceiling.start = val;
                flag = true;
            }
            if(ceiling != null && floor != null && floor.end + 1 >= ceiling.start){
                floor.end = ceiling.end;
                mySet.remove(ceiling);
            }
            if(floor != null && floor.end >= val){
                flag = true;
            }
        }
        else if(ceiling == floor && floor != null)
            return;
        if(flag == false )
            mySet.add(newInterval);

    }

    public List<Interval> getIntervals() {
        return new LinkedList<Interval>(mySet);
    }
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}