package Binary_Search;

import java.util.HashMap;

public class LeetCode1014_Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = 0;
        int maxNum = 0;
        for(int i = 0; i < weights.length; i++){
            totalWeight += weights[i];
            maxNum = Math.max(maxNum,weights[i]);
        }
        HashMap
        int right = totalWeight;
        int left = maxNum;
        while(left != right){
            int mid = (left + right) /2;
            int days = getDays(weights, mid);
            if(days <= D)
                right = mid ;
            else
                left = mid + 1;
        }
        return left;
    }
    private int getDays(int[] weights, int capacity){
        int day = 0;
        int index = 0;
        int sum = 0;
        while(index < weights.length){

            while(sum < capacity && index < weights.length){
                sum += weights[index];
                if(sum > capacity)
                    break;
                index++;
            }
            ++day;
            sum = 0;
        }
        return day;
    }
}
