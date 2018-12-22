package Dynammic_Programming;
/*
* dp[i][j][1] indiates whether s1(i) equals to s2(j) and third dimension represents length.
dp[i][j][k] indicates whether s1(i, i+k) can be changed from s2(j, j+k).
if dp[i][j][l] and dp[i+l][j+l][k-l] are true, dp[i][j][k] is true. You can understand as which s1(i, i+l) and s2(j, j+l) is scramble and s1(i+l, i+k) and s2(j+l, j+k) is scramble, so s1(i, i+k) and s2(j, j+k) is scramble.
There is same argument. if dp[i][j+k-l][l] and dp[i+l][j][k-l] are true, dp[i][j][k] is true.
*/
public class LeetCode87_Scramble_String {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int m = s1.length();
        int n = s2.length();
        if (m != n) return false;

        boolean[][][] dp = new boolean[m][m][m+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 2; k <= m; k++) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= m - k; j++) {
                    dp[i][j][k] = false;
                    for (int part = 1; part < k; part++) {
                        if ((dp[i][j][l] && dp[i+l][j+l][k-l])
                                || (dp[i][j+k-l][l] && dp[i+l][j][k-l])) {
                            dp[i][j][k] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }
}
