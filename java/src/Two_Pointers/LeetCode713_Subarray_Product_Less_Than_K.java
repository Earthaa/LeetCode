package Two_Pointers;

public class LeetCode713_Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int product = 1;
        int subarraySum = 0;
        for(; end < nums.length; end++){
            product *= nums[end];
            if(product < k){
                subarraySum = subarraySum + (end - start) + 1;
            }
            else{
                while(start <= end && product >= k){
                    product /= nums[start];
                    start++;
                }
                subarraySum = subarraySum + (end - start) + 1;
            }
        }
        return subarraySum;
    }//Two Pointers Sliding Window

    //Another Interseting way to solve this problem by using binary search
    //Using log to change product to sum
//    class Solution {
//        public int numSubarrayProductLessThanK(int[] nums, int k) {
//            if (k == 0) return 0;
//            double logk = Math.log(k);
//            double[] prefix = new double[nums.length + 1];
//            for (int i = 0; i < nums.length; i++) {
//                prefix[i+1] = prefix[i] + Math.log(nums[i]);
//            }
//
//            int ans = 0;
//            for (int i = 0; i < prefix.length; i++) {
//                int lo = i + 1, hi = prefix.length;
//                while (lo < hi) {
//                    int mi = lo + (hi - lo) / 2;
//                    if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
//                    else hi = mi;
//                }
//                ans += lo - i - 1;
//            }
//            return ans;
//        }
//    }
}
