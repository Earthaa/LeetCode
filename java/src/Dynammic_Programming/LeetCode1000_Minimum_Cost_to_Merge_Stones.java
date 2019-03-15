package Dynammic_Programming;
import java.util.*;
public class LeetCode1000_Minimum_Cost_to_Merge_Stones {
    int[][][] dp;
    int max = 99999999;
    int K;

    public int mergeStones(int[] stones, int K) {
        this.K = K;
        int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }
        dp = new int[len + 1][len + 1][K + 1];
        int[] prefixSum = new int[len + 1];

        int i;
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        return getResult(prefixSum, 1, len, 1);
    }

    private int getResult(int[] prefixSum, int left, int right, int piles) {
        if (dp[left][right][piles] != 0) {
            return dp[left][right][piles];
        }
        Integer res = null;
        Map.Entry<Integer,Integer> myMap;


        int t;
        if (left == right) {
            res = (piles == 1) ? 0 : max;
        }
        else {
            if (piles == 1) {
                res = getResult(prefixSum, left, right, K) + prefixSum[right] - prefixSum[left - 1];
            }
            else {
                for (t = left; t < right; t++) {
                    res = Math.min(res, getResult(prefixSum, left, t, piles - 1) + getResult(prefixSum, t + 1, right, 1));
                }
            }
        }
        dp[left][right][piles] = res;
        return res;
    }
}
