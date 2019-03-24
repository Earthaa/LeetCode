package Greedy;

public class LeetCode1021_Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int curMax = A[0] ;
        for(int i = 1; i < A.length; i++){
            curMax --;
            res = Math.max(A[i] + curMax, res);
            curMax = Math.max(A[i], curMax);
        }
        return res;
    }
}
