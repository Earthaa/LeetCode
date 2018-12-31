package Binary_Search;

import java.util.Arrays;

public class LeetCode475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = -1, i = 0, len2 = heaters.length;
        for (Integer house : houses) {
            while (i < len2 - 1 && house > (heaters[i] + (heaters[i + 1] - heaters[i]) / 2))
                i++;
            ans = Math.max(ans, Math.abs(house - heaters[i]));
        }
        return ans;
    }
}
