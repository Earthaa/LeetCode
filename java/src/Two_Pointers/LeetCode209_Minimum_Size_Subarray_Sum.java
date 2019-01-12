package Two_Pointers;

public class LeetCode209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum >= s){
                while(left <= s && sum >= s){
                    ans = Math.min(i - left + 1,ans);
                    sum -= nums[left];
                    left++;
                }
            }
        }
        return ans != Integer.MAX_VALUE? ans:0;
    }
}
