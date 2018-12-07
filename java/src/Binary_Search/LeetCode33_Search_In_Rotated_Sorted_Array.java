package Binary_Search;

public class LeetCode33_Search_In_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] == target || nums[right] == target )
            return target == nums[left] ? left:right;
        int mid = (left + right + 1) / 2;
        while(left < right){
            mid = (left + right + 1) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[left]){
                if(nums[mid] > target && nums[left] <= target)
                    right = mid - 1;
                else
                    left = mid;
            }
            else if(nums[mid] <= nums[right]){
                if(nums[mid] < target && nums[right] >= target)
                    left = mid;
                else
                    right = mid - 1;
            }
        }
        // if(nums[mid] == target)
        //     return mid;
        return -1;
    }
}
