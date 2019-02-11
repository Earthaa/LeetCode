package Binary_Search;

public class LeetCode540_Single_Elemeng_in_Sorted_array {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[left + 1] != nums[left] )
                return nums[left];
            else if(nums[right - 1] != nums[right])
                return nums[right];
            if(nums[mid -1] == nums[mid]){
                if((mid - left) % 2 == 1)
                    left = mid + 1;
                else
                    right = mid;
            }
            else if(nums[mid + 1] == nums[mid]){
                if((mid - left) % 2 == 1)
                    right = mid + 1;
                else
                    left = mid;
            }
            else
                return nums[mid];
        }
        return nums[left];
    }
}
