package Dynammic_Programming;
/*
* dp[i][j][1] indiates whether s1(i) equals to s2(j) and third dimension represents length.
dp[i][j][k] indicates whether s1(i, i+k) can be changed from s2(j, j+k).
if dp[i][j][l] and dp[i+l][j+l][k-l] are true, dp[i][j][k] is true. You can understand as which s1(i, i+l) and s2(j, j+l) is scramble and s1(i+l, i+k) and s2(j+l, j+k) is scramble, so s1(i, i+k) and s2(j, j+k) is scramble.
There is same argument. if dp[i][j+k-l][l] and dp[i+l][j][k-l] are true, dp[i][j][k] is true.
*/
public class LeetCode87_Scramble_String {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int[][][] dp = new int[s1.length()][s1.length()][s1.length() + 1];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j][1] = 1;}
            }
        }
        for(int l = 2; l <= s1.length(); l++){
            for(int i = 0; i <= s1.length() - l; i++){
                for(int j = 0; j <= s2.length() - l; j++){
                    for(int k = 1; k < l; k++){
                        if((dp[i][j][k] == 1 && dp[i+k][j+k][l-k] == 1)||
                                dp[i][j+l-k][k] == 1 && dp[i+k][j][l-k] == 1){
                            dp[i][j][l] = 1;
                        }
                    }
                }
            }
        }
        return dp[0][0][s1.length()] == 1;
    }
}
