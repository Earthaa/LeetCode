package Dynammic_Programming;

public class LeetCode300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];//To save the length of longest LIS that end with dp[i]
        for(int i = 0; i <= nums.length - 1; i++){
            dp[i] = 1;
            int maxLIS = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    maxLIS = Math.max(dp[j], maxLIS);
            }
            if(maxLIS != Integer.MIN_VALUE)
                dp[i] = maxLIS + dp[i];
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
