package Two_Pointers;
import java.util.*;
public class LeetCode259_3Sum_Smaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += twoSumSmaller(nums,i + 1, target - nums[i]);
        }
        return sum;
    }
    private int twoSumSmaller(int[] nums, int start,int target){
        int sum = 0;
        int left = start;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] < target){
                sum += (right - left);
                left++;
            }
            else
                right--;
        }
        return sum;
    }
}
//class Solution {
//    public int threeSumSmaller(int[] nums, int target) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for(int i = 0; i < nums.length; i++){
//            sum += twoSumSmaller(nums,i + 1, target - nums[i]);
//        }
//        return sum;
//    }
//    private int twoSumSmaller(int[] nums, int start,int target){
//        int sum = 0;
//        int left = start;
//        for(;left < nums.length; left++){
//            int right = binarySearch(nums, left, target - nums[left]);
//            sum += (right - left);
//        }
//        return sum;
//    }
//    private int binarySearch(int[] nums, int start, int target){
//        int left = start;
//        int right = nums.length - 1;
//        int mid = (left + right + 1)/2;
//        while(left < right){
//            if(nums[mid] < target){
//                left = mid;
//            }
//            else
//                right = mid - 1;
//            mid = (left + right + 1)/2;
//        }
//        return left;
//    }
//}