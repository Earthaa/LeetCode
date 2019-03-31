package Dynammic_Programming;
import java.util.Arrays;
public class LeetCode322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        if(amount == 0 )
            return 0;
        Arrays.fill(dp,1000000);
        for(int i = 0; i < coins.length; i++){
            if(dp.length > coins[i])
                dp[coins[i]] = 1;
        }
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] > 0)
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == 1000000 ? -1 : dp[amount];
    }
}
