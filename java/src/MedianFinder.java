import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Set;

class MedianFinder {
//    /*Solution by using BST. We should use multiset but that's not provided by java
//     */
//    public MedianFinder() {
//
//    }
//
//    public void addNum(int num) {
//
//    }
//
//    public double findMedian() {
//
//    }
    /* Solution by using two heaps
     */
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;
    int allCount = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        allCount = 0;
    }

    public void addNum(int num) {
        allCount += 1;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if((allCount & 1) == 1)
            return new Double(maxHeap.peek());
        else
            return(maxHeap.peek()+minHeap.peek())/2.0;
    }
}
