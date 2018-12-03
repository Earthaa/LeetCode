import java.util.*;
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i:nums){
            pq.add(new Integer(i));
        }
        for(int i = 1; i < k; i++)
            pq.poll();
        return pq.poll();

    }

}
