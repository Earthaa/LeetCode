import java.util.*;
public class LeetCode594_Longest_Harmonious_Subsequence {
    public int findLHS(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        int res = 0;
        int totalFirst = 0;
        int totalSecond = 0;
        for(int i = 0; i < nums.length;i++){
            if(firstNum == Integer.MAX_VALUE || nums[i] == firstNum){
                firstNum = nums[i];
                totalFirst++;
            }
            else if(nums[i] == firstNum + 1){
                secondNum = nums[i];
                totalSecond++;
            }
            else if(nums[i] == secondNum + 1){
                if(totalSecond != 0)
                    res = Math.max(res,totalFirst+totalSecond);
                firstNum = secondNum;
                totalFirst = totalSecond;
                secondNum = nums[i];
                totalSecond = 1;
            }
            else{
                if(totalSecond != 0)
                    res = Math.max(res,totalFirst+totalSecond);
                firstNum = nums[i];
                totalFirst = 1;
                secondNum = Integer.MAX_VALUE;
                totalSecond = 0;
            }
            if(totalSecond != 0)
                res = Math.max(res,totalFirst+totalSecond);
        }
        return res;
    }
}
