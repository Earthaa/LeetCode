import java.util.*;
public class LeetCode975_Odd_Even_Jump {
    public int oddEvenJumps(int[] A) {
        if(A.length == 1)
            return 1;
        TreeMap<Integer,Integer> myMap = new TreeMap<>();
        Set<Integer> oddSet = new HashSet<>();
        Set<Integer> evenSet = new HashSet<>();
        oddSet.add(A.length - 1);
        evenSet.add(A.length - 1);
        myMap.put(A[A.length - 1], A.length - 1);
        for(int i = A.length - 2; i >= 0; i--){
            int num = A[i];
            Map.Entry<Integer, Integer> oddNext = myMap.ceilingEntry(num);
            Map.Entry<Integer, Integer> evenNext = myMap.floorEntry(num);
            if(oddNext != null && evenSet.contains(oddNext.getValue()))
                oddSet.add(i);
            if(evenNext != null && oddSet.contains(evenNext.getValue()))
                evenSet.add(i);
            myMap.put(num, i);
        }
        return oddSet.size();
    }
}
