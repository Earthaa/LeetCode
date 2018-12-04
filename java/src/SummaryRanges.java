//import java.util.*;
////Definition for an interval.
// class Interval {
//      int start;
//      int end;
//      Interval() { start = 0; end = 0; }
//      Interval(int s, int e) { start = s; end = e; }
//  }
//
//class SummaryRanges {
//
//     TreeSet<Interval> mySet;
//
//    /** Initialize your data structure here. */
//    public SummaryRanges() {
//        Comparator<Interval> comp = (Interval o1, Interval o2) -> (o1.start - o2.start);
//        mySet = new TreeSet<>(comp);
//    }
//
//    public void addNum(int val) {
//        Interval newInterval = new Interval(val,val);
//        Interval floorInterval = mySet.floor(newInterval);
//        Interval ceilInterval = mySet.ceiling(newInterval);
//    String a ="abc";
//    a.length()
//
//    }
//
//    public List<Interval> getIntervals() {
//
//    }
//}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */