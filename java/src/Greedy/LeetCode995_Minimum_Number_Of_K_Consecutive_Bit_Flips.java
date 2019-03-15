package Greedy;

public class LeetCode995_Minimum_Number_Of_K_Consecutive_Bit_Flips {
    public int minKBitFlips2(int[] A, int K) {
        int ans = 0, n = A.length;
        for (int i = 0; i <= n - K; ++i) {
            if (A[i] == 1) continue;
            ++ans;
            for (int j = 0; j < K; ++j)
                A[i + j] ^= 1;
        }
        for (int i = n - K + 1; i < n; ++i)
            if (A[i] == 0) return -1;
        return ans;
    }
}
