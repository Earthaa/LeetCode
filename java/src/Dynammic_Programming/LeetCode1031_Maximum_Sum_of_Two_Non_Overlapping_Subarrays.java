package Dynammic_Programming;

public class LeetCode1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(getRes(A,L,M),getRes(A,M,L));
    }

    private int getRes(int[] A, int L, int M){
        int res = 0;
        int[] preSum = new int[A.length + 1];
        preSum[0] = 0;
        for(int i = 1; i <= A.length; i++){
            preSum[i] = preSum[i - 1] + A[i - 1];
        }
        int LMax = -1;
        for(int i = 0; i <= A.length - L - M; i++){
            LMax = Math.max(LMax, preSum[i + L] - preSum[i]);
            int MVal = preSum[i + L + M] - preSum[i + L];
            res = Math.max(res, LMax + MVal);
        }
        return res;

    }
}
