package Two_Pointers;

public class LeetCode209_Minimum_Size_Subarray_Sum {
    //Binary Search Method
//    public int minSubArrayLen(int s, int[] nums) {
//        if(nums.length == 0)
//            return 0;
//        int[] sums = new int[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            if(i > 0)
//                sums[i] = sums[i - 1] + nums[i];
//            else
//                sums[i] = nums[i];
//        }
//        int res = Integer.MAX_VALUE;
//        for(int i = 0; i < sums.length; i++){
//            int start = 0;
//            int end = i;
//            if(sums[i] < s)
//                continue;
//            while(start < end){
//                //System.out.println(Integer.toString(start) + " " + Integer.toString(end));
//                int mid = (start + end - 1) / 2;
//                if(sums[i] - sums[mid] >= s)
//                    start = mid + 1;
//                else
//                    end = mid;
//            }
//            res = Math.min(res, i - start + 1);
//
//        }
//        return res == Integer.MAX_VALUE? 0 : res;
//    }
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
