package Tricky;
import java.util.*;
public class LeetCode448_Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] = -nums[index];
        }
        for(int i = 1;i <= nums.length; i++){
            if(nums[i - 1] > 0)
                res.add(i);
        }
        return res;
    }
}
