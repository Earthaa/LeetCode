import java.util.*;
public class LeetCode930_Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] A, int S) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        for (int x: P) {
            ans += count.getOrDefault(x, 0);
            count.put(x+S, count.getOrDefault(x+S, 0) + 1);
        }
        Map<String,String> tmp = new HashMap<>();
        tmp.entrySet()
        return ans;
        Map.Entry<String,String> tms;
        List<String> t = new LinkedList<>();
        t.s
    }
}
