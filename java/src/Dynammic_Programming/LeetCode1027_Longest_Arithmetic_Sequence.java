package Dynammic_Programming;
import java.util.*;
public class LeetCode1027_Longest_Arithmetic_Sequence {
    public int longestArithSeqLength(int[] A) {
        Map<Integer,Integer>[] map = new HashMap[A.length];
        int max = 0;
        for(int i = 0; i < A.length; i++){
            map[i] = new HashMap<Integer,Integer>();
            for(int j = 0; j < i; j++){
                int diff = A[i] - A[j];
                if(map[i].containsKey(diff)){
                    int newVal = Math.max(map[i].get(diff),map[j].getOrDefault(diff,1) + 1);
                    map[i].put(diff,newVal);
                }
                else
                    map[i].put(diff,map[j].getOrDefault(diff,1) + 1);
                max = Math.max(max, map[i].get(diff));
            }
        }
        return max;
    }
}
