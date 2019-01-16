//import java.util.*;
////Definition for an interval.
// class Design.Interval {
//      int start;
//      int end;
//      Design.Interval() { start = 0; end = 0; }
//      Design.Interval(int s, int e) { start = s; end = e; }
//  }
//
//class Design.SummaryRanges {
//
//     TreeSet<Design.Interval> mySet;
//
//    /** Initialize your data structure here. */
//    public Design.SummaryRanges() {
//        Comparator<Design.Interval> comp = (Design.Interval o1, Design.Interval o2) -> (o1.start - o2.start);
//        mySet = new TreeSet<>(comp);
//    }
//
//    public void addNum(int val) {
//        Design.Interval newInterval = new Design.Interval(val,val);
//        Design.Interval floorInterval = mySet.floor(newInterval);
//        Design.Interval ceilInterval = mySet.ceiling(newInterval);
//    String a ="abc";
//    a.length()
//
//    }
//
//    public List<Design.Interval> getIntervals() {
//
//    }
//}

/**
 * Your Design.SummaryRanges object will be instantiated and called as such:
 * Design.SummaryRanges obj = new Design.SummaryRanges();
 * obj.addNum(val);
 * List<Design.Interval> param_2 = obj.getIntervals();
 */