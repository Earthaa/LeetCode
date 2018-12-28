package Two_Pointers;

public class LeetCode487_Max_Consecutive_Ones_II {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0)
            return 0;
        int curNum = 0;
        int preNum = 0;
        int maxNum = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                curNum++;
            else{
                if(i - 1 >= 0 && nums[i - 1] == 1){
                    curNum++;
                    preNum = curNum;
                    curNum = 0;
                }
                else{
                    preNum = 1;
                }
            }
            maxNum = Math.max(maxNum,preNum + curNum);
        }
        return maxNum;
    }
}
