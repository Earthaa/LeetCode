package Dynammic_Programming;

public class LeetCode276_Paint_Fence {
    public int numWays(int n, int k) {
        //We should just consider the color of i and i - 1
        //and then do DP
        if(n == 0)
            return 0;
        int numsDiff = k;
        int numsSame = 0;
        for(int i = 2; i <= n; i++){
            int preSame = numsSame;
            numsSame = numsDiff;
            numsDiff = preSame * (k - 1) + numsDiff * (k - 1);
        }
        return numsSame + numsDiff;
    }
}
