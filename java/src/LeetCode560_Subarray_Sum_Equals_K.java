import java.util.*;
public class LeetCode560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int target = sum - k;
            if(sumMap.containsKey(target))
                count += sumMap.get(target);
            if(sum == k)
                count++;
            if(!sumMap.containsKey(sum))
                sumMap.put(sum,1);
            else
                sumMap.put(sum,sumMap.get(sum) + 1);

        }
        return count;
    }
}
