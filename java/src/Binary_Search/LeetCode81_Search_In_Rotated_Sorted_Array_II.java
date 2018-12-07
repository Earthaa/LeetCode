package Binary_Search;

public class LeetCode81_Search_In_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target)
                return true;
                //if nums[mid..end] is sorted
            else if(nums[mid] < nums[end]) {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            //if nums[start..mid] is sorted
            else if(nums[mid] > nums[end]) {
                if(target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            //can exclude nums[end] because nums[end] == nums[mid]
            else {
                end--;
            }
        }
        return false;
    }
}
