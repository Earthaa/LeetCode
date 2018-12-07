package Binary_Search;

public class LeetCode153_Find_Minimum_inRotated_Sorted_Array {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] >= nums[left]){
                min = Math.min(min,nums[left]);
                left = mid + 1;
            }
            else if(nums[mid] <= nums[right]){
                min = Math.min(min,nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}
