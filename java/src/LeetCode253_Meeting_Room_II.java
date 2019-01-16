import java.util.*;
public class LeetCode253_Meeting_Room_II {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        Comparator<Interval> comp = new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){return o1.start - o2.start;}
        };
        Comparator<Interval> compe = new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){return o1.end - o2.end;}
        };
        Arrays.sort(intervals,comp);
        int min = 1;
        PriorityQueue<Interval> queue = new PriorityQueue<>(compe);
        for(Interval interval:intervals){
            while(!queue.isEmpty()){
                if(queue.peek().end <= interval.start)
                    queue.poll();
                else
                    break;
            }
            queue.offer(interval);
            min = Math.max(min,queue.size());
        }
        return min;
    }
}
