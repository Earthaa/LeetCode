package Dynammic_Programming;

public class LeetCode1035_Uncrosssed_Lines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
