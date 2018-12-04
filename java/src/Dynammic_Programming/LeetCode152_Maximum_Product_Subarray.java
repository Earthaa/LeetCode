package Dynammic_Programming;

public class LeetCode152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int globalMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);
            }
            else if(nums[i] <= 0){
                int oldMax = max;
                max = Math.max(nums[i], nums[i] * min);
                min = Math.min(nums[i], nums[i] * oldMax);
            }
            globalMax = Math.max(max,globalMax);
        }
        return globalMax;
    }
}
//The dp problem, you should try to use some simple example, and then find the
//dp formula, sometimes, may be you need more than one dp state arrays.